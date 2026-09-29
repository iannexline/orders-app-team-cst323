package edu.ianexline.products.models;

public class Mapper {

    // Convert a database entity into a model for the web pages
    public static OrderModel toModel(OrderEntity entity) {
        OrderModel model = new OrderModel();
        model.setId(entity.getId() == null ? 0 : entity.getId());
        model.setOrder_number(entity.getOrderNumber());
        model.setProduct_name(entity.getProductName());
        model.setPrice(entity.getPrice());
        model.setQuantity(entity.getQuantity());
        return model;
    }

    // Convert a model from a web form into a database entity
    public static OrderEntity toEntity(OrderModel model) {
        OrderEntity entity = new OrderEntity();
        // an id of 0 means a brand-new order, so leave it null and let MySQL assign one
        entity.setId(model.getId() == 0 ? null : model.getId());
        entity.setOrderNumber(model.getOrder_number());
        entity.setProductName(model.getProduct_name());
        entity.setPrice(model.getPrice());
        entity.setQuantity(model.getQuantity());
        return entity;
    }
}