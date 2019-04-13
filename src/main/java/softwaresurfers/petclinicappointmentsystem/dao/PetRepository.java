package softwaresurfers.petclinicappointmentsystem.dao;

import java.util.List;

import softwaresurfers.petclinicappointmentsystem.model.Pet;


public interface PetRepository {
	Pet findById(int id);
	List<Pet> findByUserEmail(String userEmail);
	void create(Pet pet);
	Pet update(Pet pet);
	void delete(int id);
}