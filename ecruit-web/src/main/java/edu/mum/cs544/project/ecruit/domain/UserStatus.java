package edu.mum.cs544.project.ecruit.domain;

import java.util.ArrayList;
import java.util.List;

public enum UserStatus {
	
	 Blocked("Inactive", 0), Active("Active", 1), Cancel("Cancel", 2), ;

	private String name;
	private int value;

	private UserStatus(String name, int value) {
		this.name = name;
		this.value = value;

	}

	public static List<UserStatus> getAllStatus() {
		List<UserStatus> userStatus = new ArrayList<UserStatus>();
		for (UserStatus status : UserStatus.values()) {
			userStatus.add(status);
		}
		return userStatus;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
}
