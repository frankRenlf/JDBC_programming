import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : 2022_7_26_jdbc_day1
 * @Package : PACKAGE_NAME
 * @createTime : 2022/7/26 11:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf?tab=overview&from=2022-04-01&to=2022-04-30
 * @Description :
 */


public class Test {


    public static void main(String[] args) throws SQLException {
        // datasource -> the location of database
        DataSource ds = new MysqlDataSource();
        ((MysqlDataSource) ds).setURL("jdbc:mysql://127.0.0.1:3306/test_7_12?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) ds).setUser("root");
        ((MysqlDataSource) ds).setPassword("RLFrlf930Frank_wjq");

        // build connection
        Connection con = ds.getConnection();

        System.out.println(con);

        // do statement
        String sql = "SELECT\n" +
                "\tstudent.id,student.name\n" +
                "FROM\n" +
                "\tstudent\n" +
                "\tINNER JOIN classes ON student.classes_id = classes.id;";


        PreparedStatement statement = con.prepareStatement(sql);
//        statement.setInt();
//        Scanner sc = new Scanner(System.in);
//        for(int i =1;i<=4;i++){
//            statement.setString(i,sc.nextLine());
//        }
//        statement.setString(1,"student.id as si,student.name as sn");
        System.out.println(statement);
        ResultSet rs = statement.executeQuery();
        System.out.println(rs);
        while (rs.next()) {

            int n = rs.getInt("id");
            String name = rs.getString(2);
            System.out.println(n + ": " + name);
        }

        // close statement and connection
        try {
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("数据库错误");
        }
    }


    public static void main2(String[] args) throws SQLException {
        // datasource -> the location of database
        DataSource ds = new MysqlDataSource();
        ((MysqlDataSource) ds).setURL("jdbc:mysql://127.0.0.1:3306/test_7_12?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource) ds).setUser("root");
        ((MysqlDataSource) ds).setPassword("123456");

        // build connection
        Connection con = ds.getConnection();
        System.out.println(con);

        // do statement
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n1 = sc.nextInt();
        String sql = "insert into student values(null,?,?,null,?)";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, s1);
        statement.setString(2, s2);
        statement.setInt(3, n1);
        System.out.println(statement);
        int n = statement.executeUpdate();

        System.out.println(n);

        // close statement and connection
        statement.close();
        con.close();
    }

}
