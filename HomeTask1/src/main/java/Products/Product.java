package Products;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= Apple.class, name="apple"),
        @JsonSubTypes.Type(value= Orange.class, name="orange")
})
@JsonAutoDetect
public class Product {
    public Product() {
    }

    @Override
    public String toString() {
        return "Products.Product{" +
                "weight=" + weight +
                ", price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

    @JsonIgnore
    public int weight;
    public int price;
    public String title;

    public Product(int price, String title, int weight) {
        this.price = price;
        this.title = title;
        this.weight = weight;
    }
}
