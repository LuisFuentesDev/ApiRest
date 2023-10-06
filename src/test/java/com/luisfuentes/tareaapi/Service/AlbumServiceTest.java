package com.luisfuentes.tareaapi.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.luisfuentes.tareaapi.model.Album;
import com.luisfuentes.tareaapi.repository.AlbumRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AlbumServiceTest {

	@Mock
	private AlbumRepository albumRepository;

	@InjectMocks
	private AlbumService albumService;

	@Test
	void testCreateAlbum() {
		// Given
		Album albumToCreate = new Album();

		// When
		when(albumRepository.save(any(Album.class))).thenReturn(albumToCreate);
		Album createdAlbum = albumService.createAlbum(albumToCreate);

		// Then
		assertNotNull(createdAlbum);
	}

	@Test
	void testGetAlbumById() {
		// Given
		Long albumId = 1L;
		Album exampleAlbum = new Album();
		exampleAlbum.setId(albumId);

		// When
		when(albumRepository.findById(albumId)).thenReturn(Optional.of(exampleAlbum));
		Album retrievedAlbum = albumService.getAlbumById(albumId);

		// Then
		assertNotNull(retrievedAlbum);
		assertEquals(albumId, retrievedAlbum.getId());
	}

	@Test
	void testGetAllAlbum() {
		// Given
		List<Album> exampleAlbums = new ArrayList<>();
		exampleAlbums.add(new Album());
		exampleAlbums.add(new Album());

		// When
		when(albumRepository.findAll()).thenReturn(exampleAlbums);
		List<Album> retrievedAlbums = albumService.getAllAlbum();

		// Then
		assertNotNull(retrievedAlbums);
		assertFalse(retrievedAlbums.isEmpty());
		assertEquals(2, retrievedAlbums.size());
	}

	@Test
	void testDeleteAlbum() {
		// Given
		Long deleteAlbumById = 1L;

		// When
		assertDoesNotThrow(() -> albumService.deleteAlbum(deleteAlbumById));

		// Then
		verify(albumRepository, times(1)).deleteById(eq(deleteAlbumById));
	}
}
