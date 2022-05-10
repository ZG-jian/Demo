package service;

import pojo.Info;

import java.util.List;

public interface InfoService {
    public void addInfo(Info info);
    public List<Info> selectInfo(String name);

    public int modifyInfo(Info info);
}
