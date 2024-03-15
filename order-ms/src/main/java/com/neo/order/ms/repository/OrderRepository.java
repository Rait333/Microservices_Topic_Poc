package com.neo.order.ms.repository;

import com.neo.order.ms.entity.OrderTable;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderTable, Long> {
}
