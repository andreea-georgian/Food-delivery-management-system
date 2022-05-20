package BusinessLogic;

import java.time.LocalDateTime;

public class Order {
    private int orderID;
    private int clientID;
    private LocalDateTime data;

    public Order(int orderID, int clientID) {
        this.orderID = orderID;
        this.clientID = clientID;
        data = LocalDateTime.now();
    }

    public int hashCode() {
        return 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public LocalDateTime getData() {
        return data;
    }
}
