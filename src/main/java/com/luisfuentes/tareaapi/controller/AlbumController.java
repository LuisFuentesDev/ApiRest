package com.luisfuentes.tareaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luisfuentes.tareaapi.Service.AlbumService;
import com.luisfuentes.tareaapi.model.Album;

@RestController
@RequestMapping("api/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	

	/*
	 * @PostMapping("/{id}") public Album createAlbum(@RequestBody Album
	 * album, @PathVariable Long id) { Artist a = artistService.getArtistById(id);
	 * album.setArtist(a); return albumService.createAlbum(album); }
	 */

	@GetMapping
	public List<Album> getAllAlbum() {
		return albumService.getAllAlbum();
	}

	@GetMapping("{id}")
	public Album searchAlbumById(@PathVariable("id") Long id) {
		return albumService.getAlbumById(id);
	}

	@DeleteMapping("{id}")
	public void deleteAlbumById(@PathVariable("id") Long id) {
		albumService.deleteAlbum(id);
	}

	@PostMapping
	public Album createAlbum(@RequestBody Album album) {
		return albumService.createAlbum(album);
	}
	@PutMapping
	public Album updateAlbum(@RequestBody Album album) {
		return albumService.createAlbum(album);
	}
}
