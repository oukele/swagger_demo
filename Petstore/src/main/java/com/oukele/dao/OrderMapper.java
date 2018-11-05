package com.oukele.dao;

import com.oukele.model.Order;
import java.util.List;

public interface OrderMapper {
    int insert(Order record);

    List<Order> selectAll();
}