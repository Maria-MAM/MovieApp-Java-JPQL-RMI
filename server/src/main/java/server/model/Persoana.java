package server.model;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persoana {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nume;

    private LocalDate dataNastere;

    @Embedded
    private LocNastere locNastere;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public LocalDate getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(LocalDate dataNastere) {
        this.dataNastere = dataNastere;
    }

    public LocNastere getLocNastere() {
        return locNastere;
    }

    public void setLocNastere(LocNastere locNastere) {
        this.locNastere = locNastere;
    }
}
