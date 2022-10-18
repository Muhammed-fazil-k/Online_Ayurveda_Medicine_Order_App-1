package com.cg.oam.dto;

import javax.validation.constraints.NotNull;

/**
 * The Class AdminDTO.
 */
public class AdminDTO {
	
	/** The id. */
	int id;
	
	/** The password. */
	@NotNull(message = "Please provide password")
	String password;
	
	/**
	 * Instantiates a new admin DTO.
	 */
	public AdminDTO() {}
	
	/**
	 * Instantiates a new admin DTO.
	 *
	 * @param id the id
	 * @param password the password
	 */
	public AdminDTO(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "AdminDTO [id=" + id + ", password=" + password + "]";
	}
	
}
