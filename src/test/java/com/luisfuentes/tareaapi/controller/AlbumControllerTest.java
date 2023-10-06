package com.luisfuentes.tareaapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisfuentes.tareaapi.model.Album;
import com.luisfuentes.tareaapi.Service.AlbumService;
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

@WebMvcTest(AlbumController.class)
class AlbumControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private AlbumService albumService;

	@InjectMocks
	private AlbumController albumController;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testGetAllAlbum() throws Exception {
		// Given
		List<Album> exampleAlbums = new ArrayList<>();
		when(albumService.getAllAlbum()).thenReturn(exampleAlbums);

		// When/Then
		mockMvc.perform(get("/api/album")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
	}

	@Test
	void testSearchAlbumById() throws Exception {
		// Given
		Long albumId = 1L;
		Album exampleAlbum = new Album();
		exampleAlbum.setId(albumId);
		when(albumService.getAlbumById(albumId)).thenReturn(exampleAlbum);

		// When/Then
		mockMvc.perform(get("/api/album/{id}", albumId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(albumId));
	}

	@Test
	void testDeleteAlbumById() throws Exception {
		// Given
		Long albumIdToDelete = 1L;

		// When/Then
		mockMvc.perform(delete("/api/album/{id}", albumIdToDelete)).andExpect(status().isOk());

		
		verify(albumService, times(1)).deleteAlbum(albumIdToDelete);
	}

	@Test
	void testCreateAlbum() throws Exception {
		// Given
		Album albumToCreate = new Album();
		when(albumService.createAlbum(any(Album.class))).thenReturn(albumToCreate);

		// When/Then
		mockMvc.perform(post("/api/album").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(albumToCreate))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists());
	}

	@Test
	void testUpdateAlbum() throws Exception {
		// Given
		Album albumToUpdate = new Album();
		when(albumService.createAlbum(any(Album.class))).thenReturn(albumToUpdate);

		// When/Then
		mockMvc.perform(put("/api/album").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(albumToUpdate))).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").exists());
	}
}
