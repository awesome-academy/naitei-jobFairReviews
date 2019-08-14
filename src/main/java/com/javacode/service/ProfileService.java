package com.javacode.service;

import com.javacode.entities.Profile;

public interface ProfileService extends BaseService<Integer, Profile>{
	Profile findByUserId(int userId);
}
