package com.example.quotationpdfgeneratorapi.services;

import com.example.quotationpdfgeneratorapi.dtos.QuotationRequestDTO;
import com.example.quotationpdfgeneratorapi.entities.Quotation;
import com.example.quotationpdfgeneratorapi.repositories.QuotationRepository;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
public class QuotationService {

  QuotationRepository quotationRepository;

  public QuotationService(QuotationRepository quotationRepository) {
    this.quotationRepository = quotationRepository;
  }

  public byte[] getQuotationPdf(QuotationRequestDTO quotation) {

    Optional<Quotation> quotationInRepo = quotationRepository.findById(quotation.getQuotation().getId());
    if (quotationInRepo.isPresent()) {
      log.info("That quotation already exists in database");
    }
  }
}
