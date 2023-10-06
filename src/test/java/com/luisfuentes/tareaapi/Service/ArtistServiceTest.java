package com.luisfuentes.tareaapi.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.luisfuentes.tareaapi.model.Artist;
import com.luisfuentes.tareaapi.repository.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArtistServiceTest {

	@Mock
	private ArtistRepository artistRepository;

	@InjectMocks
	private ArtistService artistService;

	@Test
	void testCreateArtist() {
		// Given
		Artist artistToCreate = new Artist();

		// When
		when(artistRepository.save(any(Artist.class))).thenReturn(artistToCreate);
		Artist createdArtist = artistService.createArtist(artistToCreate);

		// Then
		assertNotNull(createdArtist);
	}

	@Test
	void testGetArtistById() {
		// Given
		Long artistId = 1L;
		Artist exampleArtist = new Artist();
		exampleArtist.setId(artistId);

		// When
		when(artistRepository.findById(artistId)).thenReturn(Optional.of(exampleArtist));
		Artist retrievedArtist = artistService.getArtistById(artistId);

		// Then
		assertNotNull(retrievedArtist);
		assertEquals(artistId, retrievedArtist.getId());
	}

	@Test
	void testGetAllArtist() {
		// Given
		List<Artist> exampleArtists = new ArrayList<>();
		exampleArtists.add(new Artist());
		exampleArtists.add(new Artist());

		// When
		when(artistRepository.findAll()).thenReturn(exampleArtists);
		List<Artist> retrievedArtists = artistService.getAllArtist();

		// Then
		assertNotNull(retrievedArtists);
		assertFalse(retrievedArtists.isEmpty());
		assertEquals(2, retrievedArtists.size());
	}

	@Test
	void testDeleteArtist() {
		// Given
		Long artistId = 1L;

		// When
		assertDoesNotThrow(() -> artistService.deleteArtist(artistId));

		// Then
		verify(artistRepository, times(1)).deleteById(eq(artistId));
	}
}
