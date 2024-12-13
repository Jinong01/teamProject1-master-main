package com.koreait.coffee.model.mapper;

import com.koreait.coffee.model.dto.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
import java.util.Map;


public interface ShoppingCartMapper {

    // 선택한 메뉴 옵션 설정하여 장바구니에 추가
    void insertShoppingCart(ShoppingCart shoppingCart);

    //update
    void updateShoppingCartByDishId(ShoppingCart shoppingCart);

    @Delete("delete from shopping_cart where dish_id = #{dishId}")
    void deleteShoppingCartByDishId(Integer dishId);

    @Delete("delete from shopping_cart where id =#{id}")
    void deleteShoppingCartById(Integer id);

    @Select("select * from shopping_cart")
    List<ShoppingCart> selectShoppingCart();

    // shopping_cart 에 음식가격 x 수량한 가격 대입
    void updateAmount(Integer ShoppingCartId,Integer dishId);

    // shopping_cart 의 id 가 0보다 큰 값 삭제 = 일괄 장바구니 삭제
    @Delete("delete from shopping_cart where id>0")
    void deleteAllShoppingCart();

    // 장바구니에 담긴 모든 음식의 총 가격 호출 = 결제할 금액
    Double getOrderAmount();

    ShoppingCart getShoppingCart(ShoppingCart shoppingCart);
}
