package com.luisfuentes.tareaapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import com.luisfuentes.tareaapi.model.Artist;

@DataJpaTest
class ArtistRepositoryTest {

	@Autowired
	private ArtistRepository artistRepository;

	@Test
	public void createArtist() {
		// Given
		Artist artist = new Artist();

		// When
		Artist createArtist = artistRepository.save(artist);

		// Then
		assertNotNull(createArtist);
	}

	@Test
	public void getArtistById() {
		// Given
		Long id = (long) 1;

		// When
		Optional<Artist> getArtistById = artistRepository.findById(id);

		// Then
		assertNotNull(getArtistById);
	}

	@Test
	public void getAllArtist() {

		// Given
		Artist artist = new Artist();
		artistRepository.save(artist);

		// When
		List<Artist> getAllArtists = artistRepository.findAll();

		// Then
		assertNotNull(getAllArtists);
		assertFalse(getAllArtists.isEmpty());
	}

	@Test
	public void deleteArtist() {

		// Given
		Artist artist = new Artist();
		Artist deleteArtist = artistRepository.save(artist);

		// When
		artistRepository.deleteById(deleteArtist.getId());

		// Then
		assertFalse(artistRepository.existsById(deleteArtist.getId()));
	}

}
