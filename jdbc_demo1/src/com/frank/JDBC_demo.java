package com.frank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : jdbc_demo1
 * @Package : com.frank
 * @createTime : 2022/6/28 11:34
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */
public class JDBC_demo {

    public static void main(String[] args) throws Exception {

//        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://127.0.0.1:3306/mysqllearning?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "123456";

        Connection con = DriverManager.getConnection(url, username, password);
//jdbc:mysql://localhost:3306/demo_o5_mybatis?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8
        String sql = "update bank set money = 1111 where id = 1";

        Statement statement = con.createStatement();

        int count = statement.executeUpdate(sql);

        System.out.println(count);

        statement.close();
        con.close();

    }

}
