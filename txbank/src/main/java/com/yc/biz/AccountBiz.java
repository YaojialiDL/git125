package com.yc.biz;

import com.yc.bean.Account;

public interface AccountBiz {
    /**
     * 银行开户
     * @param money
     * @return
     */
    public Account openAccount(double money);

    /**
     * 存款
     * @param accountid
     * @param money
     * @return
     */
    public Account deposite(int accountid, double money);
    Account deposite(int accountid, double money, Integer transferId);

    /**
     * 取款
     * @param accountid
     * @param money
     * @return
     */
    public Account withdraw(int accountid, double money);
    Account withdraw(int accountid, double money, Integer transferId);

    /**
     * 从accountId中转出money到toAccountId账户
     * @param accountid
     * @param money
     * @param toAccountId
     * @return
     */
    public Account transfer(int accountid, double money, int toAccountId);

    /**
     * 查询是否存在accoutId账户
     * @param accountid
     * @return
     */
    public Account findAccount(int accountid);

}
