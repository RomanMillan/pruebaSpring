package com.jacaranda.Students.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.Students.models.Student;
import com.jacaranda.Students.services.PruebaServices;

@Controller
public class PruebaController {
	
	@Autowired
	PruebaServices repositorio;
	
	
	/*
	 * @GetMapping("/estudiante") public String Student(Model model) {
	 * model.addAttribute("estudiante", repositorio.getStudent("Maria", "Quesada"));
	 * return "index"; }
	 */
	
	@GetMapping("/estudiantes")
	public String Students(Model model) {
		model.addAttribute("estudiantes", repositorio.getStudents());
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(Model model,
			@RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="surname", required=false, defaultValue="") String surname) {
		
		Student student = repositorio.getStudent(name, surname);
		model.addAttribute("studentDel", student);
		//repositorio.removeStudent(student);
		return "delete";
	}
	
	@PostMapping("/deleteSubmit")
	public String deleteSubmit(@ModelAttribute("studentDel") Student student) {
		repositorio.removeStudent(student);
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/add")	 
	public String addStudent(@Validated Model model, BindingResult bindingResult,
			@RequestParam(name="name", required=false, defaultValue="") String name,
			@RequestParam(name="surname", required=false, defaultValue="") String surname,
			@RequestParam(name="age", required=false, defaultValue="") int age
			) {
		if(bindingResult.hasErrors()) {
			return "add";
		}else {			
			Student student = new Student(name,surname,age);
			repositorio.addStudent(student);
			return "redirect:/estudiantes";
		}
	}
	
	
}
