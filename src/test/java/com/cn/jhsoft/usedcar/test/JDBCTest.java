package com.cn.jhsoft.usedcar.test;

import com.cn.jhsoft.usedcar.common.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by chenyi9 on 2018/11/27.
 */
public class JDBCTest {

    @Test
    public void testConn(){
        Connection conn = JDBCUtils.getConnection("jdbc:mysql://localhost:3306/db_big_client");
        Statement stat = null;
        ResultSet rs = null;
        try {
            /**
             * 获取执行sql语句的执行者对象
             */
            stat = conn.createStatement();
            /**
             * 执行sql语句
             */
            String sql = "SELECT * FROM tbl_sign_system";
            rs = stat.executeQuery(sql);
            /**
             * 处理结果集,遍历Set集合
             */
            if (rs.next()) {
                System.out.println(rs.getInt("customer_id") + "\t" + rs.getString("company_name"));
            } else {
                System.out.println("没有查询到指定的数据!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * 使用JDBCUtilsConfig工具类中的方法close释放资源
             */
            JDBCUtils.close(rs, stat, conn);
        }
    }

    @Test
    public void testHiveConn(){
        Connection conn = JDBCUtils.getConnection("jdbc:hive2://114.67.230.242:10000/uckpi", "org.apache.hive.jdbc.HiveDriver", "admin", "123456");
        Statement stat = null;
        ResultSet rs = null;
        try {
            /**
             * 获取执行sql语句的执行者对象
             */
            stat = conn.createStatement();
            /**
             * 执行sql语句
             */
            String sql = "SELECT * FROM test1";
            rs = stat.executeQuery(sql);
            /**
             * 处理结果集,遍历Set集合
             */
            if (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
            } else {
                System.out.println("没有查询到指定的数据!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /**
             * 使用JDBCUtilsConfig工具类中的方法close释放资源
             */
            JDBCUtils.close(rs, stat, conn);
        }
    }

}
