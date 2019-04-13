package softwaresurfers.petclinicappointmentsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import softwaresurfers.petclinicappointmentsystem.service.PetClinicService;


@Controller
public class PetClinicController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping("/home/mypets")
	public ModelAndView getPets(Authentication authentication) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mypets", petClinicService.findPets(authentication.getName()));
		mav.setViewName("mypets");
		return mav;
	}
	
	@RequestMapping("/home/mypets/updatepet")
	public ModelAndView getSelectEditPet(Authentication authentication) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mypets", petClinicService.findPets(authentication.getName()));
		mav.setViewName("selectEditPet");
		return mav;
	}
	
	@RequestMapping("/home/mypets/deletepet")
	public ModelAndView getSelectDeletePet(Authentication authentication) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mypets", petClinicService.findPets(authentication.getName()));
		mav.setViewName("selectDeletePet");
		return mav;
	}
}




