package com.xinjia.carpool.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DriverRepositoryTest {

  @Autowired
  private DriverRepository driverRepository;

  @Test
  public void findAllByDestinationAndArrivalTime() {


    Assertions.assertTrue(true);
  }
}