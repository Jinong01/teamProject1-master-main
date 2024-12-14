package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.dto.OrderDetail;
import com.koreait.coffee.model.dto.ShoppingCart;
import com.koreait.coffee.model.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderController {
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    public DishController dishController = new DishController();

    void getAllOder(){mapper.getAllOder();}

    void addOrders(){mapper.addOrders();}

    public  void addOrderDetail(){
        List<ShoppingCart> shoppingCartList2 = shoppingCartController.getAllShoppingCart();
        for (int i = 0; i < shoppingCartList2.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPrice(shoppingCartList2.get(i).getAmount());
            orderDetail.setDishId(shoppingCartList2.get(i).getDishId());
            orderDetail.setPrice(shoppingCartList2.get(i).getAmount());
            orderDetail.setName(dishController.getDishById(shoppingCartList2.get(i).getDishId()).getName());
            orderDetail.setNumber(shoppingCartList2.get(i).getNumber());
            mapper.addOrderDetail(orderDetail);
        }
    }
}


