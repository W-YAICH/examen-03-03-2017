package tn.esprit.examen_03_03__2017.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.examen_03_03__2017.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
