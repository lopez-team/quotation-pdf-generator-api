package com.example.quotationpdfgeneratorapi.entities;

public class Boss extends Person {
  private String profession;
  private String email;

  public Boss(Long id, String name, String phoneNumber, String profession, String email) {
    super(id, name, phoneNumber);
    this.profession = profession;
    this.email = email;
  }

  public Boss() {
  }

  public String getProfession() {
    return profession;
  }

  public Boss setProfession(String profession) {
    this.profession = profession;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Boss setEmail(String email) {
    this.email = email;
    return this;
  }
}
