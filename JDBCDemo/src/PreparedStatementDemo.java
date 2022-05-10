
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//通过prepareStatement向info表里添加数据
public class PreparedStatementDemo {
    /**
     * 添加数据的方法
     *
     * @param name
     * @param age
     */
    public void insertInfo(String name, int age) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("insert into info values (null ,?,?)");
            ps.setString(1, name);
            ps.setInt(2, age);
            //一开始疯狂测试都没有添加成功，后面才发现没有打下面这句话，格式没有记牢
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeSta(ps);//继承statement，所以可以直接用
            JDBCUtils.closeCon(conn);
        }
    }

    /**
     * 更新数据的方法
     *
     * @param name
     * @param age
     * @param id
     */

    public void updateData(String name, int age, int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("update info set name = ?,age=? where id = ?");
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeCon(conn);
            JDBCUtils.closeSta(ps);
        }

    }

    /**
     * 查询数据（一条）的方法
     *
     * @param
     */
    public Info selectInfo(int info_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Info info = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("select * from info where id = ?");
            ps.setInt(1, info_id);
            rs = ps.executeQuery();
            //下面rs.get方法都少了双引号，所以错
            while (rs.next()) {
                info = new Info();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setAge(rs.getInt("age"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeSta(ps);
            JDBCUtils.closeCon(conn);
        }
        return info;
    }

    public List<Info> selectByInfoName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Info info = null;
        ArrayList<Info> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("select * from info where name like ?");
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            //下面rs.get方法都少了双引号，所以错
            while (rs.next()) {
                info = new Info();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setAge(rs.getInt("age"));
                list.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeSta(ps);
            JDBCUtils.closeCon(conn);
        }

        return list;
    }

    /**
     * 批量添加
     *
     * @param list
     */
    public void addBatch(List<Info> list) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement("insert into info values (null,?,?);");
            for (int i = 0; i < list.size(); i++) {
                ps.setString(1, list.get(i).getName());
                ps.setInt(2, list.get(i).getAge());
                //添加批处理
                ps.addBatch();
            }
            //为什么老是会忘记执行这部呢
            ps.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeSta(ps);
            JDBCUtils.closeCon(conn);
        }

    }

    /**
     * 事务处理
     * @param name
     */
    public void deleteInfo(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            //关闭事务的自动提交
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("delete from info where name like ?");
            ps.setString(1,"%"+name+"%");
            ps.executeUpdate();
//            //人为给一个异常
//            String str =null;
//            str.length();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            JDBCUtils.rollback(conn);

        } finally {
            JDBCUtils.closeSta(ps);
            JDBCUtils.closeCon(conn);
        }
    }

    /**
     * 动态查询
     */
    public List<Info> selectDeptByProperty(Info infos) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Info> list = new ArrayList<>();
        try{
            conn =JDBCUtils.getConnection();
            String sql = genSQL(infos);
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Info info = new Info();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setAge(rs.getInt("age"));
                list.add(info);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
           JDBCUtils.closeCon(conn);
           JDBCUtils.closeSta(ps);
           if (rs!=null){
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
        }
        return list;
    }
    //拼接需要执行的 sql 语句
    private String genSQL(Info info){
        StringBuffer sb = new StringBuffer("select * from info where 1=1 ");
        if(info.getId() > 0){
            sb.append(" and id = ").append(info.getId());
        }
        if(info.getName() != null && info.getName().length() > 0){
            sb.append(" and name = '").append(info.getName()).append("'");
        }
        if (info.getAge()>0){
            sb.append(" and age = ").append(info.getAge());
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        PreparedStatementDemo preparedStatementDemo = new PreparedStatementDemo();
//        preparedStatementDemo.insertInfo("pre添加",64);
        //preparedStatementDemo.updateData("更新数据",88,6);


        //查id为5的对象    5   jianjian 18
//        Info info = preparedStatementDemo.selectInfo(5);

        //上面代码返回空还没有改，所以调用方法查询得到的还是空对象
//        if (info!=null) {
//            System.out.println(info.getId()+"   "+info.getName()+"    "+info.getAge());
//        }


//        List<Info> list = preparedStatementDemo.selectByInfoName("jian");
//        for (Info info:list
//             ) {
//            System.out.println(info.getId()+"   "+info.getName()+"    "+info.getAge());
//        }


        //又犯了不执行sql语句的错误   ---漏的是这句ps.executeBatch();
//        List<Info> list = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            Info info = new Info();
//            info.setName("批量添加" + i);
//            info.setAge(30 + i);
//            list.add(info);
//        }
//        preparedStatementDemo.addBatch(list);

        //给一个异常后，sql语句没有执行，因为没有提交回滚了
        //注释掉给的异常后就提交删除了
//        preparedStatementDemo.deleteInfo("批量添加");


        //动态查询
        Info info1 = new Info();
        info1.setAge(88);
        info1.setName("Tom");
        List<Info> list = preparedStatementDemo.selectDeptByProperty(info1);
        for (Info i:list
             ) {
            System.out.println(i.getId()+"   "+i.getName()+"    "+i.getAge());
        }

    }
}
