package softwaresurfers.petclinicappointmentsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import softwaresurfers.petclinicappointmentsystem.model.Pet;
import softwaresurfers.petclinicappointmentsystem.service.PetClinicService;


@Controller
public class PetClinicDeletePetController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value="/home/mypets/delete/{id}",method=RequestMethod.GET)
	public String loadPet(@PathVariable int id, ModelMap modelMap) {
		Pet pet = petClinicService.findPet(id);
		modelMap.put("pet", pet);
		return "deletePet";
	}
	
	@RequestMapping(value="/home/mypets/delete/{id}",method=RequestMethod.POST)
	public String handleFormSubmit(@PathVariable int id, RedirectAttributes redirectAttributes) {
		petClinicService.deletePet(id);
		redirectAttributes.addFlashAttribute("message", "Pet deleted with id:" + id);
		return "redirect:/home/mypets";
	}
}
