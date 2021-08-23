package egs.assignment.kourosh.entity;
import lombok.*;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Getter
//@Setter
@Entity
@Table(name="USER_AUTH_TBL")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    private boolean isActive;
    private String roles;

//    @OneToMany(mappedBy = "user")
//    Set<ProductRating> ratings;

}
