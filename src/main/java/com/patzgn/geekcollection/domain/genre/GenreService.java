package com.patzgn.geekcollection.domain.genre;

import com.patzgn.geekcollection.domain.genre.dto.GenreDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreDto> findAllGenres() {
        return StreamSupport.stream(genreRepository.findAll().spliterator(), false)
                .map(GenreDtoMapper::map)
                .toList();
    }

    @Transactional
    public void addGenre(GenreDto genre) {
        Genre genreToSave = new Genre();
        genreToSave.setName(genre.getName());
        genreRepository.save(genreToSave);
    }
}
