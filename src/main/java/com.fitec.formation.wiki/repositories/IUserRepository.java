package com.fitec.formation.wiki.repositories;

import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long>{

//    User findByUserLogin_UserName(String username);

	List<User> findByStatus (Status status);

//    List<User> findByUserLogin_Profile (Profile profile);
	
}
