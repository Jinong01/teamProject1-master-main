package com.koreait.coffee.controller;

import com.koreait.coffee.config.MysqlConfig;
import com.koreait.coffee.model.dto.*;
import com.koreait.coffee.model.mapper.OrderMapper;
import com.koreait.coffee.model.mapper.ShoppingCartMapper;
import org.apache.ibatis.session.SqlSession;
import java.time.LocalDateTime;
import java.util.List;



public class ShoppingCartController {
    public SqlSession sqlSession = MysqlConfig.mysqlConnect();
    public ShoppingCartMapper mapper = sqlSession.getMapper(ShoppingCartMapper.class);
    public OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

    public void selectShoppingCart(){mapper.selectShoppingCart();}

    public void add(Dish dish, Temperature temperature , Shot shot){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setDishId(dish.getId());shoppingCart.setTemperature(temperature); shoppingCart.setShot(shot);
        ShoppingCart shoppingCart1 = mapper.getShoppingCart(shoppingCart);  // 설정한 음식과 같은 설정의 음식이 있는지 shoppingCart1로 확인
        if (shoppingCart1==null){                                           // shoppingCart1이 장바구니에 없으면
            shoppingCart.setNumber(1);                                      // 음식을 처음 담을 때 수량을 +1이 아닌 null -> 1로 바꿈
            shoppingCart.setCreateTime(LocalDateTime.now());                // 장바구니에 선택한 시간 저장
            mapper.insertShoppingCart(shoppingCart);                        // 장바구니에 선택한 음식 저장
            mapper.updateAmount(shoppingCart.getId(),dish.getId());         // 장바구니에 선택한 음식가격과 수량 계산해서 값 대입

        } else if (shoppingCart1.getNumber() >= 1 &&  shoppingCart1.getTemperature() == temperature && shoppingCart1.getShot() == shot){
            // shoppingCart1이 장바구니에 있으면
            shoppingCart.setNumber(shoppingCart1.getNumber()+1);            // 같은 설정의 음식의 숫자를 1개 늘림
            mapper.updateShoppingCartByDishId(shoppingCart);
            shoppingCart.setCreateTime(LocalDateTime.now());
            mapper.updateAmount(shoppingCart.getId(),dish.getId());
        }
    }

    public void deleteByDishId(Integer dishId){
        mapper.deleteShoppingCartByDishId(dishId);
    }

    public void deleteById(Integer id){
        mapper.deleteShoppingCartById(id);
    }

    // 장바구니에 담긴 모든 음식의 가격 호출 = 결제할 금액
    public Double getOrderAmount(){
        return mapper.getOrderAmount();}

    public void deleteAllShoppingCart(){
        mapper.deleteAllShoppingCart();
    }

    public List<ShoppingCart> getAllShoppingCart(){
        return mapper.selectShoppingCart();
    }
}
