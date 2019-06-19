package com.revature.dtos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.models.Usergroup;

public abstract class Conversions {

	public static UserDTO convertUserPrivate(User u) {
		return new UserDTO(u);
	}
	
	public static UserDTO converUserPublic(User u) {
		return new UserDTO(u, false);
	}

	public static UsergroupDTO convertUsergroupPrivate(Usergroup ug) {
		return new UsergroupDTO(ug);
	}
	
	public static UsergroupDTO convertUsergroupPublic(Usergroup ug) {
		return new UsergroupDTO(ug, false);
	}
	
	public static List<UsergroupDTO> convertUsergroupPublic(List<Usergroup> ugList) {
		ArrayList<UsergroupDTO> retList = new ArrayList<UsergroupDTO>(ugList.size());
		for(Usergroup usergroup : ugList) {
			retList.add(convertUsergroupPublic(usergroup));
		}
		return retList;
	}
	
	public static List<UsergroupDTO> convertUsergroupPrivate(List<Usergroup> ugList) {
		ArrayList<UsergroupDTO> retList = new ArrayList<UsergroupDTO>(ugList.size());
		for(Usergroup usergroup : ugList) {
			retList.add(convertUsergroupPrivate(usergroup));
		}
		return retList;
	}
}
