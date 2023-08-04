package com.yc.dao;

import com.yc.bean.OpRecord;

import java.util.List;

public interface OpRecordDao {
    //设计日志的添加接口方法：TODO:参数
    public void insertOpRecord(OpRecord opRecord);

    /**
     * 查询一个用户所有的日志，根据时间排序
     * @param accountid
     * @return
     */
    public List<OpRecord> findOpRecord(int accountid);

    /**
     * 查询accountid账户 opType类型的操作  根据时间排序
     * @param accountid
     * @param opType
     * @return
     */
    public List<OpRecord> findOpRecord(int accountid, String opType);

    /**
     * 待开发，其他特殊查询
     * @param opType
     * @return
     */
    public List<OpRecord> findOpRecord(String opType);
}
