
package springmvc.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import springmvc.spring.web.dao.Offer;
import springmvc.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {

	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}
	
	public List<Offer> getCurrent(){
		return offersDao.getOffers();
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public void create(Offer offer) {
		offersDao.createOffer(offer);
		
	}
	
}
