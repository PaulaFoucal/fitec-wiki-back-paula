package com.fitec.formation.wiki.services;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.entity.Status;

import java.util.List;

public interface IUserService<User> {

    boolean addUser (User user);

    User getUser (Long id);

    boolean updateUser (User user);

    boolean deleteUser (Long id);

    List<User> getUsers ();

//    User getUserByUsername (String username);

    List<User> getUsersByStatus (Status status);

//    List<User> getUsersByProfile (Profile profile);

    boolean setStatus (Object object, Status status);

}
