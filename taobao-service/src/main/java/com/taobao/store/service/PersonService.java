package com.taobao.store.service;

import com.taobao.store.pojo.Person;

/**
 * Created by kd_gavin on 2017/4/6,15:39.
 *
 * @dicription
 */
public interface PersonService {
    Person selectByPrimaryKey(String dbid, String openId);
}
