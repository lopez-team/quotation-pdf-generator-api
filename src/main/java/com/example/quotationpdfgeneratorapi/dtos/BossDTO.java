package com.example.quotationpdfgeneratorapi.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BossDTO extends PersonDTO {
  @NotNull(message = "The boss profession cannot be null")
  @NotEmpty(message = "The boss profession cannot be empty")
  private String profession;

  @NotNull(message = "The boss email cannot be null")
  @NotEmpty(message = "The boss email cannot be empty")
  private String email;
}
