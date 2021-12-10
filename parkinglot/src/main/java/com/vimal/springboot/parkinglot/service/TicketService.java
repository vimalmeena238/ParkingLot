package com.vimal.springboot.parkinglot.service;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.ParkingTicket;
import com.vimal.springboot.parkinglot.entity.Vehicle;

public interface TicketService {
	public ParkingTicket createTicket(Vehicle vehicle, ParkingSlot slot);
	public ParkingTicket getTicketById(int ticketId);
	public void updateTicket(ParkingTicket ticket);
}
