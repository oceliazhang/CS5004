package com.xinjia.carpool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
public class Passenger extends User {
  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<CarFeature> carPreferences;

  @Column
  private Integer numOfPeople;

  @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
  @JsonIgnore
  private Schedule schedule;

  public Passenger() {

  }

}
