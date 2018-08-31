package com.fitec.formation.wiki.services;

import java.util.List;
import java.util.Objects;

import com.fitec.formation.wiki.entity.Article;
import com.fitec.formation.wiki.entity.Comment;
import com.fitec.formation.wiki.entity.Profile;
import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.repositories.IUserRepository;
import com.fitec.formation.wiki.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitec.formation.wiki.utils.Messages;

@Service
public class UserService implements IUserService<User> {

    @Autowired
    IUserRepository userRepository;
    @Autowired
    Utils utils;

    @Override
    public boolean addUser(User user) {
        boolean result = false;
        if (Objects.nonNull(user)) {
            result = Objects.nonNull(userRepository.save(user));
            System.out.println(Messages.USER_SUCCESS_ADDED);
        } else {
            System.out.println(Messages.USER_ERROR_NULL);
        }
        return result;
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.getOne(id);
        return user;
    }

    @Override
    public boolean updateUser(User sourceUser) {
        boolean result = false;
        User targetUser = userRepository.getOne(sourceUser.getIdUser());
        if (Objects.nonNull(sourceUser) && userRepository.existsById(sourceUser.getIdUser())) {
            BeanUtils.copyProperties(sourceUser, targetUser, utils.getNullPropertyNames(sourceUser));
            result = Objects.nonNull(userRepository.save(targetUser));
            System.out.println(Messages.USER_SUCCESS_UPDATED);
        } else {
            System.out.println(Messages.USER_ERROR_NULL_DONT_EXIST);
        }
        return result;
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean result = false;
        if (userRepository.existsById(id)) {
            userRepository.delete(getUser(id));
            result = true;
            System.out.println(Messages.USER_SUCCESS_DELETED);
        } else {
            System.out.println(Messages.USER_ERROR_DONT_EXIST);
        }
        return result;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

//    @Override
//    public User getUserByUsername(String username) {
//        User user = userRepository.findByUserLogin_UserName(username);
//        return user;
//    }

    @Override
    public List<User> getUsersByStatus(Status status) {
        List<User> users = userRepository.findByStatus(status);
        return users;
    }

//    @Override
//    public List<User> getUsersByProfile(Profile profile) {
//        List<User> users = userRepository.findByUserLogin_Profile(profile);
//        return users;
//    }


    @Override
    public boolean setStatus(Object object, Status status) {
        boolean result = false;
        if (Objects.nonNull(object) && Objects.nonNull(status)) {
            if (Objects.equals(object.getClass(), Article.class)) {
                ((Article) object).setStatus(status);
            } else if (Objects.equals(object.getClass(), Comment.class)) {
                ((Comment) object).setStatus(status);
            } else if (Objects.equals(object.getClass(), User.class)) {
                ((User) object).setStatus(status);
            }
            result = true;
            System.out.println(Messages.USER_SUCCESS_SET_STATUS);
        } else {
            System.out.println(Messages.USER_ERROR_SET_STATUS);
        }
        return result;
    }

}
