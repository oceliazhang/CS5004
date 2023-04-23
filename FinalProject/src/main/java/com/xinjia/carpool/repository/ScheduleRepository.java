package com.xinjia.carpool.repository;

import com.xinjia.carpool.model.Passenger;
import com.xinjia.carpool.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>,
    CrudRepository<Schedule, Long> {

}
