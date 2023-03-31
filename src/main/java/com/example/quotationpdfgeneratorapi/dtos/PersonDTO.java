package com.example.quotationpdfgeneratorapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PersonDTO {
  private Long id;
  private String name;
  private String phoneNumber;
}
