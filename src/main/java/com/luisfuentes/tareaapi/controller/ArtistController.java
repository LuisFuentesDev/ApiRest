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

import com.luisfuentes.tareaapi.Service.ArtistService;
import com.luisfuentes.tareaapi.model.Artist;

@RestController
@RequestMapping("api/artists")
public class ArtistController {

	@Autowired
	private ArtistService artistService;

	@PostMapping
	public Artist createArtist(@RequestBody Artist artist) {
		/*
		 * List<Album> albums = new ArrayList<>(); if(artist.getAlbums().size()>0) {
		 * for(Album a:artist.getAlbums()) { albums.add(a); } }
		 * artist.setAlbums(albums);
		 */
		return artistService.createArtist(artist);
	}

	@GetMapping
	public List<Artist> getAllArtist() {
		return artistService.getAllArtist();
	}

	@GetMapping("{id}")
	public Artist searchArtistById(@PathVariable("id") Long id) {
		return artistService.getArtistById(id);
	}

	@DeleteMapping("{id}")
	public void deleteArtistById(@PathVariable("id") Long id) {
		artistService.deleteArtist(id);
	}

	@PutMapping
	public Artist updateArtist(@RequestBody Artist artist) {
		return artistService.createArtist(artist);
	}
}
