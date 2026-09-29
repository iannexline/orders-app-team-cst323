package edu.ianexline.products.data;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ianexline.products.models.Mapper;
import edu.ianexline.products.models.OrderEntity;
import edu.ianexline.products.models.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {

    // dependency injection: Spring creates the repository and hands it to us
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public OrderModel getById(int id) {
        OrderEntity orderEntity = ordersRepository.findById(id).orElse(null);
        if (orderEntity == null) {
            return null;
        }
        return Mapper.toModel(orderEntity);
    }

    @Override
    public Iterable<OrderModel> getAll() {
        ArrayList<OrderModel> orderModels = new ArrayList<OrderModel>();
        Iterable<OrderEntity> orderEntities = ordersRepository.findAll();
        for (OrderEntity orderEntity : orderEntities) {
            orderModels.add(Mapper.toModel(orderEntity));
        }
        return orderModels;
    }

    @Override
    public OrderModel create(OrderModel item) {
        OrderEntity orderEntity = ordersRepository.save(Mapper.toEntity(item));
        return Mapper.toModel(orderEntity);
    }

    @Override
    public OrderModel update(OrderModel item) {
        OrderEntity orderEntity = ordersRepository.save(Mapper.toEntity(item));
        return Mapper.toModel(orderEntity);
    }

    @Override
    public boolean deleteById(int id) {
        ordersRepository.deleteById(id);
        return true;
    }
}