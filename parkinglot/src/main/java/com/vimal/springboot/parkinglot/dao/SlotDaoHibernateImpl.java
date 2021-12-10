package com.vimal.springboot.parkinglot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vimal.springboot.parkinglot.entity.ParkingSlot;

@Repository
public class SlotDaoHibernateImpl implements SlotDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public SlotDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<ParkingSlot> findAll() {
		Query query = entityManager.createQuery("from ParkingSlot", ParkingSlot.class);
		
		@SuppressWarnings("unchecked")
		List<ParkingSlot> slots = query.getResultList();
		return slots;
	}

	@Override
	public ParkingSlot findById(int id) {
		return this.entityManager.find(ParkingSlot.class, id);
	}

	@Override
	public ParkingSlot save(ParkingSlot parkingSlot) {
		ParkingSlot dbSlot = this.entityManager.merge(parkingSlot);
		return dbSlot;
	}

	@Override
	public void deleteById(int id) {
		Query query = 
				this.entityManager.createQuery("delete from ParkingSlot p where p.id=:slotId", ParkingSlot.class);
		
		query.setParameter("slotId", id);
		query.executeUpdate();
	}

}
