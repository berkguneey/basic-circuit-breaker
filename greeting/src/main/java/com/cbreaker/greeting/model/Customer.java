package com.cbreaker.greeting.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344149189038551749L;
	
	private Long id;
	private String firstName;
	private String lastName;
	private Integer age;

}
