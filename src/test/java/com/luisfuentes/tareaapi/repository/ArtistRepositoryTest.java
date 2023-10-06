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
		Artist artist = new Artist();
		Artist createArtist = artistRepository.save(artist);

		assertNotNull(createArtist);
	}

	@Test
	public void getArtistById() {
		Long id = (long) 1;
		Optional<Artist> getArtistById = artistRepository.findById(id);

		assertNotNull(getArtistById);
	}

	@Test
	public void getAllArtist() {
		Artist artist = new Artist();
		artistRepository.save(artist);

		
		List<Artist> getAllArtists = artistRepository.findAll();

		
		assertNotNull(getAllArtists);
		assertFalse(getAllArtists.isEmpty());
	}

	@Test
	public void deleteArtist() {
		Artist artist = new Artist();
		Artist deleteArtist = artistRepository.save(artist);

		artistRepository.deleteById(deleteArtist.getId());

		assertFalse(artistRepository.existsById(deleteArtist.getId()));
	}

}
