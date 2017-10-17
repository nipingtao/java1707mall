package com.situ.mall.service;

import java.util.List;

import com.situ.mall.pojo.Order;
import com.situ.mall.pojo.OrderItem;


public interface IOrderItemService {

	List<OrderItem> findOrderItemByorder_no(Long orderNo);

	boolean add(Order order);

	int addOrderItem(OrderItem orderItem);

	Order findById(String id);

	List<Object> findorderByUser(Integer id);

	List<OrderItem> findByOrder(Long orderNo);





}
