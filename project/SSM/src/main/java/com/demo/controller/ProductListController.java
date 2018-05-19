package com.demo.controller;

import com.demo.commen.ViewPath;
import com.demo.model.Product;
import com.demo.service.ProductListService;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/4/11
 * @Description ProductListController
 */
@Controller
@RequestMapping(value = "/proclist/")
public class ProductListController implements ViewPath {

    @Resource
    private ProductListService productListService;
   /* @ModelAttribute
    public void First(String id, ModelAndView model){
        Product product;
        if (id!=null&&id!=""){
             product = new Product();
             product.setId(Integer.parseInt(id));
        }

    }*/
   @RequestMapping(value = "list")
   public String list(ModelAndView model){
       List<Product> products = productListService.selectAll();
       model.addObject("list",products);
       return PRODUCT_PATH+"list";
   }
}