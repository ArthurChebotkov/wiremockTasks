package HomeTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import Addresses.Address;
import Orders.Order;
import Products.Apple;
import Products.Orange;
import Products.Product;

public class HomeTask1 {
    public static void main(String[] args) throws IOException {

        int numberOrders = 10;

        //Create varied List of Addresses
        List<Address> addressList = new ArrayList<>();

        List<String> cities = new ArrayList<>();
        cities.add("Moscow");
        cities.add("Vladivistok");
        cities.add("Kazan");

        List<String> streets = new ArrayList<>();
        streets.add("Sovetskai");
        streets.add("Pervomaiski");
        streets.add("Lenina");


        for (int i = 0; i < numberOrders; i++) {
            int randomHouseNumber = (int)(Math.random()*100);
            int randomFloorNumber = (int)(Math.random()*15);
            int randomApartmentNumber = (int)(Math.random()*150);
            String city = cities.get((int)(Math.random()*3));
            String street = streets.get((int)(Math.random()*3));
            Address address = new Address("Russia", city, street,randomHouseNumber,randomFloorNumber,randomApartmentNumber);
            addressList.add(address);
        }

        // Create varied List of Apple and Oranges
        List<Apple> appleList = new ArrayList<>();
        List<Orange> orangeList = new ArrayList<>();

        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");

        List<Boolean> isWithBones = new ArrayList<>();
        isWithBones.add(true);
        isWithBones.add(false);


        for (int i = 0; i < numberOrders; i++) {
            int randomPriceApple = (int)(Math.random()*1000);
            int randomWeightApple = (int)(Math.random()*1000);

            String color = colors.get((int)(Math.random()*2));
            Apple apple = new Apple(randomPriceApple,"apple",randomWeightApple, color);
            appleList.add(apple);

            int randomPriceOrange = (int)(Math.random()*1000);
            int randomWeightOrange = (int)(Math.random()*1000);

            Boolean withBones = isWithBones.get((int)(Math.random()*2));
            Orange orange = new Orange(randomPriceOrange,"Orange",randomWeightOrange, withBones);
            orangeList.add(orange);
        }


        // Create 100 Orders in List<Order>
        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < numberOrders; i++) {
            List<Product> products = new ArrayList<>();
            products.add(appleList.get(i));
            products.add(orangeList.get(i));
            Order order = new Order(products,addressList.get(i));
            orderList.add(order);
        }

        // Look at List of Orders
        System.out.println(orderList.toString());

        // Serialization
        ObjectMapper mapper = new ObjectMapper();
        FileWriter fileWriter = new FileWriter("src/orderList.json");
        mapper.writeValue(fileWriter, orderList);


        // Deserialization
        FileReader fileReader = new FileReader("src/orderList.json");
        List<Order> orderListOut = mapper.readValue(fileReader,  new TypeReference<List<Order>>() {});

        // Look at the deserialized object (List<Order>)
        System.out.println(orderListOut.toString());

    }
}