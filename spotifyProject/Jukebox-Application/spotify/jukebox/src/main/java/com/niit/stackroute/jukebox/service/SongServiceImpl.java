package com.niit.stackroute.jukebox.service;
import com.niit.stackroute.jukebox.model.Songs;
import com.niit.stackroute.jukebox.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService
{


    private SongRepository songRepository;

    @Autowired
    SongServiceImpl(SongRepository songRepository){
        this.songRepository=songRepository;
    }

    @Override
    public List<Songs> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Songs addSong(Songs song) {
        return songRepository.save(song);
    }

    @Override
    public Songs updateSongBysongId(Songs song) {
        return songRepository.save(song);
    }

    @Override
    public boolean deleteSongBysongId(int songId) {

        songRepository.deleteById(songId);
        return true;
    }
}
