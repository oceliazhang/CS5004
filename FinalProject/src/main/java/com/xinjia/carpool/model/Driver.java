package com.xinjia.carpool.model;

import java.math.BigDecimal;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table
@Getter
@Setter
public class Driver extends User implements Comparable<Driver> {

  @OneToOne
  @JoinColumn(name = "car_id")
  private Car car;

  @Column
  private BigDecimal rating;

  @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
  private List<Schedule> itinerary;

  @Column
  private Integer matchWeight = 0;

  @Embedded
  private Ride ride;

  public Driver() {

  }

  public void addSchedule(Schedule schedule) {
    itinerary.add(schedule);
  }

  /**
   * Compares this Driver object with another Driver object based on their match weights.
   * The comparison is based on the matchWeight field of each object.
   *
   * @param other the other Driver object to be compared with this one
   * @return a negative integer, zero, or a positive integer as this Driver object is less than,
   *         equal to, or greater than the specified object, respectively
   */
  @Override
  public int compareTo(Driver other) {
    return Integer.compare(this.matchWeight, other.getMatchWeight());
  }

  public void removeSchedule(Schedule schedule) {
    itinerary.remove(schedule);
  }
}
