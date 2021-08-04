package training.patterns.order.entity;

import training.patterns.order.exceptions.OrderNotFoundException;
import training.patterns.order.exceptions.UpdateFailureException;

import java.util.Collection;

public abstract class Order {
    String orderId;
    String userId;
    Collection<Product> productCollection;

    // hold the state unless the confirmation and then generate the id via order management
    abstract void addProduct(String orderId, Product product) throws UpdateFailureException;

    abstract void removeProduct(String orderId, String productId) throws UpdateFailureException;

    abstract int findOrderAmount(String orderId) throws OrderNotFoundException;
}