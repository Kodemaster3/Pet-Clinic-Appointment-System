package softwaresurfers.petclinicappointmentsystem.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import softwaresurfers.petclinicappointmentsystem.model.Appointment;
import softwaresurfers.petclinicappointmentsystem.model.DateTime;
import softwaresurfers.petclinicappointmentsystem.model.Pet;
import softwaresurfers.petclinicappointmentsystem.service.PetClinicService;

@Controller
public class NewAppointmentController {
	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping("/newappointment")
	public ModelAndView getAppointment(Authentication authentication) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("mypets", petClinicService.findPets(authentication.getName()));
		mav.addObject("dates", petClinicService.findActiveDates(true));
		mav.setViewName("newAppointment");
		return mav;
	}
	
	@ModelAttribute
	public Appointment initModel() {
		return new Appointment();
	}
	
	@RequestMapping(value="/newappointment",method=RequestMethod.POST)
	public String handleFormSubmit(@ModelAttribute Appointment appointment, BindingResult bindingResult, RedirectAttributes redirectAttributes, Authentication authentication) {
		if(bindingResult.hasErrors()) {
			return "newAppointment";
		}
		
		String d;
		d=appointment.getDate();
		int dd = Integer.parseInt(d);
		DateTime date = petClinicService.findDate(dd);
		date.setActive(false);
		Date dateS = date.getDate();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		String strDate = dateFormat.format(dateS); 
		appointment.setDate(strDate);
		appointment.setUserEmail(authentication.getName());
		petClinicService.createAppointment(appointment);
		petClinicService.updateDate(date);
		redirectAttributes.addFlashAttribute("message", "Appointment created with id :" + appointment.getId());
		return "redirect:/home/myappointments";
	}
	
}
