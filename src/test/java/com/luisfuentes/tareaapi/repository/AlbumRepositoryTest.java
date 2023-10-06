package com.luisfuentes.tareaapi.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.luisfuentes.tareaapi.model.Album;

@DataJpaTest
class AlbumRepositoryTest {

	@Autowired
	private AlbumRepository albumRepository;

	@Test
	public void createAlbum() {
		// Given
		Album album = new Album();

		// When
		Album createAlbum = albumRepository.save(album);

		assertNotNull(createAlbum);
	}

	@Test
	public void getAlbumById() {
		// Given
		Long id = (long) 1;

		// When
		Optional<Album> getAlbum = albumRepository.findById(id);

		// Then
		assertNotNull(getAlbum);
	}

	@Test
	public void getAllAlbum() {
		// Given
		Album album = new Album();
		albumRepository.save(album);

		// When
		List<Album> allAlbum = albumRepository.findAll();

		// Then
		assertNotNull(allAlbum);
		assertFalse(allAlbum.isEmpty());
	}

	@Test
	public void deleteAlbum() {
		// Given
		Album album = new Album();
		Album deleteAlbum = albumRepository.save(album);

		// When
		albumRepository.deleteById(deleteAlbum.getId());

		// Then
		assertFalse(albumRepository.existsById(deleteAlbum.getId()));
	}

}
