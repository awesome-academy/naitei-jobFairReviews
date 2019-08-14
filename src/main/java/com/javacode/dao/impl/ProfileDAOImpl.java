package com.javacode.dao.impl;

import java.util.List;

import com.javacode.dao.GenericDAO;
import com.javacode.dao.ProfileDAO;
import com.javacode.entities.Profile;

public class ProfileDAOImpl extends GenericDAO<Integer, Profile> implements ProfileDAO{
	public ProfileDAOImpl() {
		// TODO Auto-generated constructor stub
		super(Profile.class);
	}

	@SuppressWarnings("unchecked")
	public List<Profile> findAll() {
		return getSession().createQuery("from Profile").getResultList();
	}
	
	public Profile findByUserId(int userId)
	{
		return (Profile)getSession().createQuery("from Profile where user_id =: userId ").getSingleResult();
	}
}
