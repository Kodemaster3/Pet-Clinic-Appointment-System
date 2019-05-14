package softwaresurfers.petclinicappointmentsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import softwaresurfers.petclinicappointmentsystem.service.PetClinicService;

@Controller
public class MyAppointmentsController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping("/home/myappointments")
	public ModelAndView getMyAppointments(Authentication authentication) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("myappointments", petClinicService.findMyAppointments(authentication.getName()));
		mav.setViewName("myappointments");
		return mav;
	}
	
	@RequestMapping("/vet/allappointments")
	public ModelAndView getAllAppointments() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("allappointments", petClinicService.findAllAppointments());
		mav.setViewName("allappointments");
		return mav;
	}
	
}
