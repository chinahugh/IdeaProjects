//package com.springboot.security;
//
//import com.springboot.security.entity.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class MyUserDetailService implements UserDetailsService {
//    @Resource
//    private UsersService usersService;
//
//    /**
//     * 根据用户名获取用户信息
//     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User users = new User();
//        users.setUsername(username);
//        List<User> usersList = usersService.selectList(users);
//
//        return buildUserDTO(usersList);
//    }
//
//    /**
//     * 封装UserDTO对象
//     *
//     * @param usersList
//     * @return
//     * */
//    private User  buildUserDTO(List<User> usersList) {
//        User userDTO = new User();
//        userDTO.setUsername(usersList.get(0).getUsername());
//        userDTO.setPassword(usersList.get(0).getPassword());
//        List<String> roleList = new ArrayList<>();
//        for (User users : usersList) {
//            roleList.add(String.format("ROLE_%s", users.getRoleList()));
//        }
//
//        userDTO.setRoleList(roleList);
//        return userDTO;
//    }
//}
