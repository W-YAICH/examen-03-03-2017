package tn.esprit.examen_03_03__2017.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.examen_03_03__2017.persistence.Course;
import tn.esprit.examen_03_03__2017.persistence.User;

@Stateless
@LocalBean
public class CoursEnLigneService implements CoursEnLigneRemote {

	@PersistenceContext(unitName="examen-ejb")
	EntityManager em;
	
	@Override
	public void ajouterUser(User user) {
		em.persist(user);
	}

	@Override
	public void ajouterCoursEtEnseignant(Course course, User teacher) {
		course.setTeacher(teacher);
		em.persist(course); //faut faire cascade persist
	}
	
	public User getUserByLoginAndPassword(String login, String password){
		User user = null;
		Query query;
		try{
			query = em.createQuery("select u from User u where u.login=:login and u.password=:password");
			query.setParameter("login", login);
			query.setParameter("password", password);
			user = (User)query.getSingleResult();
		}catch(NonUniqueResultException | NoResultException e){
			e.printStackTrace();
		}

		return user;
	}
	
	public List<Course> getAllCoursesByUser(User user){
		Query query = em.createQuery("select c from Course c where c.teacher=:user");
		query.setParameter("user", user);
		return query.getResultList();
	}
	
}
