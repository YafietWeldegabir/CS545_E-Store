package waa.finalproject.domain;

public enum OrderStatus {

    ORDERED("Ordered"), SHIPPED("Shipped"), CANCELLED("Cancelled"), DELIVERED("Delivered");

    private String status;

    OrderStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
