package com.javacode.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.javacode.entities.Profile;
import com.javacode.service.ProfileService;

public class ProfileServiceImpl extends BaseServiceImpl implements ProfileService {
	private static final Logger logger = Logger.getLogger(ProfileServiceImpl.class);

	@Override
	public Profile saveOrUpdate(Profile entity) {
		try {
			return getProfileDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}

	@Override
	public Profile findById(Serializable key) {
		try {
			return getProfileDAO().findById(key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean delete(Profile entity) {
		try {
			getProfileDAO().delete(entity);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Profile findByUserId(int userId) {
		try {
			return getProfileDAO().findByUserId(userId);
		} catch (Exception e) {
			throw e;
		}
	}
}
