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
@Table(name="Vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="licence_no")
	private String licenceNo;
	
	@Column(name="vehicle_type")
	@Enumerated(EnumType.STRING)
	private VehicleType vehicleType;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Vehicle() {
		
	}
	
	public Vehicle(String licenceNo, VehicleType vehicleType) {
		super();
		this.licenceNo = licenceNo;
		this.vehicleType = vehicleType;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", licenceNo=" + licenceNo + ", vehicleType=" + vehicleType + "]";
	}
	
}
