package com.javatesting.simple;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class ObjectToJson {

	public static void main(String[] args) {
		SignupRequest request = new SignupRequest();
		request.setEmail("vijapandey@gmail.com");
		request.setPassword("password");
		request.setUsername("vijapandey");
		Set<String> roles = new HashSet<>();
		roles.add("Admin");
		request.setRole(roles);
		String jsonInString = new Gson().toJson(request);
		
		System.out.println(jsonInString);

	}

}
