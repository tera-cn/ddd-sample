package vip.tera.dddsamaple.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Data
public class Product {

    private UUID id;
    private String name;
    private BigDecimal price;

    @JsonCreator
    public Product(@JsonProperty("id") final UUID id, @JsonProperty("price") final BigDecimal price, @JsonProperty("name") final String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.getId()) && Objects.equals(price, product.getPrice()) && Objects.equals(name, product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }
}
