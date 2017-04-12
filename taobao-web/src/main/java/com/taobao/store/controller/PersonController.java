package com.taobao.store.controller;
import com.taobao.store.pojo.Person;
import com.taobao.store.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kd_gavin on 2017/4/7,10:13.
 *
 * @dicription
 */
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person",method = RequestMethod.GET)
    public Object findPeronByPk(String dbid,String openid){
        Person person = personService.selectByPrimaryKey(dbid,openid);
        return person;
    }

}
