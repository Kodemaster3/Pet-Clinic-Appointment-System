package softwaresurfers.petclinicappointmentsystem.dao;

import java.util.List;

import softwaresurfers.petclinicappointmentsystem.model.Appointment;

public interface AppointmentRepository {
	List<Appointment> findAll();
	List<Appointment> findByUserEmail(String userEmail);
	void create(Appointment appointment);
	Appointment update(Appointment appointment);
	void delete(int id);
}
