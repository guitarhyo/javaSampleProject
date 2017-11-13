package com.zangel.vo;

public class Member {

	private int t_id;
	private int id;
	private String login_id;
	private String name;
	private String passwd;
	
	
	/**
	 * @return the t_id
	 */
	public int getT_id() {
		return t_id;
	}
	/**
	 * @param t_id the t_id to set
	 */
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the login_id
	 */
	public String getLogin_id() {
		return login_id;
	}
	/**
	 * @param login_id the login_id to set
	 */
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Member [t_id=");
		builder.append(t_id);
		builder.append(", id=");
		builder.append(id);
		builder.append(", login_id=");
		builder.append(login_id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", passwd=");
		builder.append(passwd);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
