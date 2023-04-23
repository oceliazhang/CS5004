package com.xinjia.carpool.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Ride {

  private String destinationAddress;

  @Column(columnDefinition = "TIMESTAMP")
  private LocalDateTime arrivalTime;

  public Ride() {

  }
}
