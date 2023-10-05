package com.luisfuentes.tareaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisfuentes.tareaapi.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}
