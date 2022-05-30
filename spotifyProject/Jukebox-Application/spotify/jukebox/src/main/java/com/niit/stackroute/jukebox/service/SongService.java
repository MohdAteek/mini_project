package com.niit.stackroute.jukebox.service;

import com.niit.stackroute.jukebox.model.Songs;

import java.util.List;

public interface SongService {

    public List<Songs> getAllSongs();
    public Songs addSong(Songs song);
    public Songs updateSongBysongId(Songs song);
    public boolean deleteSongBysongId(int songId);
}