package dao;

import pojo.Info;

import java.util.List;

public interface InfoDao extends BaseDao{
    public List<Info> selectInfoByName(String InfoName);
    public void insetInfo(Info info);

    public int updateInfo(Info info);




}
