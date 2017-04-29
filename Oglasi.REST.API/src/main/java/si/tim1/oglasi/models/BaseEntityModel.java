package si.tim1.oglasi.models;


import javax.persistence.*;

/**
 * Created by Adnan on 4/29/2017.
 */
@MappedSuperclass
public class BaseEntityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
