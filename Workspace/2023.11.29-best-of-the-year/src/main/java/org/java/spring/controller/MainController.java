package org.java.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.java.spring.pojo.Movie;
import org.java.spring.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

	@GetMapping
	public String getIndex(Model model) {
		
		model.addAttribute("name", "Guybrush");
		
		System.out.println("Hello, World");
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
		List<Movie> movies = getBestMovies();
//		String strMovies = "";
//		
//		for (Movie m : movies)
//			strMovies += m.getTitle() + ", ";
		
		model.addAttribute("movies", movies);
		
		return "movies";
	}
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		List<Song> songs = getBestSongs();
//		String strSongs = "";
//		
//		for (Song s : songs)
//			strSongs += s.getTitle() + ", ";
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovieById(Model model,
			@PathVariable int id) {
		
		List<Movie> movies = getBestMovies();
		Movie movie = null;
		
		for (Movie m : movies)
			if (m.getId() == id) {
				
				movie = m;				
				break;
			}
		
//		model.addAttribute("title", (movie == null) ? "No movie found" : movie.getTitle());
		model.addAttribute("movie", movie);
		
		return "movie";
	}
	@GetMapping("/songs/{id}")
	public String getSongById(Model model,
			@PathVariable int id) {
		
		List<Song> songs= getBestSongs();
		Song song = null;
		
		for (Song s : songs)
			if (s.getId() == id) {
				
				song = s;				
				break;
			}
		
//		model.addAttribute("title", (song == null) ? "No song found" : song.getTitle());
		model.addAttribute("song", song);
		
		return "song";
	}
	
	private List<Movie> getBestMovies() {
		
		int id = 1;
		Movie[] movies = {
			
			new Movie(id++, "movie 1"),
			new Movie(id++, "movie 2"),
			new Movie(id++, "movie 3"),
			new Movie(id++, "movie 4"),
			new Movie(id++, "movie 5")
		};
		
		return Arrays.asList(movies);
	}
	private List<Song> getBestSongs() {
		
		int id = 1;
		Song[] songs = {
			
			new Song(id++, "song 1"),
			new Song(id++, "song 2"),
			new Song(id++, "song 3"),
			new Song(id++, "song 4"),
			new Song(id++, "song 5")
		};
		
		return Arrays.asList(songs);
	}
}
