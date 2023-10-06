package com.luisfuentes.tareaapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.luisfuentes.tareaapi.model.Artist;
import com.luisfuentes.tareaapi.Service.ArtistService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ArtistController.class)
class ArtistControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private ArtistService artistService;

	@InjectMocks
	private ArtistController artistController;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateArtist() throws Exception {
		// Given
		Artist artistToCreate = new Artist();
		when(artistService.createArtist(any(Artist.class))).thenReturn(artistToCreate);

		// When/Then
		mockMvc.perform(post("/api/artist").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(artistToCreate))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists());
	}

	@Test
	void testGetAllArtist() throws Exception {
		// Given
		List<Artist> exampleArtists = new ArrayList<>();
		when(artistService.getAllArtist()).thenReturn(exampleArtists);

		// When/Then
		mockMvc.perform(get("/api/artist")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
	}

	@Test
	void testSearchArtistById() throws Exception {
		// Given
		Long artistId = 1L;
		Artist exampleArtist = new Artist();
		exampleArtist.setId(artistId);
		when(artistService.getArtistById(artistId)).thenReturn(exampleArtist);

		// When/Then
		mockMvc.perform(get("/api/artist/{id}", artistId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(artistId));
	}

	@Test
	void testDeleteArtistById() throws Exception {
		// Given
		Long artistIdToDelete = 1L;

		// When/Then
		mockMvc.perform(delete("/api/artist/{id}", artistIdToDelete)).andExpect(status().isOk());

		verify(artistService, times(1)).deleteArtist(artistIdToDelete);
	}

	@Test
	void testUpdateArtist() throws Exception {
		// Given
		Artist artistToUpdate = new Artist();
		when(artistService.createArtist(any(Artist.class))).thenReturn(artistToUpdate);

		// When/Then
		mockMvc.perform(put("/api/artist").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(artistToUpdate))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists());
	}
}
