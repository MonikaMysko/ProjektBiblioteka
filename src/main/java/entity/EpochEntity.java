package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EpochEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEpoch;
    private String epoch;
    private String urlEpoch;

    public String getUrlEpoch() {
        return urlEpoch;
    }

    public void setUrlEpoch(String urlEpoch) {
        this.urlEpoch = urlEpoch;
    }

    @OneToMany(mappedBy = "epoch", cascade = CascadeType.ALL)
    private List<BookEntity> bookEntityList;

    public EpochEntity() {
        bookEntityList=new ArrayList<>();
    }

    public int getIdEpoch() {
        return idEpoch;
    }

    public void setIdEpoch(int idEpoch) {
        this.idEpoch = idEpoch;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public List<BookEntity> getBookEntityList() {
        return bookEntityList;
    }

    public void setBookEntityList(List<BookEntity> bookEntityList) {
        this.bookEntityList = bookEntityList;
    }


    public void addBookEntityList(BookEntity bookEntity){
        bookEntityList.add(bookEntity);
    }
}
