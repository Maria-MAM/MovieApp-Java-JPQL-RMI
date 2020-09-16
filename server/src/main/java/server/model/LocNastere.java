package server.model;

import javax.persistence.Embeddable;

@Embeddable
public class LocNastere {

    private String oras;

    private String tara;

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }
}
