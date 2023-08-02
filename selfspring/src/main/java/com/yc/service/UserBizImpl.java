package com.yc.service;

import com.yc.dao.UserDao;
import org.springframework.context.annotation.Scope;
import org.ycframework.annotion.YcLazy;
import org.ycframework.annotion.YcResource;
import org.ycframework.annotion.YcService;

@YcService(value = "ubi")
//@YcLazy
public class UserBizImpl implements UserBiz {
    @YcResource(name = "userDaoImpl")
    private UserDao userDao;

    @Override
    public void add(String uname) {
        userDao.add(uname);
    }
}
