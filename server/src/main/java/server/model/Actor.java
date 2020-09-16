package server.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor extends Persoana {

    private boolean casatorit;

    @ManyToMany(mappedBy = "actori")
    private Set<Film> filme = new HashSet<>();

    public boolean isCasatorit() {
        return casatorit;
    }

    public void setCasatorit(boolean casatorit) {
        this.casatorit = casatorit;
    }

}
