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
		Album album = new Album();
		Album createAlbum = albumRepository.save(album);

		assertNotNull(createAlbum);
	}

	@Test
	public void getAlbumById() {
		Long id = (long) 1;
		Optional<Album> getAlbum = albumRepository.findById(id);

		assertNotNull(getAlbum);
	}

	@Test
	public void getAllAlbum() {
		Album album = new Album();
		albumRepository.save(album);

		List<Album> allAlbum = albumRepository.findAll();

		assertNotNull(allAlbum);
		assertFalse(allAlbum.isEmpty());
	}

	@Test
	public void deleteAlbum() {
		Album album = new Album();
		Album deleteAlbum = albumRepository.save(album);

		albumRepository.deleteById(deleteAlbum.getId());

		assertFalse(albumRepository.existsById(deleteAlbum.getId()));
	}

}
