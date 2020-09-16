package lib.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class FilmDto implements Serializable {

    private int id;

    private String titlu;

    private LocalDate dataAparitie;

    private int durata;

    private Gen gen;

    private Set<LimbaVorbita> limbiVorbite;

    private Set<Integer> idActori = new HashSet<>();

    private int idRegizor;

    public FilmDto(String titlu, LocalDate dataAparitie, int durata, Gen gen,
                   Set<LimbaVorbita> limbiVorbite, Set<Integer> idActori, int idRegizor) {
        this.titlu = titlu;
        this.dataAparitie = dataAparitie;
        this.durata = durata;
        this.gen = gen;
        this.limbiVorbite = limbiVorbite;
        this.idActori = idActori;
        this.idRegizor = idRegizor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public LocalDate getDataAparitie() {
        return dataAparitie;
    }

    public void setDataAparitie(LocalDate dataAparitie) {
        this.dataAparitie = dataAparitie;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public Gen getGen() {
        return gen;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public Set<LimbaVorbita> getLimbiVorbite() {
        return limbiVorbite;
    }

    public void setLimbiVorbite(Set<LimbaVorbita> limbiVorbite) {
        this.limbiVorbite = limbiVorbite;
    }

    public Set<Integer> getIdActori() {
        return idActori;
    }

    public void setIdActori(Set<Integer> idActori) {
        this.idActori = idActori;
    }

    public int getIdRegizor() {
        return idRegizor;
    }

    public void setIdRegizor(int idRegizor) {
        this.idRegizor = idRegizor;
    }

    @Override
    public String toString() {
        return "FilmDto{" +
                "id=" + id +
                ", titlu='" + titlu + '\'' +
                ", dataAparitie=" + dataAparitie +
                ", durata=" + durata +
                ", gen=" + gen +
                ", limbiVorbite=" + limbiVorbite +
                '}';
    }
}
