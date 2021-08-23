package egs.assignment.kourosh.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, length = 100)
    private String userName;

    @Column(name = "useremail", nullable = false, length = 100)
    private String userEmail;

    @Column(name = "comment", nullable = false, length = 1000)
    private String comment;

    @Column(name = "rating", nullable = true)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @Column(name = "created", nullable = true)
    private Date created;

    @PrePersist
    protected void onCreate() {
        created = new java.util.Date();
    }


}