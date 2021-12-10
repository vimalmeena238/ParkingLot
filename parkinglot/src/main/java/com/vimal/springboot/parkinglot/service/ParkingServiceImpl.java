package com.vimal.springboot.parkinglot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.ParkingTicket;
import com.vimal.springboot.parkinglot.entity.TicketStatus;
import com.vimal.springboot.parkinglot.entity.Vehicle;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	private SlotService slotService;
	private ParkingSlotAssignmentStrategy parkingStrategy;
	private TicketService ticketService;
	
	@Autowired
	public ParkingServiceImpl(ParkingSlotAssignmentStrategy parkingStrategy, 
							  TicketService ticketService,
							  SlotService slotService) {
		this.parkingStrategy = parkingStrategy;
		this.ticketService = ticketService;
		this.slotService = slotService;
	}
	
	@Override
	public ParkingTicket park(Vehicle vehicle) {
		ParkingSlot assignedSlot = this.parkingStrategy.assignSlot(vehicle);
		
		if(assignedSlot == null) {
			throw new RuntimeException("No slots available");
		}
		
		ParkingTicket ticket = this.ticketService.createTicket(vehicle, assignedSlot);
		return ticket;
	}
	
	@Override
	public ParkingTicket unpark(int ticketId) {
		ParkingTicket ticket = this.ticketService.getTicketById(ticketId);
		ticket.setEndTime(LocalDateTime.now());
		ticket.setStatus(TicketStatus.COMPLETED);
		this.ticketService.updateTicket(ticket);
		this.slotService.markSlotAvailable(ticket.getSlot().getId());
		return ticket;
	}

}
