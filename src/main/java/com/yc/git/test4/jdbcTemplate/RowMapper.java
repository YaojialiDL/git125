package com.yc.git.test4.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    /**
     * 对第i行的ResultSet转换成T对象，这个具体的实现由用户完成
     * @param rs
     * @param i
     * @return
     * @throws SQLException
     */
    public T mapper(ResultSet rs, int i) throws SQLException;
}
