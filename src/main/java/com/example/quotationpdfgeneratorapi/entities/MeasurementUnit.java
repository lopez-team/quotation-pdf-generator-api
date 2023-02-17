package com.example.quotationpdfgeneratorapi.entities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum MeasurementUnit {
  M("m"," (metros)"),
  M2("m2"," (metros cuadrados)"),
  M3("m3"," (metros cúbicos)"),
  GL("gl", " (galones)"),
  L("l", " (litros)"),
  U("c/u", " (unidad)");

  private final String symbol;
  private final String description;

  MeasurementUnit(String symbol, String description) {
    this.symbol = symbol;
    this.description = description;
  }

  public MeasurementUnit getMeasurementUnit(String value) {
      for (MeasurementUnit unit : values()) {
        if (unit.getSymbol().equalsIgnoreCase(value)) {
          return unit;
        }
        log.info("The measurement unit {} does not exits", unit);
      }
      return null;
  }

  public String toString() {
    return getSymbol() + getDescription();
  }

  public String getSymbol() {
    return this.symbol;
  }

  public String getDescription() {
    return this.description;
  }
}
