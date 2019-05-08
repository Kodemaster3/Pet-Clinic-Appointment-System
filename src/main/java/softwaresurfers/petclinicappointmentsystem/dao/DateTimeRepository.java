package softwaresurfers.petclinicappointmentsystem.dao;

import java.util.List;

import softwaresurfers.petclinicappointmentsystem.model.DateTime;

public interface DateTimeRepository {
	List<DateTime> findByIsActive(boolean isActive);
	DateTime findById(int id);
	DateTime update(DateTime date);
}
