package com.yc.git.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service  // 业务层
public class UserBizImpl implements UserBiz {
    public UserBizImpl() {
        System.out.println("UserBizImpl构造...");
    }

    //将dao层的对象注入到biz  DI依赖注入  （将spring容器中托管的userDao的对象传到此处）
    //@Resource(name = "userDaoImpl")  // 由spring容器根据id名为userDaoImpl到容器中找到这个实例，并注入
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public void addUser(String uname) {
        userDao.add(uname);
    }
}
