package com.ssh.daoimpl;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hugh
 * @Date: 17-11-26:下午3:47
 * @Description:
 */
@Repository
public class Page<Person> {
    //结果集
    private List<Person> list;

    //总条数
    private Integer sunSize;

    //单前页数
    private Integer pageno;

    //每页条数
    private Integer pagesize;

    /**
     * @return 总页数
     */
    public Integer getTotalSize() {
        return null;
    }

    /**jskd
     * @param
     * @param
     * @return
     */
    public Integer countOffset(Integer pagesize, Integer pageno) {
        return pagesize;
    }


}
