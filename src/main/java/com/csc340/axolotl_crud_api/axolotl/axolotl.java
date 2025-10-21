package com.csc340.axolotl_crud_api.axolotl;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "axolotls")
public class Axolotl {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long axolotlId;

  
  @Column(nullable = false)
  private String description;
  private String name;
  private String morph;
  private String sex;

  public Axolotl() {

  }

  public Axolotl(Long axolotlId, String name, String description, String morph, String sex) {
    this.axolotlId = axolotlId;
    this.name = name;
    this.description = description;
    this.morph = morph;
    this.sex = sex;
  }

  public Axolotl(String name, String description, String morph, String sex) {
    this.name = name;
    this.description = description;
    this.morph = morph;
    this.sex = sex;
  }

  public Long getAxolotlId() {
    return axolotlId;
  }

  public void setAxolotlId(Long id) {
    this.axolotlId = id;
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
}