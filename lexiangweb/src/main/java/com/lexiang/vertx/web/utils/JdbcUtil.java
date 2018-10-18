package com.lexiang.vertx.web.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author Duan YingJie
 * @Date 5/23/18 1:56 PM
 * @Description
 */
public class JdbcUtil {

  private static final Logger LOG = LoggerFactory.getLogger(JdbcUtil.class);

  private static DataSource ds;
  //private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

  static {
    try {
      InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("druid-config.properties");
      Properties prop = new Properties();
      prop.load(in);

      ds = DruidDataSourceFactory.createDataSource(prop);

      Runtime.getRuntime().addShutdownHook(new Thread(() -> {
        DruidDataSource dds = (DruidDataSource) ds;
        if (dds != null && !dds.isClosed()) {
          dds.close();
          LOG.info("DruidDataSource Closed......");
        }
      }));
    }
    catch (Exception e) {
      throw new ExceptionInInitializerError(e);
    }
  }

  public static DataSource getDataSource() {
    return ds;
  }

  public static Connection getConnection() throws SQLException {

//    DruidDataSource dds = (DruidDataSource) ds;
    Connection conn = ds.getConnection();
//    Connection conn = threadLocal.get();
//    if (conn == null) {
//      conn = ds.getConnection();
//      threadLocal.set(conn);
//    }

//    LOG.info("===>> {} JdbcUtils-getConnection: {}, MaxActive=[{}], ActiveCount=[{}]",
//      Thread.currentThread().getName(), conn, dds.getMaxActive(), dds.getActiveCount());
    return conn;
  }

  public static void startTranscation() {
    try {
      Connection conn = getConnection();
      if (conn != null) {
        conn.setAutoCommit(false);
      }
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

 /* public static void commitAndClose() {
    Connection conn = null;
    try {
      conn = threadLocal.get();
      if (conn != null) {
        conn.commit();
      }
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
    finally {
      closeConnection(conn);
    }
  }

  public static void rollbackAndClose() {
    Connection conn = null;
    try {
      conn = threadLocal.get();
      if (conn != null) {
        conn.rollback();
      }
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
    finally {
      closeConnection(conn);
    }
  }*/

  private static void closeConnection(Connection conn) {
    if (conn != null) {
      try {
        conn.close();
      }
      catch (SQLException e) {
        throw new RuntimeException(e);
      }
      /*finally {
        threadLocal.remove();
      }*/
    }
  }
/*
  public static void close() {
    try {
      Connection conn = threadLocal.get();
      if (conn != null) {
        conn.close();
      }
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
    finally {
      threadLocal.remove();
      DruidDataSource dds = (DruidDataSource) ds;
      LOG.info("===>> JdbcUtil-close: MaxActive=[{}], ActiveCount=[{}]", dds.getMaxActive(), dds.getActiveCount());
    }
  }*/

}