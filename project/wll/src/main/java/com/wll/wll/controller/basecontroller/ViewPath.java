package com.wll.wll.controller.basecontroller;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.File;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description ViewPath
 */
public interface ViewPath{
    String BASE_PATH="wll"+File.separator;
    static String MAIN_PATH=BASE_PATH+"promain"+File.separator;


}
