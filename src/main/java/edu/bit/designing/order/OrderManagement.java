package training.patterns.order;

import training.patterns.order.dto.CreateOrderRequest;
import training.patterns.order.dto.CreateOrderResponse;
import training.patterns.order.entity.Order;
import training.patterns.order.exceptions.OrderNotFoundException;
import training.patterns.order.exceptions.UnableToCreateOrderException;

public interface OrderManagement {

    // (better for exposing to internal layers)
    String createOrder(String userId) throws UnableToCreateOrderException; // success with order Id or else throw exception
    // versus (request - response objects for APIS) (feedback: choose based on who is going to consume this!)
    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) throws UnableToCreateOrderException; // success with order Id or else throw exception
    //  (better for exposing to external systems)

    // even if order exists and we are unable to confirm return false (boolean)
    // feedback: we shall throw an internal error if we want to have different user experience for confirmation failure
    void confirmOrder(String orderId) throws OrderNotFoundException, InternalError;

    Order viewOrder(String orderId) throws OrderNotFoundException, InternalError;

    // feedback: we could move these to the OrderInterface
//    void addProduct(String orderId, Product product) throws UpdateFailureException;
//
//    void removeProduct(String orderId, String productId) throws UpdateFailureException;
//
//    int findOrderAmount(String orderId) throws OrderNotFoundException; // should we pass the entire Order object
}