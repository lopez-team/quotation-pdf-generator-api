package com.example.quotationpdfgeneratorapi.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class QuotationRequestDTO {

  @NotNull(message = "The boss cannot be null")
  private BossDTO boss;

  @NotNull(message = "The client data cannot be null")
  private ClientDTO client;

  @NotNull(message = "The quotation data cannot be null")
  private QuotationDTO quotation;
}
