package service.impl;

import dao.InfoDao;
import dao.impl.InfoDaoImpl;
import pojo.Info;
import service.InfoService;

import java.util.List;

/**
 * 服务层的实现类
 */
public class InfoServiceImpl implements InfoService {

    @Override
    public void addInfo(Info info) {
        InfoDao infoDao = new InfoDaoImpl();
        infoDao.insetInfo(info);

    }

    @Override
    public List<Info> selectInfo(String name) {
        InfoDao infoDao = new InfoDaoImpl();
        return infoDao.selectInfoByName(name);
    }

    @Override
    public int modifyInfo(Info info) {
        InfoDao infoDao = new InfoDaoImpl();
        return infoDao.updateInfo(info);
    }

}
