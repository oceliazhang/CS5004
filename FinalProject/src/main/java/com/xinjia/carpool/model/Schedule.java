package com.xinjia.carpool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "schedule")
@Getter
@Setter
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "pickup_address_id", referencedColumnName = "id")
//  private Address pickupAddress;
//
//  @OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "destination_address_id", referencedColumnName = "id")
//  private Address destinationAddress;

  @Column
  private String pickupAddress;

  @Column
  private String destinationAddress;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime pickupTime;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime arrivalTime;

  @ManyToOne
  @JsonIgnore
  private Driver driver;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "passenger_id", referencedColumnName = "id")
  @JsonIgnore
  private Passenger passenger;
}

