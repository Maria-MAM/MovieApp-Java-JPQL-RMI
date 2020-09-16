package lib.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class RegizorDto implements Serializable {

    private int id;

    private String nume;

    private LocalDate dataNastere;

    private LocNastereDto locNastere;

    private int nrPets;

    public RegizorDto(String nume, LocalDate dataNastere, LocNastereDto locNastere, int nrPets) {
        this.nume = nume;
        this.dataNastere = dataNastere;
        this.locNastere = locNastere;
        this.nrPets = nrPets;
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

    public int getNrPets() {
        return nrPets;
    }

    public void setNrPets(int nrPets) {
        this.nrPets = nrPets;
    }

    @Override
    public String toString() {
        return "RegizorDto{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", dataNastere=" + dataNastere +
                ", locNastere=" + locNastere +
                ", nrPets=" + nrPets +
                '}';
    }
}
