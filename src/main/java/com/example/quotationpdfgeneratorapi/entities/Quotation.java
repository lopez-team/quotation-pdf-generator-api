package com.example.quotationpdfgeneratorapi.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Quotation {
  private Long id;
  private LocalDate date;
  private List<Item> items;
  private String termsAndConditions;

  public Quotation() {
  }

  public List<Item> getItems() {
    return items;
  }

  public Quotation setItems(
      List<Item> items) {
    this.items = items;
    return this;
  }
}
