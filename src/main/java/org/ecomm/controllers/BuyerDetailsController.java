package org.ecomm.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * this controllers handles all the crud request of user for his profile details
 * @author sarthak-pc
 *
 */

@Controller
public class BuyerDetailsController {

	@Autowired
	private SessionFactory sessionFactory;
	
}
