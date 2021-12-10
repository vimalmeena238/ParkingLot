package com.vimal.springboot.parkinglot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vimal.springboot.parkinglot.dao.TicketDao;
import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.ParkingTicket;
import com.vimal.springboot.parkinglot.entity.TicketStatus;
import com.vimal.springboot.parkinglot.entity.Vehicle;

@Service
public class TicketServiceImpl implements TicketService {
	
	public TicketDao ticketDao;

	@Autowired
	public TicketServiceImpl(TicketDao ticketDao) {
		super();
		this.ticketDao = ticketDao;
	}

	@Override
	@Transactional
	public ParkingTicket createTicket(Vehicle vehicle, ParkingSlot slot) {
		ParkingTicket ticket = new ParkingTicket();
		ticket.setId(0);
		ticket.setVehicle(vehicle);
		ticket.setStartTime(LocalDateTime.now());
		ticket.setSlot(slot);
		ticket.setStatus(TicketStatus.ACTIVE);
		
		ticket = this.ticketDao.save(ticket);
		return ticket;
	}

	@Override
	public ParkingTicket getTicketById(int ticketId) {
		return this.ticketDao.findById(ticketId);
	}

	@Override
	public void updateTicket(ParkingTicket ticket) {
		this.ticketDao.save(ticket);
	}

}
