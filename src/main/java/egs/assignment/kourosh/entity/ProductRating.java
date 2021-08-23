package egs.assignment.kourosh.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@ToString
@Entity(name = "PRODUCT_RATING")
public class ProductRating {
    public ProductRating() {
    }

    @EmbeddedId
    private ProductRatingKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "users_id")
    private Users users;

    private int rating;
}
