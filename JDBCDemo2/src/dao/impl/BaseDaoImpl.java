package dao.impl;

import commons.JDBCUtils;
import dao.BaseDao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;

/**
 * 封装通用的 DML 操作
 */
public class BaseDaoImpl implements BaseDao {
    @Override
    public int executeUpdate(String sql, Object[] param) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            //得到参数的个数
            ParameterMetaData pmd = ps.getParameterMetaData();
            //绑定参数
            for(int i=0;i<pmd.getParameterCount();i++){
                ps.setObject(i+1, param[i]);
            }
            rows = ps.executeUpdate();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            JDBCUtils.rollback(conn);
        } finally {
            JDBCUtils.closeSta(ps);
            JDBCUtils.closeCon(conn);

        }
        return rows;
    }
}
