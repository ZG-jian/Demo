import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//实现JDBC添加数据,向student数据库的info表添加数据

public class JDBCWatch {
    //添加info表数据方法
    public void  TestJDBC(String name,int age){
        Connection conn = null;
        Statement statement = null;
        try {
            //驱动注册
            //创建连接
            conn = JDBCUtils.getConnection();
            //获取数据库操作对象
             statement = conn.createStatement();
            String sql = "insert into info values (6,'"+name+"',"+age+")";
            int flag = statement.executeUpdate(sql);
            System.out.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!= null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 通过JDBC修改数据的方法
     */
    public void changeData(String NewName,int id){
        Connection conn = null;
        Statement statement = null;

        try {
            //加载驱动程序
            //实例化连接
           conn = JDBCUtils.getConnection();
            //实例化操作数据库对象
            statement = conn.createStatement();
            String sql = "update info set name='"+NewName+"'"+" where id="+id;
            int flag = statement.executeUpdate(sql);
            System.out.println(flag);


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
           JDBCUtils.closeCon(conn);
           JDBCUtils.closeSta(statement);
        }
    }

    public void selectData(String name,int i){
        Connection conn = null;
        Statement statement = null;
        ResultSet res = null;

        try {
            //加载驱动程序
            //实例化连接
            conn = JDBCUtils.getConnection();
            //实例化操作数据库对象
            statement = conn.createStatement();
            String sql = "select * from info where name='"+name+"' and id="+i;
            res = statement.executeQuery(sql);



            while (res.next()){
                System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (res!=null){
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            JDBCUtils.closeSta(statement);
            JDBCUtils.closeCon(conn);


        }
    }
    public static void main(String[] args) {
        JDBCWatch jdbc = new JDBCWatch();
        jdbc.TestJDBC("jianjian22",18);
//        jdbc.changeData("饱饱",4);
//        jdbc.selectData("jian' or 1=1 -- ",1);

    }
}
