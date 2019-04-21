package softwaresurfers.petclinicappointmentsystem.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import softwaresurfers.petclinicappointmentsystem.dao.UserRepository;
import softwaresurfers.petclinicappointmentsystem.model.Pet;
import softwaresurfers.petclinicappointmentsystem.model.User;
import softwaresurfers.petclinicappointmentsystem.service.PetClinicService;


@Controller
public class PetClinicNewPetController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value="/home/mypets/new",method=RequestMethod.GET)
	public String newPet() {
		return "newPet";
	}
	
	@ModelAttribute
	public Pet initModel() {
		return new Pet();
	}
	
	@RequestMapping(value="/home/mypets/new",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute @Valid Pet pet, BindingResult bindingResult, RedirectAttributes redirectAttributes, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			return "newPet";
		}
	
		pet.setUserEmail(authentication.getName());
		petClinicService.createPet(pet);
		redirectAttributes.addFlashAttribute("message", "Pet created with id :" + pet.getId());
		return "redirect:/home/mypets";
	}
}
