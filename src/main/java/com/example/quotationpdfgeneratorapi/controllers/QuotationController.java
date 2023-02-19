package com.example.quotationpdfgeneratorapi.controllers;

import com.example.quotationpdfgeneratorapi.dtos.QuotationRequestDTO;
import com.example.quotationpdfgeneratorapi.services.QuotationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quotation")
public class QuotationController {

  QuotationService quotationService;

  public QuotationController(QuotationService quotationService) {
    this.quotationService = quotationService;
  }

  @PostMapping("/pdf")
  public ResponseEntity<byte[]> getQuotationPdf(@Valid @RequestBody QuotationRequestDTO quotation) {
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/pdf");
    return new ResponseEntity<>(quotationService.getQuotationPdf(quotation), headers, HttpStatus.OK);
  }
}
