package com.cn.jhsoft.usedcar.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类Hive数据库连接
 * @author chenyi
 */
public class HiveUtils {
    private static String driver_class;
    private static String user_name ;
    private static String url;
    private static String password ;
    protected Connection connection;

    public HiveUtils() {
        load();
    }

    private void load() {
        try {
            // 读取配置文件
            InputStream inputStream = getClass().getResourceAsStream("/conf/dev/app.properties");
            // 创建Properties对象
            Properties prop = new Properties();
            // 加载输入流
            prop.load(inputStream);
            // 获取配置属性
            driver_class = prop.getProperty("driver_class");
            user_name = prop.getProperty("user_name");
            password = prop.getProperty("password");
            url = prop.getProperty("url");
            // 关闭输入流
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接对象
     *
     * @return 连接对象
     */
    public Connection getConnection() {
        try {
            Class.forName(driver_class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url, user_name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行查询操作
     *
     * @param sql
     *            SQL语句
     * @param params
     *            SQL语句中参数值的集合
     * @return 结果集对象
     */
    public ResultSet executeQuery(String sql, Object... params) {
        ResultSet rs = null;
        connection = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    /**
     * 导入数据到Hive数据库表
     * @param sql
     *            SQL语句
     * @return 是否导入数据成功
     * String sql = "load data local inpath '" + filepath + "' into table "+ tableName;
     */
    public boolean loadData(String sql) {
        //目录 ，我的是hive安装的机子的虚拟机的home目录下
        System.out.println("Running:" + sql);
        connection = getConnection();
        try {
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     * 创建内部Hive表
     *
     * @param sql
     *            SQL语句
     * @return 是否创建数据库表成功
     * String sql = "create table "+ tableName + " (key int, value string)  row format delimited fields terminated by '\t'";
     */
    public boolean createTable(String sql) {
        connection = getConnection();
        try {
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    /**
     * 删除Hive表
     *
     * @param tableName
     *            数据库表名
     * @return 是否删除数据库表成功
     */
    public boolean dropTable(String tableName){
        String sql = "drop table  " + tableName;
        connection = getConnection();
        try {
            connection.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 关闭Statement对象
     *
     * @param stmt
     */
    protected void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 关闭连接对象
     *
     * @param connection
     */
    protected void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 关闭结果集对象
     *
     * @param rs
     */
    protected void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}