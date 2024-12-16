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
        if (UserView.loginUser!=null){order.setUserId(UserView.loginUser.getId());} // 포인트적립/사용으로 유저 정보를 입력했으면 그 유저의 아이디 값을 order 테이블에 저장
        order.setAmount(amount); order.setOrderTime(time); order.setPoint(point);
        order.setStatus(1); order.setPayStatus(2);
        mapper.addOrders(order);}

    public void updateOrders(){
        Order order = mapper.nowOrder();
        order.setPayStatus(1); order.setEndTime(LocalDateTime.now()); // 결제 완료 후 결제상태 완료로 변경 및 결제 완료시간 변경
        mapper.updateOrders(order);}


    public  void addOrderDetail(){
        List<ShoppingCart> shoppingCartList2 = shoppingCartController.getAllShoppingCart();
        Order order = mapper.nowOrder();
        for (int i = 0; i < shoppingCartList2.size(); i++) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
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


