package egs.assignment.kourosh.entity;

import javax.persistence.Column;
import  java.io.Serializable;

public class ProductRatingKey implements Serializable  {

    private static final long serialVersionUID = -2543425088717298236L;

    @Column(name = "users_id")
    private Long users;

    @Column(name = "product_id")
    private Long product;

}
