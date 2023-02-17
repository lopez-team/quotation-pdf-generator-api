package com.example.quotationpdfgeneratorapi.entities;

import java.math.BigDecimal;

public class Item {
  private Double quantity;
  private MeasurementUnit measurementUnit;
  private String description;
  private BigDecimal price;
  private BigDecimal total;

  public Item() {
  }

  public Double getQuantity() {
    return quantity;
  }

  public Item setQuantity(Double quantity) {
    this.quantity = quantity;
    return this;
  }

  public MeasurementUnit getMeasurementUnit() {
    return measurementUnit;
  }

  public Item setMeasurementUnit(
      MeasurementUnit measurementUnit) {
    this.measurementUnit = measurementUnit;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Item setDescription(String description) {
    this.description = description;
    return this;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public Item setPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public Item setTotal(BigDecimal total) {
    this.total = total;
    return this;
  }
}
