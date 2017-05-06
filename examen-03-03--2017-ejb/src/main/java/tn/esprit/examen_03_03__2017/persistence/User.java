package tn.esprit.examen_03_03__2017.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 2478225559081267422L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(unique=true, nullable=false)
	private String login;
	
	private String password;
	
	private Integer age;
	
	private Date birthDate;
	
	public User() {
		super();
	}
	
	public User(String name, String login, String password, Integer age, Date birthDate, UserType userType) {
		super();
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
		this.birthDate = birthDate;
		this.userType = userType;
	}

	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	@ManyToMany
	private List<Course> studentCourses;

	@OneToMany(mappedBy="teacher")
	private List<Course> teacherCourses;
	
	
	public List<Course> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<Course> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public List<Course> getTeacherCourses() {
		return teacherCourses;
	}

	public void setTeacherCourses(List<Course> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
}
