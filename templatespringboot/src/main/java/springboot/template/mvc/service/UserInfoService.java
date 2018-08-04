package springboot.template.mvc.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import springboot.template.mvc.entity.UserInfo;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description UserInfoService
 */
public interface UserInfoService  {
    /**
     * 根据id获得一个user
     * @param id
     * @return
     */
    UserInfo get(String id);
    /**
     * 根据userinfo中已知条件，获取一个user
     * @param userInfo
     * @return
     */
    UserInfo select(UserInfo userInfo);

    /**
     * 根据userinfo中已知条件，获取列表
     * @param userInfo
     * @return
     */
    PageInfo<UserInfo> listPageInfo(UserInfo userInfo, Page page);

    /**
     * 新增user
     * @param userInfo
     */
    int insert(UserInfo userInfo);

    int update(UserInfo userInfo);
}