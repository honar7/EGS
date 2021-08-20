package egs.assignment.kourosh.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name="USER_AUTH_TBL")
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password;
    private boolean isActive;
    private String roles;
}
