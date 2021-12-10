package com.vimal.springboot.parkinglot.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut.Slot;

@Entity
@Table(name="Ticket")
public class ParkingTicket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne(cascade= {
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(name="slot_id")
	private ParkingSlot slot;
	
	@OneToOne(cascade= {
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;
	
	@Column(name="start_timestamp")
	private LocalDateTime startTime;
	
	@Column(name="end_timestamp")
	private LocalDateTime endTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_status")
	private TicketStatus status;
	
	public ParkingTicket() {
		
	}

	public ParkingTicket(ParkingSlot slot, Vehicle vehicle, TicketStatus status) {
		this.slot = slot;
		this.vehicle = vehicle;
		this.startTime = LocalDateTime.now();
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ParkingSlot getSlot() {
		return slot;
	}

	public void setSlot(ParkingSlot slot2) {
		this.slot = slot2;
	}

	public TicketStatus getStatus() {
		return status;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ParkingTicket [id=" + id + ", slot=" + slot + ", vehicle=" + vehicle + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", status=" + status + "]";
	}
}
