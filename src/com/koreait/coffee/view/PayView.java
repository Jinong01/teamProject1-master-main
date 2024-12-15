package com.koreait.coffee.view;

import com.koreait.coffee.controller.DishController;
import com.koreait.coffee.controller.OrderController;
import com.koreait.coffee.controller.ShoppingCartController;
import com.koreait.coffee.model.dto.DishFlavor;
import com.koreait.coffee.model.dto.OrderDetail;
import com.koreait.coffee.model.dto.ShoppingCart;

import java.util.List;
import java.util.Map;

public class PayView {
    public UserView userView = new UserView();
    public ShoppingCartController shoppingCartController = new ShoppingCartController();
    public DishController dishController = new DishController();
    public OrderController orderController = new OrderController();

    public void pointView(Double point, Double amount) {
        userView.signIn(point , amount);
    }

    public void paySuccess() {
        System.out.println("결제 성공");
        orderController.addOrderDetail();              // 결제성공하면 장바구니에 담겨있던 항목들 orderDetail 에 담기
        shoppingCartController.deleteAllShoppingCart();// 결제성공하면 장바구니 삭제
        orderController.deleteOrderDetail();           // 결제성공하면 orderDetail 삭제
//        orderController.updateOrders();              // 결제성공 후 결제상태 결제 완료로 변경
    }

    public void mainView(){                             // 다시 초기화면으로
        MainView mainView = new MainView();
        shoppingCartController.deleteAllShoppingCart(); // 장바구니 삭제
        mainView.mainView();
    }
}
