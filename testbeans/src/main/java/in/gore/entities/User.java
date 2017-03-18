package in.gore.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by mihirgore on 19/10/16.
 */
@Entity
@Table(name="my_user")
public class User implements Serializable {
    @Id
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long i) {
        id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String  n) {
        name = n;
    }
}
