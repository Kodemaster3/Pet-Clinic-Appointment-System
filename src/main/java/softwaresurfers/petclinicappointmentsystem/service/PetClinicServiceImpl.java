package softwaresurfers.petclinicappointmentsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import softwaresurfers.petclinicappointmentsystem.dao.AppointmentRepository;
import softwaresurfers.petclinicappointmentsystem.dao.DateTimeRepository;
import softwaresurfers.petclinicappointmentsystem.dao.PetRepository;
import softwaresurfers.petclinicappointmentsystem.model.Appointment;
import softwaresurfers.petclinicappointmentsystem.model.DateTime;
import softwaresurfers.petclinicappointmentsystem.model.Pet;



@Service
@Transactional(rollbackFor = Exception.class)
public class PetClinicServiceImpl implements PetClinicService {
	
	private PetRepository petRepository;
	private AppointmentRepository appointmentRepository;
	private DateTimeRepository dateTimeRepository;
	
	@Autowired
	public void setPetRepository(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	@Autowired
	public void setAppointmentRepository(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	@Autowired
	public void setDateTimeRepository(DateTimeRepository dateTimeRepository) {
		this.dateTimeRepository = dateTimeRepository;
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Pet> findPets(String userEmail) {
		return petRepository.findByUserEmail(userEmail);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Pet findPet(int id) {
		Pet pet = petRepository.findById(id);
		
		return pet;
	}

	@Override
	public void createPet(Pet pet) {
		petRepository.create(pet);
	}

	@Override
	public void updatePet(Pet pet) {
		petRepository.update(pet);
	}

	@Override
	public void deletePet(int id) {
		petRepository.delete(id);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Appointment> findAllAppointments() {
		return appointmentRepository.findAll();
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Appointment> findMyAppointments(String userEmail) {
		return appointmentRepository.findByUserEmail(userEmail);
	}
	
	@Override
	public void createAppointment(Appointment appointment) {
		appointmentRepository.create(appointment);
	}
	
	@Override
	public void updateAppointment(Appointment appointment) {
		appointmentRepository.update(appointment);
	}
	
	@Override
	public void deleteAppointment(int id) {
		appointmentRepository.delete(id);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DateTime> findActiveDates(boolean isActive) {
		return dateTimeRepository.findByIsActive(isActive);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DateTime findDate(int id) {
		return dateTimeRepository.findById(id);
	}
	
	@Override
	public void updateDate(DateTime date) {
		dateTimeRepository.update(date);
	}
}
