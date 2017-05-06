package tn.esprit.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.examen_03_03__2017.persistence.Course;
import tn.esprit.examen_03_03__2017.persistence.User;
import tn.esprit.examen_03_03__2017.persistence.UserType;
import tn.esprit.examen_03_03__2017.services.CoursEnLigneService;

@ManagedBean
public class AgentBean {
	
	@EJB
	CoursEnLigneService coursEnLigneService;
	
	private User teacher = new User();
	
	private Course cours = new Course();
	
	public void ajouterTeacherEtCourse(){
		teacher.setUserType(UserType.TEACHER);
		coursEnLigneService.ajouterCoursEtEnseignant(cours, teacher);
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Course getCours() {
		return cours;
	}

	public void setCours(Course cours) {
		this.cours = cours;
	}
	
}
