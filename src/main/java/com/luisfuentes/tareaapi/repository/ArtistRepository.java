package com.luisfuentes.tareaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luisfuentes.tareaapi.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
