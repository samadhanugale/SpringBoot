package com.neo.demo.service;

import java.util.Comparator;

import com.neo.demo.model.User;

public class CompareByName implements Comparator<User> {
	public int compare(User o1, User o2) {
		return o1.getUsername().compareTo(o2.getUsername());
	};
}
