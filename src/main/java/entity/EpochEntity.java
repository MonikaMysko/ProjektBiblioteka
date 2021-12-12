package entity;

import javax.persistence.*;
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

    @Override
    public String toString() {
        return "EpochEntity{" +
                "idEpoch=" + idEpoch +
                ", epoch='" + epoch + '\'' +
                ", urlEpoch='" + urlEpoch + '\'' +
                ", bookEntityList=" + bookEntityList +
                '}';
    }

    public void addBookEntityList(BookEntity bookEntity){
        bookEntityList.add(bookEntity);
    }
}
