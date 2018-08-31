package com.fitec.formation.wiki.mapper;

import com.fitec.formation.wiki.entity.Status;
import com.fitec.formation.wiki.model.StatusModel;
import com.fitec.formation.wiki.utils.Messages;

public class StatusMapper {

    public static StatusModel mapToStatusModel(Status s) {
        String value = s.getStatus();
        System.out.println(Messages.STATUS_SUCCESS_MESSAGE);
        return Enum.valueOf(StatusModel.class, value);
    }

    public static Status mapToStatus(StatusModel sm) {
        Status s = new Status();
        s.setStatus(sm.toString());
        System.out.println(Messages.STATUS_SUCCESS_MESSAGE);
        return s;
    }

}
