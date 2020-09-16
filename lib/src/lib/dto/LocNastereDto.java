package lib.dto;

import java.io.Serializable;

public class LocNastereDto implements Serializable {

    private final String oras;

    private final String tara;

    public LocNastereDto(String oras, String tara) {
        this.oras = oras;
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public String getTara() {
        return tara;
    }

    @Override
    public String toString() {
        return "LocNastereDto{" +
                "oras='" + oras + '\'' +
                ", tara='" + tara + '\'' +
                '}';
    }
}
