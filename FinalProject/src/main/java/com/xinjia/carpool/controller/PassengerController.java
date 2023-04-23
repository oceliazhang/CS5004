package com.xinjia.carpool.controller;

import com.xinjia.carpool.model.DTO.FindDriverRequest;
import com.xinjia.carpool.model.Driver;
import com.xinjia.carpool.model.Passenger;
import com.xinjia.carpool.service.DriverService;
import com.xinjia.carpool.service.PassengerService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

  @Autowired
  private DriverService driverService;

  @Autowired
  private PassengerService passengerService;

  @PostMapping("/create")
  public ResponseEntity<Object> createPassenger(@RequestBody Passenger passenger) {
    try {
      Passenger savedPassenger = passengerService.createPassenger(passenger);
      return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }


  @GetMapping("/find-matching-drivers")
  public List<Driver> findMatchingDrivers(@RequestBody FindDriverRequest finddriverRequest) {
    return driverService.findMatchingDrivers(finddriverRequest);
  }

  @PutMapping("/choose-driver/{driverId}")
  public Driver chooseDriver(@PathVariable long driverId, @RequestBody String username) {
    try {
      return passengerService.chooseDriver(username, driverId);
    } catch (Exception e) {
      return null;
    }
  }

  @GetMapping("/get-passenger/{passengerId}")
  public Passenger getPassenger(@PathVariable long passengerId) throws NotFoundException {
    return passengerService.getPassengerById(passengerId);
  }

  @PutMapping("/cancel-ride/{passengerId}")
  public Passenger cancelRide(@PathVariable long passengerId) throws NotFoundException {

    return passengerService.cancelRide(passengerId);
  }


}
