package springmvc.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.spring.web.dao.Offer;
import springmvc.spring.web.service.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping("/offers")
	public String showOffers(Model model) {
		List<Offer> offers = offersService.getCurrent();
		model.addAttribute("offers", offers);
		return "offers";
	}

	@RequestMapping("/createOffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		return "createOffer";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(@Valid Offer offer, BindingResult result) {
		if (result.hasErrors()) {
			return "createOffer";
		} else {
			offersService.create(offer);
			return "offercreated";

		}
	}

}
// other methods:
// @RequestMapping("/")
// public ModelAndView showHome() {
// ModelAndView mv = new ModelAndView("home");
// Map<String, Object> model = mv.getModel();
// model.put("name", "John Price");
// return mv;
// }
// @RequestMapping("/")
// public String showHome(HttpSession session) {
// session.setAttribute("name", "John Price");
// return "home";
// }
