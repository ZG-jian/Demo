package dao;

import pojo.Info;

import java.util.List;

public interface InfoDao {
    public List<Info> selectInfoByName(String InfoName);

    public void insetInfo(Info info);


}
