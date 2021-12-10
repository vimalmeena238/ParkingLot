package com.vimal.springboot.parkinglot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.ParkingTicket;
import com.vimal.springboot.parkinglot.entity.Vehicle;
import com.vimal.springboot.parkinglot.service.ParkingService;
import com.vimal.springboot.parkinglot.service.SlotService;

@RestController
@RequestMapping("/api/v1")
public class ParkingRestController {
	private SlotService slotService;
	private ParkingService parkingService;

	@Autowired
	public ParkingRestController(SlotService slotService, ParkingService parkingService) {
		this.slotService = slotService;
		this.parkingService = parkingService;
	}	
	
	@GetMapping("/slots")
	public List<ParkingSlot> getAllSlots() {
		return this.slotService.findAllSlots();
	}
	
	@PostMapping("/slots")
	public ParkingSlot addParkingSlot(@RequestBody ParkingSlot parkingSlot)
	{
		ParkingSlot slot = this.slotService.addParkingSlot(parkingSlot);
		return slot;
	}
	
	@DeleteMapping("/slots/{slotId}")
	public boolean deleteSlotById(@PathVariable int slotId) {
		return this.slotService.removeParkingSlotById(slotId);
	}
	
	@PostMapping("/park")
	public ParkingTicket parkMyVehicle(@RequestBody Vehicle vehicle) {
		return this.parkingService.park(vehicle);
	}
	
	@GetMapping("/unpark/{ticketId}")
	public ParkingTicket unParkVehicle(@PathVariable int ticketId)
	{
		return this.parkingService.unpark(ticketId);
	}
}
