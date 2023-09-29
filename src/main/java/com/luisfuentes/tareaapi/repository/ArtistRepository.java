package com.luisfuentes.tareaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisfuentes.tareaapi.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long>{

}
