package tn.esprit.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.examen_03_03__2017.persistence.User;
import tn.esprit.examen_03_03__2017.persistence.UserType;
import tn.esprit.examen_03_03__2017.services.CoursEnLigneService;

@ManagedBean
@SessionScoped
public class LoginBean {
	
	@EJB
	CoursEnLigneService coursEnLigneService;
	
	private Boolean isLoggedIn = false;
	
	private String login;
	
	private String password;
	
	private User loggedInuser;
	
	public String doLogin(){
		
		String navigateTo = "";
		loggedInuser = coursEnLigneService.getUserByLoginAndPassword(
				login , password);
		
		if (loggedInuser != null) {
			if(loggedInuser.getUserType() == UserType.AGENT){
				isLoggedIn = true;
				navigateTo = "/pages/agent?faces-redirect=true";
			}else if (loggedInuser.getUserType() == UserType.TEACHER){
				isLoggedIn = true;
				navigateTo = "/pages/teacher?faces-redirect=true";
			} else {
				navigateTo = "/erreur?faces-redirect=true";
			}
		}else{
			navigateTo = "/erreur?faces-redirect=true";
		}
		return navigateTo;
	}
	
	public String logout() {
		isLoggedIn = false;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}


	public User getLoggedInuser() {
		return loggedInuser;
	}

	public void setLoggedInuser(User loggedInuser) {
		this.loggedInuser = loggedInuser;
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

	public Boolean getIsLoggedIn() {
		return isLoggedIn;
	}

	public void setIsLoggedIn(Boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

}
