package poi;

import java.sql.*;

/**
 * @author : zhouhui
 * @date : 2019/2/22 14:10
 */
public class DbUtil {

    private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/framtest?characterEncoding=utf-8";
    private static String jdbcPassword = "root";
    private static String jdbcUserName = "root";

    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private Connection con = null;

    public static Connection getConn() {
        try {
            Driver dd = null;
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUserName,jdbcPassword);
            return  connection;
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("获取数据库连接失败！");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
      Connection connection =  DbUtil.getConn();
      System.out.println("连接成功");
    }


}
