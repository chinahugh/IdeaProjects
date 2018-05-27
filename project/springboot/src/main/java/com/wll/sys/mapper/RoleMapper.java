package com.wll.sys.mapper;


import com.wll.sys.model.Role;
import com.wll.sys.util.MyMapper;

import java.util.List;

public interface RoleMapper extends MyMapper<Role> {
    public List<Role> queryRoleListWithSelected(Integer id);
}