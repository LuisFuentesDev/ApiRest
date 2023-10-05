package com.luisfuentes.tareaapi.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luisfuentes.tareaapi.model.Album;
import com.luisfuentes.tareaapi.repository.AlbumRepository;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	public Album createAlbum(Album album) {
		return albumRepository.save(album);
	}

	public Album getAlbumById(Long id) {
		Optional<Album> optionalAlbum = albumRepository.findById(id);
		return optionalAlbum.get();
	}

	public List<Album> getAllAlbum() {
		return albumRepository.findAll();
	}

	public void deleteAlbum(Long id) {
		albumRepository.deleteById(id);
	}
}
