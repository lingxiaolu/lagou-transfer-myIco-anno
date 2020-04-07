package com.lagou.edu.utils;

import com.lagou.edu.ioc.annotation.Autowired;
import com.lagou.edu.ioc.annotation.Service;

import java.sql.SQLException;

/**
 * @author 应癫
 *
 * 事务管理器类：负责手动事务的开启、提交、回滚
 */
@Service(value = "transactionManager")
public class TransactionManager {

    @Autowired(value = "connectionUtils")
    private ConnectionUtils connectionUtils;




    // 开启手动事务控制
    public void beginTransaction() throws SQLException {
        connectionUtils.getCurrentThreadConn().setAutoCommit(false);
    }


    // 提交事务
    public void commit() throws SQLException {
        connectionUtils.getCurrentThreadConn().commit();
    }


    // 回滚事务
    public void rollback() throws SQLException {
        connectionUtils.getCurrentThreadConn().rollback();
    }
}
