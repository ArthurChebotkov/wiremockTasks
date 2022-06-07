package Orders;

import Products.Product;

import Addresses.Address;

import java.util.List;
public class Order {
    public static int count;

    public int id;
    public List<Product> productList;

    public Order() {
    }

    public Address address;

    @Override
    public String toString() {
        return "Order{" + "orderID=" + id +
                ", productList=" + productList + '\'' +
                ", address=" + address +
                '}';
    }

    public Order(List<Product> productList,Address address) {
        count++;
        id = count;
        this.productList = productList;
        this.address = address;
    }

}
