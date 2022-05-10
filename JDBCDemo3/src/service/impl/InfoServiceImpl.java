package service.impl;

import dao.impl.InfoDaoImpl;
import pojo.Info;
import service.InfoService;

/**
 * 服务层的实现类
 */
public class InfoServiceImpl implements InfoService {

    @Override
    public void addInfo(Info info) {
        InfoDaoImpl infoDao = new InfoDaoImpl();
        infoDao.insetInfo(info);

    }
}
