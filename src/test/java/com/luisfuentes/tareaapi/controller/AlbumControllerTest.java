package com.luisfuentes.tareaapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisfuentes.tareaapi.model.Album;
import com.luisfuentes.tareaapi.Service.AlbumService;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlbumController.class)
class AlbumControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AlbumService albumService;

	@InjectMocks
	private AlbumController albumController;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testGetAllAlbum() throws Exception {
		// Given
		List<Album> album = new ArrayList<>();
		when(albumService.getAllAlbum()).thenReturn(album);

		// When/Then
		mockMvc.perform(get("/api/album")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
	}

	@Test
	void testSearchAlbumById() throws Exception {
		// Given
		Long albumId = 1L;
		Album album = new Album();
		album.setId(albumId);
		when(albumService.getAlbumById(albumId)).thenReturn(album);

		// When/Then
		mockMvc.perform(get("/api/album/{id}", albumId)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(albumId));
	}

	@Test
	void testDeleteAlbumById() throws Exception {
		// Given
		Long albumId = 1L;

		// When/Then
		mockMvc.perform(delete("/api/album/{id}", albumId)).andExpect(status().isOk());

		
		verify(albumService, times(1)).deleteAlbum(albumId);
	}

	@Test
	void testCreateAlbum() throws Exception {
	    // Given
	    Album album = new Album();
	    when(albumService.createAlbum(any(Album.class)))
	        .thenAnswer(invocation -> {
	            Album createdAlbum = invocation.getArgument(0);
	            createdAlbum.setId(1L);
	            return createdAlbum;
	        });

	    // When/Then
	    mockMvc.perform(post("/api/album")
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(album)))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.id").exists())
	            .andDo(result -> System.out.println(result.getResponse().getContentAsString()));
	}

	@Test
	void testUpdateAlbum() throws Exception {
		// Given
		Album albumToUpdate = new Album();
		albumToUpdate.setId(1L);
		albumToUpdate.setAlbumDuration(15);

		Album albumUpdate = new Album();
		albumUpdate.setId(1L);
		albumUpdate.setAlbumDuration(15);

		when(albumService.updateAlbum(eq(1L), any(Album.class))).thenReturn(albumUpdate);

		// When
		mockMvc.perform(
				put("/api/album").contentType(MediaType.APPLICATION_JSON).content(asJsonString(albumToUpdate)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.albumDuration", is(15)));

		// Then
		verify(albumService, times(1)).updateAlbum(eq(1L), any(Album.class));
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
