package com.michaeld.lookify.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.michaeld.lookify.models.Song;
import com.michaeld.lookify.services.SongService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongService songService;

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> allSongs = songService.getAll();
		model.addAttribute("allSongs", allSongs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/create")
	public String addSong(@ModelAttribute("song") Song song) {
		return "createSong.jsp";
	}
	
	@PostMapping("/create")
	public String addSongSubmit(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if (result.hasErrors()) {
			return "createSong.jsp";
		}
		songService.create(song);
		return "redirect:/songs/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songService.getById(id));
		return "showSong.jsp";
	}
	
	@GetMapping("edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model) {
		Song song = songService.getById(id);
		model.addAttribute("song", song);
		model.addAttribute("songTitle", song.getTitle());
		return "editSong.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editSubmit(@Valid @ModelAttribute("song") Song song,
							BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("song", song);
			model.addAttribute("songTitle", songService.getById(song.getId()).getTitle());
			return "editSong.jsp";
		}
		songService.update(song);
		return "redirect:/songs/dashboard";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		songService.delete(id);
		return "redirect:/songs/dashboard";
	}
	
	@RequestMapping("/search")
	public String searchSubmit(@RequestParam("search") String search, Model model) {
		List<Song> allSongs = songService.getByArtist(search);
		model.addAttribute("isFound", true);
		if (allSongs.isEmpty()) {
			allSongs = songService.getByArtistContaining(search);
			model.addAttribute("isFound", false);
		}
		model.addAttribute("allSongs", allSongs);
		model.addAttribute("artistName", search);
		return "searchResults.jsp";
	}
	
	@GetMapping("/topten")
	public String topTen(Model model) {
		model.addAttribute("allSongs", songService.getTopTen());
		return "topTenSongs.jsp";
	}
}
