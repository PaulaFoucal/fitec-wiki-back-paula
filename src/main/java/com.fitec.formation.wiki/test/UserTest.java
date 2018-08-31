package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.entity.User;
import com.fitec.formation.wiki.entity.UserInfo;
import com.fitec.formation.wiki.entity.UserLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserTest {

    @Autowired
    UserLoggerTest userLoggerTest;

    @Autowired
    UserInfoTest userInfoTest;

    @Autowired
    StatusTest statusTest;

    public List<User> initUserSuite() {
        List<User> users = new ArrayList<>();

        List<UserLogger> userLoggers = userLoggerTest.initUserLoggerSuite();
        List<UserInfo> usersInfo = userInfoTest.initUserInfoSuite();

        final User u01 = new User();
        u01.setUserLogger(userLoggers.get(0));
        u01.setUserInfo(usersInfo.get(0));
        u01.setStatus(statusTest.initStatusSuite().get(4));
        users.add(u01);

        final User u02 = new User();
        u02.setUserLogger(userLoggers.get(1));
        u02.setUserInfo(usersInfo.get(1));
        u02.setStatus(statusTest.initStatusSuite().get(4));
        users.add(u02);

        final User u03 = new User();
        u03.setUserLogger(userLoggers.get(2));
        u03.setUserInfo(usersInfo.get(2));
        u03.setStatus(statusTest.initStatusSuite().get(4));
        users.add(u03);

        System.out.println("Inside UserTest");

        return users;
    }

}
