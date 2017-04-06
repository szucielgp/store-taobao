package com.taobao.store.mapper;

import com.taobao.store.pojo.Product;

/**
 * Created by kd_gavin on 2017/4/6,15:11.
 *
 * @dicription
 */
public interface ProductMapper {

    Product selectById(long id);
}
