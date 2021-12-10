package com.vimal.springboot.parkinglot.service;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.Vehicle;

public interface ParkingSlotAssignmentStrategy {
	public ParkingSlot assignSlot(Vehicle vehicle);
}
