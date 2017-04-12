package com.taobao.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kd_gavin on 2017/4/12,19:45.
 *
 * @dicription
 */

@Controller
public class PagerController {

    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
}
