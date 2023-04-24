package com.xinjia.carpool.controller;

import com.xinjia.carpool.model.Driver;
import com.xinjia.carpool.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drivers")
public class DriverController {

  @Autowired
  private final DriverService driverService;

  public DriverController(DriverService driverService) {
    this.driverService = driverService;
  }

  @PostMapping("/create")
//  public Driver createDriver(@RequestBody Driver driver) {
//    return driverService.createDriver(driver);
//  }
  public ResponseEntity<Object> createDriver(@RequestBody Driver driver) {
    try {
      Driver savedDriver = driverService.createDriver(driver);
      return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/cancel-ride")
  public ResponseEntity<Object> cancelRide(@RequestBody String username) {
    try {
      Driver savedDriver = driverService.cancelRide(username);
      return new ResponseEntity<>(savedDriver, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }



  @GetMapping("/{id}")
  public Driver getDriver(@PathVariable Long id) {
    return driverService.getDriverById(id);
  }


}

