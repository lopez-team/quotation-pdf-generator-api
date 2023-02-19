package com.example.quotationpdfgeneratorapi.dtos;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class QuotationDTO {

  @NotNull(message = "The id of the quotation cannot be null")
  private Long id;

  @NotNull(message = "The date of the quotation cannot not be null")
  private LocalDate date;

  @NotNull(message = "The list of items cannot be null")
  private List<ItemDTO> items;

  private BigDecimal iva;
  private BigDecimal subTotal;
  private BigDecimal grandTotal;

  private String termsAndConditions;
}
