package com.luisfuentes.tareaapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisfuentes.tareaapi.model.Artist;
import com.luisfuentes.tareaapi.repository.ArtistRepository;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository artistRepository;

	public Artist createArtist(Artist artist) {
		return artistRepository.save(artist);
	}

	public Artist getArtistById(Long id) {
		Optional<Artist> optionalArtist = artistRepository.findById(id);
		return optionalArtist.get();
	}

	public List<Artist> getAllArtist() {
		return artistRepository.findAll();
	}

	public void deleteArtist(Long id) {
		artistRepository.deleteById(id);
	}
}
