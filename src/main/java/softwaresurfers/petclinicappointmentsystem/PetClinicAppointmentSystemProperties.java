package softwaresurfers.petclinicappointmentsystem;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="petclinicappointmentsystem")
public class PetClinicAppointmentSystemProperties {
private boolean displayPetClinicAppointmentSystem = false;
	
	public boolean isDisplayPetClinicAppointmentSystem() {
		return displayPetClinicAppointmentSystem;
	}
	
	public void setDisplayPetClinicAppointmentSystem(boolean displayPetClinicAppointmentSystem) {
		this.displayPetClinicAppointmentSystem = displayPetClinicAppointmentSystem;
	}
}