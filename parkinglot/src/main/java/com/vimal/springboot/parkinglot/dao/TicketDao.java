package com.vimal.springboot.parkinglot.dao;

import java.util.List;

import com.vimal.springboot.parkinglot.entity.ParkingTicket;

public interface TicketDao {
	public List<ParkingTicket> findAll();
	public ParkingTicket save(ParkingTicket parkingTicket);
	public ParkingTicket findById(int id);
	public void deleteById(int id);
}
