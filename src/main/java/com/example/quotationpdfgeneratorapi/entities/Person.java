package com.example.quotationpdfgeneratorapi.entities;

public class Person {
  private Long id;
  private String name;
  private String phoneNumber;

  public Person(Long id, String name, String phoneNumber) {
    this.id = id;
    this.name = name;
    this.phoneNumber = phoneNumber;
  }

  public Person() {}

  public Long getId() {
    return id;
  }

  public Person setId(Long id) {
    this.id = id;
    return this;
  }

  public String getName() {
    return name;
  }

  public Person setName(String name) {
    this.name = name;
    return this;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public Person setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }
}
