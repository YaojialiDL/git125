package com.yc.git.test4.user;

import com.yc.git.test4.jdbcTemplate.JdbcTemplate;
import com.yc.git.test4.jdbcTemplate.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BankAccountDao extends JdbcTemplate {

    @Autowired  // 按类型注入  DataSource接口 -> MyDataSource实现类
    public BankAccountDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<BankAccount> findAll(){
        return super.executeQuery("select * from bank where id = ?", new RowMapper<BankAccount>() {
            @Override
            public BankAccount mapper(ResultSet rs, int i) throws SQLException {
                BankAccount ba = new BankAccount();
                ba.setId(rs.getInt(1));
                ba.setBalance(rs.getInt(2));
                return ba;
            }
        }, 1);
    }
}
