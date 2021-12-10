package com.vimal.springboot.parkinglot.service;

import java.util.List;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.SlotType;

public interface SlotService {
	
	public ParkingSlot addParkingSlot(ParkingSlot parkingSlot);
	
	public boolean removeParkingSlotById(int id);
	
	public void markSlotAvailable(int slotId);
	
	public List<ParkingSlot> findSlotBySlotType(SlotType slotType);
	
	public List<ParkingSlot> findAllAvailableSlots();
	
	public ParkingSlot reserveSlot(int slotId);
	
	public List<ParkingSlot> findAllSlots();
}
