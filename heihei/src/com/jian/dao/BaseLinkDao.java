package com.jian.dao;

import com.jian.bean.Data;
import java.util.List;

public interface BaseLinkDao {
  /***
   * 用于获取所有的连接信息
   * @return
   */
  List<Data> findAll();

  /**
   * 根据连接的id，查询对应链接的内容
   * @param paramInt 要查询的id
   * @return  返回的内容
   */
  String findById(int paramInt);
}
