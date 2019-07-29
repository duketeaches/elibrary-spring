/**
 * 
 */
package duke.learn.elibrary.view.model;

import duke.learn.elibrary.data.model.Role;

/**
 * @author Kazi
 *
 */
public class UserView implements CommonInput {

    private Integer userId;
    private String name;
    private Integer age;
    private String email;
    private String number;
    private String username;
    private String password;
    private Role role;

    /**
     * @param name
     * @param age
     * @param email
     * @param number
     * @param username
     * @param password
     * @param role
     */
    public UserView(String name, Integer age, String email, String number, String username, String password,
	    Role role) {
	super();
	this.name = name;
	this.age = age;
	this.email = email;
	this.number = number;
	this.username = username;
	this.password = password;
	this.role = role;
    }

    /**
     * @param userId
     * @param name
     * @param age
     * @param email
     * @param number
     * @param username
     * @param password
     * @param role
     */
    public UserView(Integer userId, String name, Integer age, String email, String number, String username,
	    String password, Role role) {
	super();
	this.userId = userId;
	this.name = name;
	this.age = age;
	this.email = email;
	this.number = number;
	this.username = username;
	this.password = password;
	this.role = role;
    }

    public UserView() {
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Integer getAge() {
	return age;
    }

    public void setAge(Integer age) {
	this.age = age;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getNumber() {
	return number;
    }

    public void setNumber(String number) {
	this.number = number;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "UserView [userId=" + userId + ", name=" + name + ", age=" + age + ", email=" + email + ", number="
		+ number + ", username=" + username + ", password=" + password + ", role=" + role + "]";
    }

    public Integer getUserId() {
	return userId;
    }

    public void setUserId(Integer userId) {
	this.userId = userId;
    }

    public Role getRole() {
	return role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

}
