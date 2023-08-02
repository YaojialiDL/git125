package com.yc.git.test4.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok注解需要在Idea中增加一个插件  setter/getter
@NoArgsConstructor  //无参构造方法
@AllArgsConstructor  // 全部参数构造方法
public class BankAccount {
    private int id;
    private double balance;
}
