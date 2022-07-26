import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;


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

    public static void main(String[] args) {
        // datasource -> the location of database
        DataSource ds = new MysqlDataSource();
        ((MysqlDataSource)ds).setURL("jdbc:mysql://127.0.0.1:3306/test_7_12");
    }

}
