package server.convert;

import lib.dto.LocNastereDto;
import lib.dto.RegizorDto;
import server.model.LocNastere;
import server.model.Regizor;

import java.util.Optional;

public final class RegizorConvertor {

    private RegizorConvertor() {
    }

    public static Regizor convert(RegizorDto regizorDto) {
        var regizor = new Regizor();

        regizor.setId(regizorDto.getId());
        regizor.setNume(regizorDto.getNume());
        regizor.setDataNastere(regizorDto.getDataNastere());
        regizor.setNrPets(regizorDto.getNrPets());

        Optional.ofNullable(regizorDto.getLocNastere())
                .ifPresent(locNastereDto -> {
                    var locNastere = new LocNastere();

                    locNastere.setOras(locNastereDto.getOras());
                    locNastere.setTara(locNastereDto.getTara());

                    regizor.setLocNastere(locNastere);
                });

        return regizor;
    }

    public static RegizorDto convert(Regizor regizor) {
        var regizorDto = new RegizorDto(
                regizor.getNume(),
                regizor.getDataNastere(),
                null,
                regizor.getNrPets()
        );

        Optional.ofNullable(regizor.getLocNastere())
                .ifPresent(locNastere -> {
                    regizorDto.setLocNastere(new LocNastereDto(
                            locNastere.getOras(),
                            locNastere.getTara()
                    ));
                });
        regizorDto.setId(regizor.getId());

        return regizorDto;
    }
}
