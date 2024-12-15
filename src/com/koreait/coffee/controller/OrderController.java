package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.dto.Order;
import com.koreait.coffee.model.dto.OrderDetail;
import com.koreait.coffee.model.dto.ShoppingCart;
import com.koreait.coffee.model.mapper.OrderMapper;
import com.koreait.coffee.view.UserView;
import org.apache.ibatis.session.SqlSession;
import java.time.LocalDateTime;
import java.util.List;

public class OrderController {
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    public DishController dishController = new DishController();

    void getAllOder(){mapper.getAllOder();}

    public void addOrders(Double point, Double amount, LocalDateTime time){
        Order order = new Order();
        if (UserView.loginUser!=null){
            order.setUserId(UserView.loginUser.getId());}
        order.setAmount(amount); order.setOrderTime(time); order.setPoint(point);
        order.setStatus(1); order.setPayStatus(2);
        mapper.addOrders(order);}

//    public void updateOrders(){
//        Order order = mapper.nowOrder();
//        order.setPayStatus(1); order.setEndTime(LocalDateTime.now());
//        mapper.updateOrders(order);}

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

    public void deleteOrderDetail(){mapper.deleteOrderDetail();}
}


