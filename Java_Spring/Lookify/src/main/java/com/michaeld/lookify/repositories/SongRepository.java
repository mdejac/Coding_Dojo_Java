package com.michaeld.lookify.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michaeld.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	List<Song> findAll();
	List<Song> findByArtist(String search);
	List<Song> findByArtistContaining(String search);
//	@Query(value="SELECT * FROM songs s ORDER BY s.rating DESC LIMIT 10", nativeQuery=true)
	@Query("SELECT s FROM Song s ORDER BY s.rating DESC LIMIT 10")
	List<Song> findTop10SongsByRating();
}
