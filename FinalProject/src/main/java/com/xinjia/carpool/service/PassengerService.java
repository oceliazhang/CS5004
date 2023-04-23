package com.xinjia.carpool.service;

import com.xinjia.carpool.model.Driver;
import com.xinjia.carpool.model.Passenger;
import com.xinjia.carpool.model.Schedule;
import com.xinjia.carpool.repository.DriverRepository;
import com.xinjia.carpool.repository.PassengerRepository;
import com.xinjia.carpool.repository.ScheduleRepository;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

  @Autowired
  private PassengerRepository passengerRepository;

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private DriverRepository driverRepository;

  @Transactional
  public Passenger createPassenger(Passenger passenger) {
    // check if the username already exists
    if (passengerRepository.findByUsername(passenger.getUsername()) != null) {
      throw new IllegalArgumentException("Username already exists");
    }
    Schedule schedule = new Schedule();
    passenger.setSchedule(schedule);
    passengerRepository.save(passenger);

    schedule.setPassenger(passenger);
    scheduleRepository.save(schedule);

    return passenger;
  }

  public Passenger getPassengerById(long passengerId) {
    return passengerRepository.findById(passengerId).orElse(null);
  }

  public Passenger savePassenger(Passenger passenger) {
    return passengerRepository.save(passenger);
  }

  public Driver chooseDriver(String username, Long driverId) throws NotFoundException {
    Passenger passenger = passengerRepository.findByUsername(username);
    if (passenger == null) {
      throw new NotFoundException();
    }
    Schedule schedule = passenger.getSchedule();
    if (schedule == null) {
      throw new NotFoundException();
    }
    Driver driver = driverRepository.findById(driverId).orElse(null);
    if (driver == null) {
      throw new NotFoundException();
    }
    if (driver.getCar().getNumSeats() < passenger.getNumOfPeople()) {
      throw new IllegalArgumentException("Not enough seats");
    }
    schedule.setDriver(driver);
    driver.addSchedule(schedule);
    Integer numSeats = driver.getCar().getNumSeats();
    numSeats -= passenger.getNumOfPeople();
    driver.getCar().setNumSeats(numSeats);
    driverRepository.save(driver);
    scheduleRepository.save(schedule);
    passengerRepository.save(passenger);

    Driver myDriver = new Driver();
    BeanUtils.copyProperties(driver, myDriver, "password", "itinerary", "matchWeight", "ride");

    return myDriver;
  }

  public Passenger cancelRide(Long passengerId) throws NotFoundException {
    Passenger passenger = passengerRepository.findById(passengerId).orElse(null);
    if (passenger == null) {
      throw new NotFoundException();
    }
    if (passenger.getSchedule() == null) {
      return passenger;
    }
    // cancel the ride by removing the passenger from the driver's schedule
    Driver driver = passenger.getSchedule().getDriver();
    driver.removeSchedule(passenger.getSchedule());
    Integer numSeats = driver.getCar().getNumSeats();
    numSeats += passenger.getSchedule().getPassenger().getNumOfPeople();
    driver.getCar().setNumSeats(numSeats);
    driverRepository.save(driver);

    Schedule schedule = passenger.getSchedule();
    Schedule nullSchedule = new Schedule();
    BeanUtils.copyProperties(nullSchedule, schedule, "id", "passenger");
    scheduleRepository.save(schedule);

    return passenger;
  }
}
