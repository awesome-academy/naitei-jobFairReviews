package com.javacode.dao;

import java.util.List;

import com.javacode.entities.Profile;

public interface ProfileDAO extends BaseDAO<Integer, Profile> {
	
	List<Profile> findAll();
	
	Profile findByUserId(int userId);
}
