package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.model.ProfileModel;

public class ProfileMapper {

	public static ProfileModel mapToProfileModel(Profile p) {
		String value = p.getProfile();
		return Enum.valueOf(ProfileModel.class, value);
	}
	
	public static Profile mapToProfile(ProfileModel pm) {
		Profile p = new Profile();
		p.setProfile(pm.toString());
		return p;
	}

}
