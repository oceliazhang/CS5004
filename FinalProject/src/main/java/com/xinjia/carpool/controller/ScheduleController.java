package com.xinjia.carpool.controller;

import com.xinjia.carpool.model.Schedule;
import com.xinjia.carpool.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

  @Autowired
  private ScheduleService scheduleService;

  @PutMapping("/update/{id}")
  public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule, @PathVariable Long id){
    try {
      Schedule updatedSchedule = scheduleService.updateSchedule(schedule, id);
      return ResponseEntity.ok(updatedSchedule);
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }
  }




}
