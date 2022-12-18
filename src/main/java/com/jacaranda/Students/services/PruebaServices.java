package com.jacaranda.Students.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.Students.models.Student;

@Service
public class PruebaServices {
	
	private List<Student> listStudents;

	public PruebaServices() {
		listStudents = new ArrayList<>();
		listStudents.add(new Student("Juan","Quesada",23));
		listStudents.add(new Student("Maria","Quesada",23));
		listStudents.add(new Student("Luisa","Quesada",23));
	}
	
	public List<Student> getStudents(){
		return listStudents;
	}
	
	public Student getStudent(String nombre, String apellido) {
		Boolean encontrado = false;
		Student resultado = null;
		
		Iterator<Student> puntero = this.listStudents.iterator();
		while(puntero.hasNext() && !encontrado) {
			resultado = puntero.next();
			if(resultado.getName().equals(nombre) && resultado.getSurname().equals(apellido)) {
				encontrado = true;
			}
		}
		
		return resultado;
	}
	
	public void addStudent (Student s) {
		this.listStudents.add(s);
	}
	
	public void removeStudent (Student s) {
		this.listStudents.remove(s);
	}
}
