package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.model.ProfileModel;
import com.fitec.formation.wiki.utils.Messages;

public class ProfileMapper {

	public static ProfileModel mapToProfileModel(Profile p) {
		String value = p.getProfile();
		System.out.println(Messages.PROFILE_SUCCESS_MESSAGE);
		return Enum.valueOf(ProfileModel.class, value);
	}
	
	public static Profile mapToProfile(ProfileModel pm) {
		Profile p = new Profile();
		p.setProfile(pm.toString());
		System.out.println(Messages.PROFILE_SUCCESS_MESSAGE);
		return p;
	}

}
