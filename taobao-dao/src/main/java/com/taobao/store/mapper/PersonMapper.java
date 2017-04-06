package com.taobao.store.mapper;

import com.taobao.store.pojo.Person;
import org.apache.ibatis.annotations.Param;

/**
 * Created by kd_gavin on 2017/4/6,15:15.
 *
 * @dicription
 */
public interface PersonMapper {
    Person selectByPrimaryKey(@Param("dbid") String dbid, @Param("openId") String openId);
}
