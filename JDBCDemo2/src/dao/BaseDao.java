package dao;

/**
 * 封装对数据进行操作的接口
 */
public interface BaseDao {
    public int executeUpdate(String sql,Object[] param);
}
