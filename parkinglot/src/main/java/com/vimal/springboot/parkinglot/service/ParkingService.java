package com.vimal.springboot.parkinglot.service;

import com.vimal.springboot.parkinglot.entity.ParkingTicket;
import com.vimal.springboot.parkinglot.entity.Vehicle;

public interface ParkingService {
	public ParkingTicket park(Vehicle vehicle);
	public ParkingTicket unpark(int ticketId);
}
