package com.example.quotationpdfgeneratorapi.services;

import com.example.quotationpdfgeneratorapi.config.PdfConfig;
import com.example.quotationpdfgeneratorapi.dtos.ItemDTO;
import com.example.quotationpdfgeneratorapi.dtos.QuotationDTO;
import com.example.quotationpdfgeneratorapi.dtos.QuotationRequestDTO;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service @Slf4j
public class QuotationService {

  TemplateEngine thymeleaf;
  PdfConfig pdfConfig;

  public QuotationService(PdfConfig pdfConfig) {
    thymeleaf = new TemplateEngine();
    this.pdfConfig = pdfConfig;
  }

  public byte[] getQuotationPdf(QuotationRequestDTO quotation) {

    Context ctx = new Context();
    ctx.setVariable("boss", quotation.getBoss());
    ctx.setVariable("client", quotation.getClient());
    processQuotationPrices(quotation.getQuotation());
    ctx.setVariable("quotation", quotation.getQuotation());
    ctx.setVariable("items", quotation.getQuotation().getItems());

    String template = pdfConfig.loadResourceString("templates/quotation-template.xhtml");

    String html = thymeleaf.process(template, ctx);

    try(ByteArrayOutputStream os = new ByteArrayOutputStream()) {
      PdfRendererBuilder builder = new PdfRendererBuilder();
      builder.withHtmlContent(html, QuotationService.class.getResource("/root.htm").toExternalForm());
      builder.useFastMode();
      builder.toStream(os);
      builder.run();
      return os.toByteArray();
    } catch (IOException e) {
      log.info("Unable to generate the pdf", e);
      return null;
    }
  }

  private void processQuotationPrices(QuotationDTO quotationDTO) {
    quotationDTO.getItems().forEach(x-> x.setTotal(x.getPrice().multiply(BigDecimal.valueOf(x.getQuantity()))));

    BigDecimal subtotal = quotationDTO.getItems().stream()
        .map(ItemDTO::getTotal)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    quotationDTO.setSubTotal(subtotal);

    BigDecimal iva = subtotal.multiply(BigDecimal.valueOf(0.18));
    quotationDTO.setIva(iva);
    quotationDTO.setGrandTotal(subtotal.add(iva));

  }
}
