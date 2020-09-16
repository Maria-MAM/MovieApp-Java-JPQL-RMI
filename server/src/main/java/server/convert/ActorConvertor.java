package server.convert;

import lib.dto.ActorDto;
import lib.dto.LocNastereDto;
import server.model.Actor;
import server.model.LocNastere;

import java.util.Optional;

public final class ActorConvertor {

    private ActorConvertor() {
    }

    public static Actor convert(ActorDto actorDto) {
        var actor = new Actor();

        actor.setId(actorDto.getId());
        actor.setDataNastere(actorDto.getDataNastere());
        actor.setNume(actorDto.getNume());
        actor.setCasatorit(actorDto.isCasatorit());

        Optional.ofNullable(actorDto.getLocNastere())
                .ifPresent(locNastereDto -> {
                    var locNastere = new LocNastere();

                    locNastere.setOras(locNastereDto.getOras());
                    locNastere.setTara(locNastereDto.getTara());

                    actor.setLocNastere(locNastere);
                });

        return actor;
    }

    public static ActorDto convert(Actor actor) {
        var actorDto = new ActorDto(
                actor.getNume(),
                actor.getDataNastere(),
                null,
                actor.isCasatorit()
        );

        Optional.ofNullable(actor.getLocNastere())
                .ifPresent(locNastere -> {
                    actorDto.setLocNastere(new LocNastereDto(
                            locNastere.getOras(),
                            locNastere.getTara()
                    ));
                });
        actorDto.setId(actor.getId());
        return actorDto;
    }


}
