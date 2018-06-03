package com.wll.pro.service;

import com.wll.pro.dao.MenuMapper;
import com.wll.pro.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/6/3
 * @Description MenuService
 */
@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;

    public List<Menu> getMenuList(Menu menu) {
        return  menuMapper.list(menu);
    }
}
