package org.br.curso.actions;

public class UsuarioPojo {
	
	public String id;
	public String first_name;
	public String last_name;
	public String avatar;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public UsuarioPojo() {
		this("", "", "", "");
	}
	
	public UsuarioPojo(String id, String first_name, String last_name, String avatar) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}

}
