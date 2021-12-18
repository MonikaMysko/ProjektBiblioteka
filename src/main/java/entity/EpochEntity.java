package entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class EpochEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEpoch;
    private String epoch;
    private String urlEpoch;


    @OneToMany(mappedBy = "epoch", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;

    public EpochEntity() {
        bookEntityList = new ArrayList<>();
    }

    public void addBookEntityList(BookEntity bookEntity) {
        bookEntityList.add(bookEntity);
    }
}
