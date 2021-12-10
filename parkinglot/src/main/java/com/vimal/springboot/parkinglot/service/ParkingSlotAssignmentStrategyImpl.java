package com.vimal.springboot.parkinglot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.SlotType;
import com.vimal.springboot.parkinglot.entity.Vehicle;
import com.vimal.springboot.parkinglot.entity.VehicleType;

@Service
public class ParkingSlotAssignmentStrategyImpl implements ParkingSlotAssignmentStrategy {
	
	private SlotService slotService;
	
	@Autowired
	public ParkingSlotAssignmentStrategyImpl(SlotService slotService) {
		this.slotService = slotService;
	}
	
	@Override
	public ParkingSlot assignSlot(Vehicle vehicle) {
		
		List<ParkingSlot> slots = null;
		
		if(vehicle.getVehicleType() == VehicleType.TWOWHEELER)
		{
			slots = this.slotService.findSlotBySlotType(SlotType.MEDIUM);
		}
		else if(vehicle.getVehicleType() == VehicleType.FOURWHEELER) {
			slots = this.slotService.findSlotBySlotType(SlotType.LARGE);
		}
		
		if(slots == null)
		{
			throw new RuntimeException("No slot available");
		}
		
		
		ParkingSlot assignedSlot = null;
		for(ParkingSlot slot : slots) {
			if(slot.isAvailable()) {
				assignedSlot = this.slotService.reserveSlot(slot.getId());
				break;
			}
		}
		return assignedSlot;		
	}

}
