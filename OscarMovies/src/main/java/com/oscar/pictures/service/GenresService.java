package com.oscar.pictures.service;

import java.util.List;

import com.oscar.pictures.entity.GenRes;


public interface GenresService {
	public GenRes addGenres(GenRes prod);
	public GenRes updateGenres(GenRes prod,int Id);
	public void deleteGenres(GenRes prod);
	public GenRes getGenresById(String id);
	public List<GenRes> getAllGenres();

}
