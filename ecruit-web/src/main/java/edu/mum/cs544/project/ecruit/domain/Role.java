package edu.mum.cs544.project.ecruit.domain;

import java.util.ArrayList;
import java.util.List;

public enum Role {
	
	 Admin("admin", 0), User("user", 1);

		private String name;
		private int value;

		private Role(String name, int value) {
			this.name = name;
			this.value = value;

		}

		public static List<Role> getAllRole() {
			List<Role> roles = new ArrayList<Role>();
			for (Role role : Role.values()) {
				roles.add(role);
			}
			return roles;
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
