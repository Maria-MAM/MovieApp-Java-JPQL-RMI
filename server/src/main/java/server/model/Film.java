package server.model;

import lib.dto.Gen;
import lib.dto.LimbaVorbita;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titlu;

    private LocalDate dataAparitie;

    private int durata;

    @Enumerated(EnumType.STRING)
    private Gen gen;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Collection<LimbaVorbita> limbiVorbite;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "id_film"),
            inverseJoinColumns = @JoinColumn(name = "id_actor"))
    private Set<Actor> actori = new HashSet<>();

    @ManyToOne
    private Regizor regizor;

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

    public Collection<LimbaVorbita> getLimbiVorbite() {
        return limbiVorbite;
    }

    public void setLimbiVorbite(Collection<LimbaVorbita> limbiVorbite) {
        this.limbiVorbite = limbiVorbite;
    }

    public Set<Actor> getActori() {
        return actori;
    }

    public void setActori(Set<Actor> actori) {
        this.actori = actori;
    }

    public Regizor getRegizor() {
        return regizor;
    }

    public void setRegizor(Regizor regizor) {
        this.regizor = regizor;
    }
}
