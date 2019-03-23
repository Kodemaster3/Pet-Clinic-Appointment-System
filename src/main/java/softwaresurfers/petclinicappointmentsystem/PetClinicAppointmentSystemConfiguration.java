package softwaresurfers.petclinicappointmentsystem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetClinicAppointmentSystemConfiguration {
	@Autowired
	private PetClinicAppointmentSystemProperties petClinicAppointmentSystemProperties;
	
	@PostConstruct
	public void init() {
		System.out.println("Display pet clinic appointment system: " + petClinicAppointmentSystemProperties.isDisplayPetClinicAppointmentSystem());
	}
}
