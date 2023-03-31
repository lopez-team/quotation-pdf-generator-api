package com.example.quotationpdfgeneratorapi.dtos;

import com.example.quotationpdfgeneratorapi.entities.MeasurementUnit;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class ItemDTO {
  @NotNull(message = "The quantity of the item cannot be null")
  private Double quantity;

  @NotNull(message = "The measurement unit cannot be null.")
  private MeasurementUnit measurementUnit;

  private String description;

  @NotNull(message = "The price cannot be null")
  private BigDecimal price;

  private BigDecimal total;
}
