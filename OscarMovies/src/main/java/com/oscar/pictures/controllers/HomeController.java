package com.oscar.pictures.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oscar.pictures.entity.GenRes;
import com.oscar.pictures.entity.Movie;
import com.oscar.pictures.service.GenresService;
import com.oscar.pictures.service.MovieService;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;


@Controller
public class HomeController {
	@Autowired 
	private MovieService movieService;
	@Autowired
	private GenresService genResService;

	/*
	 * @RequestMapping(value="/") public ModelAndView test(HttpServletResponse
	 * response) throws IOException{ return new ModelAndView("home"); }
	 */
	
	@Autowired
	private DiscoveryClient dclient;
	@Autowired
	private LoadBalancerClient loadbal;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView Dashboard()
	{
		List<Movie>movies= movieService.getAllMovies();
		System.out.println("Movies are "+movies);
		ModelAndView mav=new ModelAndView("home");	
		mav.addObject("movies",movies);
		return mav;
	}
	
	@RequestMapping(value="/genres",method = RequestMethod.GET)
	public ModelAndView GenResDashboard()
	{
		List<GenRes>genres= genResService.getAllGenres()
		System.out.println("Genres are "+genres);
		ModelAndView mav=new ModelAndView("home");	
		mav.addObject("genres",genres);
		return mav;
	}
	/*
	 * @RequestMapping(value="/delete/{id}",method=RequestMethod.GET) public String
	 * deleteProduct(@PathVariable int id) {
	 * System.out.println("Id received is:"+id); ApplicationContext context=new
	 * AnnotationConfigApplicationContext(AppConfig.class); ProductDAO
	 * dao=(ProductDAO)context.getBean(ProductDAO.class); dao.delete(id);
	 * 
	 * return "redirect:/"; }
	 * 
	 * 
	 * @RequestMapping(value="/add") public String addProduct() { return "Add"; }
	 * 
	 * @RequestMapping(value="/add", method=RequestMethod.POST) public String
	 * addProduct(@ModelAttribute("product") Product prod) {
	 * System.out.println(prod); ApplicationContext context=new
	 * AnnotationConfigApplicationContext(AppConfig.class); ProductDAO
	 * dao=(ProductDAO)context.getBean(ProductDAO.class); //dao.Add(prod); // Method
	 * to ad record using simple Sql statement //dao.insert(prod);//Method to add
	 * record using prepared Statement
	 * 
	 * int rowcount=dao.insert(prod);//Method to add record using prepared Statement
	 * if(rowcount>0) { System.out.println("Inserted Successfully!"); } else {
	 * System.out.println("Failed to Insert!"); } return "redirect:/"; }
	 * 
	 * 
	 * @RequestMapping(value="edit/{id}", method=RequestMethod.GET) public
	 * ModelAndView Edit(@PathVariable int id) { ModelAndView mav = new
	 * ModelAndView("Edit"); //Product prod = this.getProductById(id);
	 * ApplicationContext context=new
	 * AnnotationConfigApplicationContext(AppConfig.class); ProductDAO
	 * dao=(ProductDAO)context.getBean(ProductDAO.class); Product prod =
	 * dao.getProduct(id); mav.addObject("product",prod);
	 * 
	 * return mav; }
	 * 
	 * 
	 * 
	 * @RequestMapping(value="/edit1/{id}",method = RequestMethod.GET) public
	 * ModelAndView Edit1(@PathVariable int id) {
	 * 
	 * ApplicationContext context=new
	 * AnnotationConfigApplicationContext(AppConfig.class); ProductDAO
	 * dao=context.getBean(ProductDAO.class); Product prod=dao.GetProductById(id);
	 * System.out.println(prod);
	 * 
	 * ModelAndView mav=new ModelAndView("Edit"); mav.addObject("product",prod);
	 * return mav; }
	 * 
	 * @RequestMapping(value="/edit1/{id}",method=RequestMethod.POST) public String
	 * Edit(@PathVariable int id,@ModelAttribute Product prod) { ApplicationContext
	 * context=new AnnotationConfigApplicationContext(AppConfig.class); ProductDAO
	 * dao=context.getBean(ProductDAO.class); int rowcount=dao.update(prod);
	 * if(rowcount>0) { System.out.println("Updated Successfully!"); } else {
	 * System.out.println("Failed to Update!"); } return "redirect:/"; }
	 * 
	 * @RequestMapping(value="/delete1/{id}",method=RequestMethod.GET) public String
	 * Delete(@PathVariable int id) { ApplicationContext context=new
	 * AnnotationConfigApplicationContext(AppConfig.class); ProductDAO
	 * dao=context.getBean(ProductDAO.class); int rowcount=dao.delete(id);
	 * if(rowcount>0) { System.out.println("Deleted Successfully!"); } else {
	 * System.out.println("Failed to Delete!"); } return "redirect:/"; }
	 */
	
}