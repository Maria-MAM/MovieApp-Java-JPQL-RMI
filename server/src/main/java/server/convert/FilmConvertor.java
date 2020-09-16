package server.convert;

import lib.dto.FilmDto;
import server.model.Film;

import java.util.Collections;
import java.util.HashSet;

public final class FilmConvertor {

    private FilmConvertor() {
    }

    ;

    public static Film convert(FilmDto filmDto) {
        var film = new Film();

        film.setId(filmDto.getId());
        film.setTitlu(filmDto.getTitlu());
        film.setDataAparitie(filmDto.getDataAparitie());
        film.setDurata(filmDto.getDurata());
        film.setGen(filmDto.getGen());
        film.setLimbiVorbite(filmDto.getLimbiVorbite());

        return film;
    }

    public static FilmDto convert(Film film) {

        var filmDto = new FilmDto(
                film.getTitlu(),
                film.getDataAparitie(),
                film.getDurata(),
                film.getGen(),
                new HashSet<>(film.getLimbiVorbite()),
                Collections.emptySet(),
                0
        );
        filmDto.setId(film.getId());

        return filmDto;
    }
}
