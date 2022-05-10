package com.jian.service;


import com.jian.bean.Data;
import com.jian.dao.BaseLinkDao;
import com.jian.dao.LinkDao;

import java.util.List;

/**
 * 没有任何业务逻辑的代理
 */
public class LinkService {
    private static BaseLinkDao dao = (BaseLinkDao) new LinkDao();

    public static List<Data> findAll() {
        return dao.findAll();
    }

    public static String findById(int id) {
        return dao.findById(id);
    }
}
