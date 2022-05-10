package dao.impl;

import commons.JDBCUtils;
import dao.InfoDao;
import pojo.Info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层的实现类
 */

public class InfoDaoImpl extends BaseDaoImpl implements InfoDao {

    @Override
    public List<Info> selectInfoByName(String InfoName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Info> list = new ArrayList<>();
        try {
            conn = JDBCUtils.getConnection();
            // 为了加深对事务的理解记忆，dml都关闭事务的提交
            ps = conn.prepareStatement("select * from info where name=?");
            ps.setString(1, InfoName);
            rs = ps.executeQuery();
            while (rs.next()) {
                Info info = new Info();
                info.setId(rs.getInt("id"));
                info.setName(rs.getString("name"));
                info.setAge(rs.getInt("age"));
                list.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JDBCUtils.closeSta(ps);//继承statement，所以可以直接用
            JDBCUtils.closeCon(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public void insetInfo(Info info) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("insert into info values(null ,?,?)");
            ps.setString(1, info.getName());
            ps.setInt(2, info.getAge());

            ps.execute();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            JDBCUtils.rollback(conn);
        } finally {
            JDBCUtils.closeSta(ps);
            JDBCUtils.closeCon(conn);

        }
    }
//更新信息
    @Override
    public int updateInfo(Info info) {
        //父类已经重写了方法，只需要在这里设置sql和参数位置并调用父类实现方法
        String sql = "update info set name = ? , age = ? where id = ?";
        Object[] param = new Object[]{info.getName(),info.getAge(),info.getId()};
        return this.executeUpdate(sql, param);

    }


}
