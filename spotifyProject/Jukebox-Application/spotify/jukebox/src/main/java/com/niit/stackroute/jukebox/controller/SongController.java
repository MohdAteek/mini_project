package com.niit.stackroute.jukebox.controller;

import com.niit.stackroute.jukebox.model.Songs;
import com.niit.stackroute.jukebox.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowedHeaders="", origins = "")
@RestController
@RequestMapping("/jukebox/j1")
public class SongController {

    private SongService songService;

    @Autowired
    SongController(SongService songService){
        this.songService=songService;
    }


//    http://localhost:9002/jukebox/j1/song
    @RequestMapping("/song")
    public ResponseEntity<?> getAllSongs(){
        return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
    }

    @PostMapping("/song")
    public ResponseEntity<?> addSongs(@RequestBody Songs song){
        return new ResponseEntity<>(songService.addSong(song),HttpStatus.OK);
    }

    @PostMapping("/song/{songId}")
    public ResponseEntity<?> updateSong(@RequestBody Songs song , @PathVariable int songId){

        song.setSongId(songId);
        return new ResponseEntity<>(songService.updateSongBysongId(song),HttpStatus.OK);
    }

    @DeleteMapping("/song/{songId}")
    public ResponseEntity<?> deleteSong(@PathVariable int songId){
//        songService.deleteSongBysongId(songId);
        return new ResponseEntity<>(songService.deleteSongBysongId(songId),HttpStatus.OK);
    }


}
