package edu.ianexline.products.data;

import org.springframework.data.repository.CrudRepository;

import edu.ianexline.products.models.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Integer> {
}