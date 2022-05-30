package com.niit.stackroute.jukebox.repository;

import com.niit.stackroute.jukebox.model.Songs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<Songs,Integer>
{
}
