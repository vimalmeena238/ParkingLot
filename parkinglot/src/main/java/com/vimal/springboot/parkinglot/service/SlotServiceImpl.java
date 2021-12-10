package com.vimal.springboot.parkinglot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vimal.springboot.parkinglot.dao.SlotDao;
import com.vimal.springboot.parkinglot.entity.ParkingSlot;
import com.vimal.springboot.parkinglot.entity.SlotStatus;
import com.vimal.springboot.parkinglot.entity.SlotType;

@Service
public class SlotServiceImpl implements SlotService {
	
	private SlotDao slotDao;
	
	@Autowired
	public SlotServiceImpl(SlotDao slotDao) {
		this.slotDao = slotDao;
	}

	@Override
	@Transactional
	public ParkingSlot addParkingSlot(ParkingSlot parkingSlot) {
		parkingSlot.setId(0);
		ParkingSlot slot = this.slotDao.save(parkingSlot);
		return slot;
	}

	@Override
	@Transactional
	public boolean removeParkingSlotById(int id) {
		this.slotDao.deleteById(id);
		return true;
	}

	@Override
	@Transactional
	public List<ParkingSlot> findSlotBySlotType(SlotType slotType) {
		List<ParkingSlot> slots = this.slotDao.findAll();
		
		List<ParkingSlot> slotsById = new ArrayList<>();
		for(ParkingSlot slot : slots) {
			if(slot.getSlotType() == slotType) {
				slotsById.add(slot);
			}
		}
		return slotsById;
	}

	@Override
	@Transactional
	public List<ParkingSlot> findAllAvailableSlots() {
		List<ParkingSlot> slots = this.slotDao.findAll();
		
		List<ParkingSlot> avaiableSlots = new ArrayList<>();
		for(ParkingSlot slot : slots) {
			if(slot.isAvailable()) {
				avaiableSlots.add(slot);
			}
		}
		return avaiableSlots;	
	}

	@Override
	@Transactional
	public ParkingSlot reserveSlot(int slotId) {
		ParkingSlot slot = this.slotDao.findById(slotId);;
		if(slot.isAvailable()) {
			slot.setSlotStatus(SlotStatus.RESERVED);
		}
		
		slot = this.slotDao.save(slot);
		return slot;
	}

	@Override
	@Transactional
	public void markSlotAvailable(int slotId) {
		ParkingSlot slot = this.slotDao.findById(slotId);
		
		slot.setSlotStatus(SlotStatus.AVAILABLE);
		this.slotDao.save(slot);
	}
	
	@Override
	@Transactional
	public List<ParkingSlot> findAllSlots() {
		return this.slotDao.findAll();
	}

}
