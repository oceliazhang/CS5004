package com.xinjia.carpool.model;


import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@Inheritance (strategy = InheritanceType.JOINED)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long ID;

  @Column
  private String name;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Column
  private String note;

  @Column
  private String phone;

  @Column(unique = true)
  private String username;

  @Column
  private String password;

  public User() {

  }
}

