package softwaresurfers.petclinicappointmentsystem.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import softwaresurfers.petclinicappointmentsystem.model.Pet;
import softwaresurfers.petclinicappointmentsystem.service.PetClinicService;


@Controller
public class PetClinicEditPetController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value="/home/mypets/update/{id}",method=RequestMethod.GET)
	public String loadPet(@PathVariable int id, ModelMap modelMap) {
		Pet pet = petClinicService.findPet(id);
		modelMap.put("pet", pet);
		return "editPet";
	}
	
	@RequestMapping(value="/home/mypets/update/{id}",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute @Valid Pet pet, BindingResult bindingResult, RedirectAttributes redirectAttributes, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			return "editPet";
		}
		
		pet.setUserEmail(authentication.getName());
		petClinicService.updatePet(pet);
		redirectAttributes.addFlashAttribute("message","Pet updated with id :" + pet.getId());
		return "redirect:/home/mypets";
	}
}
