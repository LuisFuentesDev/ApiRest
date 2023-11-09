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

	public Artist updateArtist(Long id, Artist updatedArtist) {
        Optional<Artist> optionalExistingArtist = artistRepository.findById(id);

        if (optionalExistingArtist.isPresent()) {
            Artist existingArtist = optionalExistingArtist.get();
            existingArtist.setArtistName(updatedArtist.getArtistName());
            existingArtist.setFirstName(updatedArtist.getFirstName());
            existingArtist.setLastName(updatedArtist.getLastName());
            existingArtist.setBirthDate(updatedArtist.getBirthDate());
            existingArtist.setAge(updatedArtist.getAge());
            

            return artistRepository.save(existingArtist);
        } else {
          
            return null;
        }
    }
}
