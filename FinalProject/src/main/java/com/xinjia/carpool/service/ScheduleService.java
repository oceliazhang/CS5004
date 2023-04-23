package com.xinjia.carpool.service;

import com.xinjia.carpool.model.Passenger;
import com.xinjia.carpool.model.Schedule;
import com.xinjia.carpool.repository.PassengerRepository;
import com.xinjia.carpool.repository.ScheduleRepository;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

  @Autowired
  private ScheduleRepository scheduleRepository;

  @Autowired
  private PassengerRepository passengerRepository;

  public Schedule updateSchedule(Schedule schedule, Long passengerId){
    Optional<Passenger> passenger = passengerRepository.findById(passengerId);
    if(!passenger.isPresent()){
      throw new IllegalArgumentException("Passenger does not exist");
    }

    Schedule oldSchedule = passenger.get().getSchedule();
    BeanUtils.copyProperties(schedule, oldSchedule, "id", "passenger");
    return scheduleRepository.save(oldSchedule);
  }
}
