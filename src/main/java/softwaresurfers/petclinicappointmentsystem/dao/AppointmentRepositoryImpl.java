package softwaresurfers.petclinicappointmentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import softwaresurfers.petclinicappointmentsystem.model.Appointment;


@Repository("appointmentRepository")
public class AppointmentRepositoryImpl implements AppointmentRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Appointment> findAll() {
		return entityManager.createQuery("from Appointment", Appointment.class).getResultList();
	}

	@Override 
	public List<Appointment> findByUserEmail(String userEmail) {
		return entityManager.createQuery("from Appointment where userEmail = :userEmail", Appointment.class)
				.setParameter("userEmail", userEmail).getResultList();
	}

	@Override
	public void create(Appointment appointment) {
		entityManager.persist(appointment);
	}
	
	@Override
	public Appointment update(Appointment appointment) {
		return entityManager.merge(appointment);
	}
	
	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.getReference(Appointment.class, id));
	}

}
