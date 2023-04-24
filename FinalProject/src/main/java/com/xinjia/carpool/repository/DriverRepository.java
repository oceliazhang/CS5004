package com.xinjia.carpool.repository;

import com.xinjia.carpool.model.Driver;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {


  @Query("SELECT DISTINCT d FROM Driver d "
      + "WHERE COALESCE(d.ride.destinationAddress, '') = COALESCE(:destinationAddress, '') "
      + "AND d.ride.arrivalTime BETWEEN :startTime AND :endTime")
  List<Driver> findAllByDestinationAndArrivalTime
      (@Param("destinationAddress") String destinationAddress,
          @Param("startTime") LocalDateTime startTime, @Param("endTime") LocalDateTime endTime);


//  @Query("SELECT d FROM Driver d WHERE d.username = :username")
  Driver findByUsername(String username);
}
