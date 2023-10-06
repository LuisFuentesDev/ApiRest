package com.luisfuentes.tareaapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.luisfuentes.tareaapi.model.Artist;
import com.luisfuentes.tareaapi.Service.ArtistService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArtistController.class)
class ArtistControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArtistService artistService;

	@InjectMocks
	private ArtistController artistController;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreateArtist() throws Exception {
	    // Given
	    Artist artist = new Artist();
	    when(artistService.createArtist(any(Artist.class)))
	        .thenAnswer(invocation -> {
	            Artist createdArtist = invocation.getArgument(0);
	            createdArtist.setId(1L); 
	            return createdArtist;
	        });

	    // When/Then
	    mockMvc.perform(post("/api/artist")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(artist)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.id").exists())
	            .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
	}

	@Test
	void testGetAllArtist() throws Exception {
		// Given
		List<Artist> artist = new ArrayList<>();
		when(artistService.getAllArtist()).thenReturn(artist);

		// When/Then
		mockMvc.perform(get("/api/artist")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
	}

	@Test
	void testSearchArtistById() throws Exception {
		// Given
		Long artistId = 1L;
		Artist artist = new Artist();
		artist.setId(artistId);
		when(artistService.getArtistById(artistId)).thenReturn(artist);

		// When/Then
		mockMvc.perform(get("/api/artist/{id}", artistId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(artistId));
	}

	@Test
	void testDeleteArtistById() throws Exception {
		// Given
		Long artistId = 1L;

		// When/Then
		mockMvc.perform(delete("/api/artist/{id}", artistId)).andExpect(status().isOk());

		verify(artistService, times(1)).deleteArtist(artistId);
	}

	@Test
	void testUpdateArtist() throws Exception {
		// Given
		Artist artistToUpdate = new Artist();
		artistToUpdate.setId(1L);
		artistToUpdate.setArtistName("newName");

		Artist updatedArtist = new Artist();
		updatedArtist.setId(1L);
		updatedArtist.setArtistName("newName");

		when(artistService.updateArtist(eq(1L), any(Artist.class))).thenReturn(updatedArtist);

		// When
		mockMvc.perform(
				put("/api/artist").contentType(MediaType.APPLICATION_JSON).content(asJsonString(artistToUpdate)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.artistName", is("newName")));

		// Then
		verify(artistService, times(1)).updateArtist(eq(1L), any(Artist.class));
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
