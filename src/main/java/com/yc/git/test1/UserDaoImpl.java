package com.yc.git.test1;

import org.springframework.stereotype.Repository;

@Repository  // @Repository标识这是一个dao层类，由spring托管
             // @Component                  由spring托管
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("UserDaoImpl构造...");
    }

    @Override
    public void add(String uname) {
        System.out.println("添加了：" + uname);
    }
}
