package com.vimal.springboot.parkinglot.dao;

import java.util.List;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;

public interface SlotDao {
	
	public List<ParkingSlot> findAll();
	public ParkingSlot findById(int id);
	public ParkingSlot save(ParkingSlot parkingSlot);
	public void deleteById(int id);
}
