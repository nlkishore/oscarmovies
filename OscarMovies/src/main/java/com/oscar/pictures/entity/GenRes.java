package com.oscar.pictures.entity;


import lombok.*;
import jakarta.persistence.*;
@Getter
@Setter
@Entity
@ToString
@Table(name="genres")
public class GenRes {

	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY )
	private String gen_id;
	private String gen_title;
	private String gen_desc;
}
