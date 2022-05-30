package com.niit.stackroute.jukebox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Song Already Exist")
public class SongAlreadyFoundException {
}
