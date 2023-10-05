package com.luisfuentes.tareaapi.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "artists")

@Getter
@Setter
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String artistName;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private Integer age;

	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
    @JsonManagedReference
	List<Album> albums;
}