package com.xinjia.carpool.model;

import java.util.List;
import javax.persistence.*;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String make;
  @Column
  private String model;
  @Column
  private Integer numSeats;
  @Column
  private Integer numLuggage;
  @Column
  private String color;
  @Column
  private String licensePlate;

//  @OneToOne
//  @JoinColumn(name = "driver_id")
//  private Driver driver;

  @ElementCollection
  private List<CarFeature> carFeatures;

}
