package Products;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Apple extends Product{
    public Apple() {
    }
    public String color;
    public Apple(int price, String title, int weight, String color) {
        super(price, title, weight);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Products.Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }
}
