package com.taobao.store.controller;
import com.taobao.store.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * Created by kd_gavin on 2017/4/7,10:13.
 *
 * @dicription
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

}
