package com.example.quotationpdfgeneratorapi.controllers;

import com.example.quotationpdfgeneratorapi.dtos.QuotationRequestDTO;
import com.example.quotationpdfgeneratorapi.services.QuotationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  @GetMapping("/pdf")
  public ResponseEntity<byte[]> getQuotationPdf(@Valid @RequestBody QuotationRequestDTO quotation) {
    return new ResponseEntity<>(quotationService.getQuotationPdf(quotation), HttpStatus.OK);
  }
}
