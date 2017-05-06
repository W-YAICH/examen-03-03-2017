package tn.esprit.examen_03_03__2017.services;

import javax.ejb.Remote;

import tn.esprit.examen_03_03__2017.persistence.Course;
import tn.esprit.examen_03_03__2017.persistence.User;

@Remote
public interface CoursEnLigneRemote {
	public void ajouterUser(User user);
	public void ajouterCoursEtEnseignant(Course course , User teacher);
}
