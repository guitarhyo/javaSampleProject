package com.zangel.vo;

public class Team {

  private int t_id;
  private int id;
  private String team_name;
  private String name;
  private String age;



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
   * @return the team_name
   */
  public String getTeam_name() {
    return team_name;
  }

  /**
   * @param team_name the team_name to set
   */
  public void setTeam_name(String team_name) {
    this.team_name = team_name;
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
   * @return the age
   */
  public String getAge() {
    return age;
  }

  /**
   * @param age the age to set
   */
  public void setAge(String age) {
    this.age = age;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Team [t_id=");
    builder.append(t_id);
    builder.append(", id=");
    builder.append(id);
    builder.append(", team_name=");
    builder.append(team_name);
    builder.append(", name=");
    builder.append(name);
    builder.append(", age=");
    builder.append(age);
    builder.append("]");
    return builder.toString();
  }


}
