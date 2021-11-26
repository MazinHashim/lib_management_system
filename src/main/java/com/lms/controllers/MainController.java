package com.lms.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.models.Book;
import com.lms.services.LmsService;

@Controller
public class MainController {
	
	private LmsService lmsService;
	
	@Autowired
	public MainController(LmsService lmsService) {
		this.lmsService =  lmsService;
	}
	@GetMapping(value = "/")
	public String init(HttpServletRequest req) {
		req.setAttribute("books",lmsService.findBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		return "index";
	}
	@GetMapping(value = "/updateBook")
	public String update(HttpServletRequest req,@RequestParam long id) {
		req.setAttribute("book",lmsService.findOne(id));
		req.setAttribute("mode", "BOOK_EDIT");
		return "index";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-mm-dd"), false));
	}
	@PostMapping(value = "/save")
	public void save(HttpServletRequest req,HttpServletResponse res,@ModelAttribute Book book) throws IOException {
		lmsService.save(book);
		req.setAttribute("books",lmsService.findBooks());
		req.setAttribute("mode", "BOOK_VIEW");
		res.sendRedirect("/");
	}
	@GetMapping(value = "/newBook")
	public String newBook(HttpServletRequest req) {
		req.setAttribute("book",new Book());
		req.setAttribute("mode", "BOOK_NEW");
		return "index";
	}
	@RequestMapping(value = "/deleteBook")
	public void deleteBook(@RequestParam long id,HttpServletResponse res,HttpServletRequest req) throws IOException{
		lmsService.delete(id);
		res.sendRedirect("/");
	}
}
