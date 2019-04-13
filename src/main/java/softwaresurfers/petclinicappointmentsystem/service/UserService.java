package softwaresurfers.petclinicappointmentsystem.service;

import softwaresurfers.petclinicappointmentsystem.model.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(User user);
}
