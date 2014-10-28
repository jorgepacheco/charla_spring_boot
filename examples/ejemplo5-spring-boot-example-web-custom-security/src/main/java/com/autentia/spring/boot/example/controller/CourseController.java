package com.autentia.spring.boot.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.autentia.spring.boot.example.model.Course;
import com.autentia.spring.boot.example.service.CourseService;


@Controller
@RequestMapping("/")
public class CourseController{
	
	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	
	@RequestMapping
	public ModelAndView list() {
		Iterable<Course> courses = courseService.getCourses();
		return new ModelAndView("courses/list", "courses", courses);
	}
	
	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(@ModelAttribute Course course) {
		return "courses/form";
	}
	
	@RequestMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long id) {
		Course course = courseService.findCourse(id);
		return new ModelAndView("courses/view", "course", course);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView create(@Valid Course course, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("courses/form", "formErrors", result.getAllErrors());
		}
		course = courseService.save(course);
		redirect.addFlashAttribute("globalMessage", "Curso creado correctamente");
		return new ModelAndView("redirect:/{course.id}", "course.id", course.getId());
	}

}
