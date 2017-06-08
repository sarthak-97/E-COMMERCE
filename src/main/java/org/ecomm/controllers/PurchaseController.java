package org.ecomm.controllers;

import org.ecomm.models.AdminDet;
import org.ecomm.models.BuyerDet;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * this controller is for handling 
 * all purchase related process
 * 
 * 
 * @author sarthak-pc
 *
 */

@Controller
public class PurchaseController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private BuyerDet buyerdet;
	private AdminDet admindet;
	
	
	

}
