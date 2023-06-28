package com.michaeld.lookify.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michaeld.lookify.models.Song;
import com.michaeld.lookify.repositories.SongRepository;

@Service
public class SongService {

	@Autowired
	private SongRepository songRepo;
	
	public Song create(Song s) {
		return songRepo.save(s);
	}
	
	public List<Song> getAll() {
		return songRepo.findAll();
	}
	
	public Song getById(Long id) {
		return songRepo.findById(id).orElse(null);
	}
	
	public List<Song> getByArtist(String search) {
		return songRepo.findByArtist(search);
	}
	
	public List<Song> getByArtistContaining(String search) {
		return songRepo.findByArtistContaining(search);
	}
	
	public List<Song> getTopTen() {
		return songRepo.findTop10SongsByRating();
	}
	
	public Song update(Song s) {
		return songRepo.save(s);
	}
	
	public void delete(Long id) {
		songRepo.deleteById(id);
	}
}
