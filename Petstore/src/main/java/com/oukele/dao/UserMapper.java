package com.oukele.dao;

import com.oukele.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserMapper {

    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();

    User login(User user);

    User selectByUserName(User user);

    int updateByPrimaryKey(User record);
}