package softwaresurfers.petclinicappointmentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import softwaresurfers.petclinicappointmentsystem.model.DateTime;

@Repository("dateTimeRepository")
public class DateTimeRepositoryImpl implements DateTimeRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DateTime> findByIsActive(boolean isActive) {
		return entityManager.createQuery("from DateTime where isActive = :isActive", DateTime.class)
				.setParameter("isActive", isActive).getResultList();
	}
	
	@Override
	public DateTime findById(int id) {
		return entityManager.find(DateTime.class, id);
	}
	
	@Override
	public DateTime update(DateTime date) {
		return entityManager.merge(date);
	}
}
