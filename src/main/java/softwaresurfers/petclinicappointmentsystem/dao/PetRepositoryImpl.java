package softwaresurfers.petclinicappointmentsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import softwaresurfers.petclinicappointmentsystem.model.Pet;


@Repository("petRepository")
public class PetRepositoryImpl implements PetRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Pet findById(int id) {
		return entityManager.find(Pet.class, id);
	}

	@Override 
	public List<Pet> findByUserEmail(String userEmail) {
		/*return entityManager.createQuery("from Pet where user.email = :userEmail", Pet.class)
				.setParameter("userEmail", userEmail).getResultList();*/
		return entityManager.createQuery("from Pet where userEmail = :userEmail", Pet.class)
				.setParameter("userEmail", userEmail).getResultList();
	}

	@Override
	public void create(Pet pet) {
		entityManager.persist(pet);
	}

	@Override
	public Pet update(Pet pet) {
		return entityManager.merge(pet);
	}

	@Override
	public void delete(int id) {
		entityManager.remove(entityManager.getReference(Pet.class, id));
	}

}