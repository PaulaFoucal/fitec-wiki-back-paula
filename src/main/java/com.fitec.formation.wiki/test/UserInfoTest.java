package com.fitec.formation.wiki.test;

import com.fitec.formation.wiki.entity.UserInfo;
import com.fitec.formation.wiki.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserInfoTest {

    @Autowired
    Utils utils;

    @Autowired
    AddressTest addressTest;

    public List<UserInfo> initUserInfoSuite() {

        List<UserInfo> usersInfo = new ArrayList<>();

        final UserInfo u01 = new UserInfo();
        u01.setFirstName("firstName01");
        u01.setLastName("lastName01");
        u01.setPhone("12341234");
        u01.setBirthday(utils.createDate("01-01-2011"));
        u01.setAddress(addressTest.initAddressTestSuite().get(0));
        usersInfo.add(u01);

        final UserInfo u02 = new UserInfo();
        u02.setFirstName("firstName02");
        u02.setLastName("lastName02");
        u02.setPhone("12341234");
        u02.setBirthday(utils.createDate("02-02-2012"));
        u02.setAddress(addressTest.initAddressTestSuite().get(1));
        usersInfo.add(u02);

        final UserInfo u03 = new UserInfo();
        u03.setFirstName("firstName03");
        u03.setLastName("lastName03");
        u03.setPhone("12341234");
        u03.setBirthday(utils.createDate("03-03-2013"));
        u03.setAddress(addressTest.initAddressTestSuite().get(2));
        usersInfo.add(u03);

        System.out.println("Inside UserInfoTest");

        return usersInfo;
    }

}
