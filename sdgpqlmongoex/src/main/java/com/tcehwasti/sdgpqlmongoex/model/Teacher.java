package com.tcehwasti.sdgpqlmongoex.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teachers")
public class Teacher {
    @Id
  private String id;
  private String name;
  private Integer age;

  public Teacher() {
  }

  public Teacher(String id) {
    this.id = id;
  }

  public Teacher(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Teacher [id=" + id + ", name=" + name + ", age=" + age + "]";
  }
}
