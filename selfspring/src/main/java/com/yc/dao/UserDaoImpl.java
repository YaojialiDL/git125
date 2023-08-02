package com.yc.dao;

import org.ycframework.annotion.YcLazy;
import org.ycframework.annotion.YcRepository;
import org.ycframework.annotion.YcScope;

@YcRepository
@YcLazy
//@YcScope(value = "prototype")
public class UserDaoImpl implements UserDao {
    @Override
    public void add(String uname) {
        System.out.println("dao添加了" + uname);
    }
}
