package com.main;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

	private String artist;
	private String name;
	private ArrayList<Song> songs;
	
	public Album(String artist, String name) {
		this.artist = artist;
		this.name = name;
		this.songs = new ArrayList<Song>();
	}
	public Album() {
		
	}
	
	public Song findSong(String title) {
		for(Song checkedSong:songs) {
			if(checkedSong.getTitle().equals(title)) {
				return checkedSong;
			}
		}
		return null;
	}
	public boolean addSong(String title, double duration) {
		if(findSong(title) == null) {
			songs.add(new Song(title, duration));
			//System.out.print(title + " successfully added to the album!");
			return true;
		}
		else {
			//System.out.print(title + " already present in the album!");
			return false;
		}
	}
	public boolean addToPlaylist(int trackNumber, LinkedList<Song> PlayList) {
		int index = trackNumber - 1;
		
		if(index > 0 && index <= this.songs.size()) {
			PlayList.add(this.songs.get(index));
			//System.out.println("Song with tracknumber "+ trackNumber +" added to the playlist!");
			return true;
		}
		
		//System.out.print("\n This album does not have this song with tracknumber "+ trackNumber);
		return false;
	}
//	overloading with same method, but with song title instead of tracknumber
	public boolean addToPlaylist(String title, LinkedList<Song> PlayList) {
		for(Song current: this.songs) {
			if(current.getTitle().equals(title)) {
				PlayList.add(current);
				//System.out.println("Song with title "+ title +" added to the playlist!");
				return true;
			}
		}
		//System.out.print("\n This album does not have this song with title "+ title);
		return false;
	}
	
}
