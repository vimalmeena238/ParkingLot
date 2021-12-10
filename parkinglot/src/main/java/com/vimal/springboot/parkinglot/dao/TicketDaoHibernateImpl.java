package com.vimal.springboot.parkinglot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vimal.springboot.parkinglot.entity.ParkingTicket;

@Repository
public class TicketDaoHibernateImpl implements TicketDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public TicketDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<ParkingTicket> findAll() {
		Query query = entityManager.createQuery("from ParkingTicket", ParkingTicket.class);
		
		@SuppressWarnings("unchecked")
		List<ParkingTicket> tickets = query.getResultList();
		return tickets;
	}

	@Override
	@Transactional
	public ParkingTicket save(ParkingTicket parkingTicket) {
		ParkingTicket dbTicket = this.entityManager.merge(parkingTicket);
		return dbTicket;
	}

	@Override
	@Transactional
	public ParkingTicket findById(int id) {
		return this.entityManager.find(ParkingTicket.class, id);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Query query = 
				this.entityManager.createQuery("delete from ParkingTicket p where p.id=:ticketId", ParkingTicket.class);
		
		query.setParameter("ticketId", id);
		query.executeUpdate();
	}

}
