package org.ecomm.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.ecomm.models.ItemsDet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * this controller handles the process for
 * adding items it the database by the seller and admin
 * @author sarthak-pc
 *
 */

@Controller
public class AddItemsController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private ItemsDet itemsdet;
    ServletContext context;
	
	/**
	 * controller for adding items in database by sellers
	 * @param itemsdet
	 * @return
	 */
	
	//@RequestMapping(value = "/additem", method = RequestMethod.POST)
	/*public ModelAndView signup(@ModelAttribute("itemsdet") org.ecomm.models.ItemsDet itemsdet,@RequestParam("file") MultipartFile file) {
		Session session = sessionFactory.openSession();
		ModelAndView model;
		if (session.get(ItemsDet.class, itemsdet.getItemId()) == null) {
			
			//hash function method to be called here for setting hash id
			
			
			
			
	              		
			session.beginTransaction();
			session.save(itemsdet);
			
			session.getTransaction().commit();
			model = new ModelAndView("addimages");
			model.addObject("invalid", "Successfully added item");

		} else
		{
			model = new ModelAndView("sellerpannel");
			model.addObject("invalid", "This item is already there.");
		}
			session.close();
		
		return model;

	}
	
	
	*//**
	 * this controller adds up new images to database
	 * @param file
	 * @return
	 *//*
	
	@RequestMapping(value="/add-item-image", method = RequestMethod.POST)
	public ModelAndView additemimage(@RequestParam("file") MultipartFile file,HttpServletRequest request) 	{ 
		
		//for extracting file name
		
       
        for (Part part : request.getParts("img1")) {
       String fileName = extractFileName(part);
       

  //you can change this part acc. to your requirements
    

//file name of the upload file is included in content-disposition header like this:
//form-data; name="dataFile"; filename="PHOTO.JPG"


InputStream filecontent = null;

try { 

filecontent = part.getInputStream();

System.out.println(fileName);
}
catch(Exception e)
{

}


		
	String relativeWebPath = "/avatars";
	String absoluteFilePath = context.getRealPath(relativeWebPath);
	File uploadedFile = new File(absoluteFilePath, fileName);
	
	
		return null;
	 
	  }
    
	}   
*/	

	private String extractFileName(Part part) {
		// TODO Auto-generated method stub
		
		 for (String content : part.getHeader("content-disposition").split(";")) {
		        if (content.trim().startsWith("filename")) {
		            return content.substring(
		                    content.indexOf('=') + 1).trim().replace("\"", "");
		        }
		       // System.out.println(content);
		    }         
		    return null;
		
	}
	  
}
