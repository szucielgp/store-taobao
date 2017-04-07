package com.taobao.store.service.impl;

import com.taobao.store.mapper.PersonMapper;
import com.taobao.store.pojo.Person;
import com.taobao.store.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kd_gavin on 2017/4/6,15:40.
 *
 * @dicription
 */

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person selectByPrimaryKey(String dbid, String openId) {
        return personMapper.selectByPrimaryKey(dbid,openId);
    }
}
