package com.wll.sys.mapper;


import com.wll.sys.model.UserRole;
import com.wll.sys.util.MyMapper;

import java.util.List;

public interface UserRoleMapper extends MyMapper<UserRole> {
    public List<Integer> findUserIdByRoleId(Integer roleId);
}