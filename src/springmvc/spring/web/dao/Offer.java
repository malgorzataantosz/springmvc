package springmvc.spring.web.dao;

import javax.validation.constraints.NotNull;


public class Offer {
	private int id;
	private User user;
	
	@NotNull
	private String text;
	public int getId() {
		return id;
	}
	public String getUsername() {
		return user.getUsername();
	}
	
	public String getText() {
		return text;
	}
	public Offer() {
	}
	public Offer(User user, String text) {
		this.user = user;
		this.text = text;
	}
	public Offer(int id, User user, String text) {
		this.id = id;
		this.user = user;
		this.text = text;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setText(String text) {
		this.text = text;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Offer [id=" + id + ", user=" + user + ", text=" + text + "]";
	}
	
	

	
}
