package com.oscar.pictures.service;

import java.util.List;

import com.oscar.pictures.entity.Movie;

public interface MovieService {
	
	public Movie addMovie(Movie prod);
	public Movie updateMovie(Movie prod,int Id);
	public void deleteMovie(Movie prod);
	public Movie getMovieById(String id);
	public List<Movie> getAllMovies();

}
