package lib.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class ActorDto implements Serializable {

    private int id;

    private String nume;

    private LocalDate dataNastere;

    private LocNastereDto locNastere;

    private boolean casatorit;

    public ActorDto(String nume, LocalDate dataNastere, LocNastereDto locNastere,
                    boolean casatorit) {
        this.nume = nume;
        this.dataNastere = dataNastere;
        this.locNastere = locNastere;
        this.casatorit = casatorit;
    }

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

    public LocNastereDto getLocNastere() {
        return locNastere;
    }

    public void setLocNastere(LocNastereDto locNastere) {
        this.locNastere = locNastere;
    }

    public boolean isCasatorit() {
        return casatorit;
    }

    public void setCasatorit(boolean casatorit) {
        this.casatorit = casatorit;
    }

    @Override
    public String toString() {
        return "ActorDto{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", dataNastere=" + dataNastere +
                ", locNastere=" + locNastere +
                ", casatorit=" + casatorit +
                '}';
    }
}
