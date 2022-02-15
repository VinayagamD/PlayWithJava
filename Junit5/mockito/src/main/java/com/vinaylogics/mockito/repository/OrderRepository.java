package com.vinaylogics.mockito.repository;

import com.vinaylogics.mockito.models.Order;

public interface OrderRepository {
    Order save(Order order);
}
