package server.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Regizor extends Persoana {

    private int nrPets;

    @OneToMany(mappedBy = "regizor")
    private Collection<Film> filme = new HashSet<>();

    public int getNrPets() {
        return nrPets;
    }

    public void setNrPets(int nrPets) {
        this.nrPets = nrPets;
    }

    public Collection<Film> getFilme() {
        return filme;
    }

    public void setFilme(Collection<Film> filme) {
        this.filme = filme;
    }
}
