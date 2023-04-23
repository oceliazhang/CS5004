package com.xinjia.carpool.model.DTO;

import com.xinjia.carpool.model.Car;
import com.xinjia.carpool.model.CarFeature;
import com.xinjia.carpool.model.Gender;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class FindDriverRequest {
  private String destinationAddress;
  private LocalDateTime arrivalTime;
  private Integer numOfPeople;
  private List<CarFeature> carPreferences;
}
