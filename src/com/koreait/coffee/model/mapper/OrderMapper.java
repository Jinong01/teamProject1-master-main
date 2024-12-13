package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.Order;
import com.koreait.coffee.model.dto.OrderDetail;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders")
    List<Order> getAllOder();

    void addOrders();

    void addOrderDetail(OrderDetail orderDetail);
}
