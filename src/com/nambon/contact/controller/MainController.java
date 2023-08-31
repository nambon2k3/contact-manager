package com.nambon.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nambon.contact.dao.ContactDAO;
import com.nambon.contact.model.Contact;

@Controller
public class MainController {
	
	//auto detect and inject an instance to the controller in the configuration file
	@Autowired
	private ContactDAO contactDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView listContact(ModelAndView model) {
		List<Contact> data = contactDAO.list();
		model.addObject("data", data);
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView addContact(ModelAndView model) {
		Contact newContact = new Contact();
		model.addObject("contact", newContact);
		model.setViewName("add-contact");
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEdit(@ModelAttribute Contact contact) {
		if(contact.getId() != 0) {
			contactDAO.update(contact);
		}
		else contactDAO.save(contact);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editConact(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Contact contact = contactDAO.get(id);
		ModelAndView model = new ModelAndView();
		model.addObject("contact", contact);
		model.setViewName("add-contact");
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView saveEdit(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		contactDAO.delete(id);
		return new ModelAndView("redirect:/");
	}
	
}
