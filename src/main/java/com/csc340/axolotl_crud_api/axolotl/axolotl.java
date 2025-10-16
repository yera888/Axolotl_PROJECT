package com.csc340.axolotl_crud_api.axolotl;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "axolotls")
public class Axolotl {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long animalId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, length = 2000)
  private String description;

  // This will be our “category” for the assignment (like breed/species).
  private String morph;

  private double age;                 // years (can be fractional)
  private LocalDate activeDate;       // when you added / last saw it, etc.

  public Axolotl() {}

  public Axolotl(Long animalId, String name, String description,
                 String morph, double age, LocalDate activeDate) {
    this.animalId = animalId;
    this.name = name;
    this.description = description;
    this.morph = morph;
    this.age = age;
    this.activeDate = activeDate;
  }

  public Axolotl(String name, String description,
                 String morph, double age, LocalDate activeDate) {
    this.name = name;
    this.description = description;
    this.morph = morph;
    this.age = age;
    this.activeDate = activeDate;
  }

  public Long getAnimalId() {
    return animalId;
  }

  public void setAnimalId(Long animalId) {
    this.animalId = animalId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getMorph() {
    return morph;
  }

  public void setMorph(String morph) {
    this.morph = morph;
  }

  public double getAge() {
    return age;
  }

  public void setAge(double age) {
    this.age = age;
  }

  public LocalDate getActiveDate() {
    return activeDate;
  }

  public void setActiveDate(LocalDate activeDate) {
    this.activeDate = activeDate;
  }
}
