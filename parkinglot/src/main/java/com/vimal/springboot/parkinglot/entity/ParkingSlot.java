package com.vimal.springboot.parkinglot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Slot")
public class ParkingSlot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="slot_type")
	@Enumerated(EnumType.STRING)
	private SlotType slotType;
	
	@Column(name="slot_status")
	@Enumerated(EnumType.STRING)
	private SlotStatus slotStatus;
	
	public ParkingSlot() {
		
	}
	
	public ParkingSlot(SlotType slotType, SlotStatus slotStatus) {
		this.slotType = slotType;
		this.slotStatus = slotStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SlotType getSlotType() {
		return slotType;
	}

	public void setSlotType(SlotType slotType) {
		this.slotType = slotType;
	}

	public SlotStatus getSlotStatus() {
		return slotStatus;
	}

	public void setSlotStatus(SlotStatus slotStatus) {
		this.slotStatus = slotStatus;
	}
	
	public boolean isAvailable() {
		return this.slotStatus == SlotStatus.AVAILABLE;
	}
	
	@Override
	public String toString() {
		return "ParkingSlot [id=" + id + ", slotType=" + slotType + ", slotStatus="
				+ slotStatus + "]";
	}
}
