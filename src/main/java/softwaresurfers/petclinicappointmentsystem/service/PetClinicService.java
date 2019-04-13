package softwaresurfers.petclinicappointmentsystem.service;

import java.util.List;

import softwaresurfers.petclinicappointmentsystem.model.Appointment;
import softwaresurfers.petclinicappointmentsystem.model.DateTime;
import softwaresurfers.petclinicappointmentsystem.model.Pet;


public interface PetClinicService {
	
	List<Pet> findPets(String userEmail);
	Pet findPet(int id);
	void createPet(Pet pet);
	void updatePet(Pet pet);
	void deletePet(int id);
	
	List<Appointment> findAllAppointments();
	List<Appointment> findMyAppointments(String userEmail);
	void createAppointment(Appointment appointment);
	void updateAppointment(Appointment appointment);
	void deleteAppointment(int id);
	
	List<DateTime> findActiveDates(boolean isActive);
	DateTime findDate(int id);
	void updateDate(DateTime date);
	
}
