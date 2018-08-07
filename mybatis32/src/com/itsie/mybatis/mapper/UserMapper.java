package com.itsie.mybatis.mapper;

import java.util.List;

import com.itsie.mybatis.pojo.User;

public interface UserMapper {
	 User  queryUserById(int id);
	 List<User> queryUserByUsername(String username);
	 void updateUserById(User user);
	 void insertUser(User user);
}
