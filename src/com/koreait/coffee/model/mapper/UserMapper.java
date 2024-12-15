package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Insert("insert into user (name, phone_Number, point, type) values (#{name},#{phoneNumber},#{point},#{type})")
    void insertUser(User user);

    User getUserByPhoneNumber(String phone_number);

    void updateUserByPhoneNumber(User user);

}
