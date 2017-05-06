package tn.esprit.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import tn.esprit.examen_03_03__2017.persistence.Course;
import tn.esprit.examen_03_03__2017.services.CoursEnLigneService;

@ManagedBean
public class TeacherBean {
	
	@EJB
	private CoursEnLigneService coursEnLigneService;
	
	//il faut absolument mettre les getters et les setters de loginBean
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean loginBean;
	
	public List<Course> getCoursesList() {
		return coursEnLigneService.getAllCoursesByUser(loginBean.getLoggedInuser());
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
