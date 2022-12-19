package com.main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<>();
	
	public static void main(String[] args) {
		Album album = new Album("Midnights","Taylor Swift");

        album.addSong("Lavender Haze",4.5);
        album.addSong("Anti_Hero",3.5);
        album.addSong("Midnight",5.0);
        albums.add(album);

        album = new Album("Dangerous Woman","Ariana Grande");

        album.addSong("Moonlight",4.5);
        album.addSong("Be Alright",3.5);
        album.addSong("Greedy",4.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlaylist("Lavender Haze",playList_1);
        albums.get(0).addToPlaylist("Anti_Hero",playList_1);
        albums.get(1).addToPlaylist("Moonlight",playList_1);
        albums.get(1).addToPlaylist("Greedy",playList_1);

        play(playList_1);
        //printMenu();
        

	}
	public static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
	}
	
	public static void printPlayList(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		System.out.println("-----------------");
		
		for(Song current: playList) {
			System.out.println(current);
		}
		System.out.println("-----------------");
	} 
	
	public static void play(LinkedList<Song> playList) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean quit = false;
		boolean forward = true;
		
		ListIterator<Song> listIterator = playList.listIterator();
		
		if(playList.size() == 0) {
			System.out.println("Oops! Playlist is empty!");
		}
		else {
			System.out.println("Currently playing : "+ listIterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
			
			case 0:
				System.out.println("Playlist completed!");
				quit = true;
				break;
			
			case 1:
				if(listIterator.hasNext()) {
					//listIterator.next();
					System.out.println("Currently playing : "+ listIterator.next().toString());
					forward = true;
				}else {
					System.out.println("Oops! Reached the end of the playlist!");
					forward = false;
				}
				break;
				
			case 2:
				if(forward){
                    if (listIterator.hasPrevious()){
                        listIterator.previous();
                    }
                    forward = false;
                }
                if(listIterator.hasPrevious()){
                    System.out.println("Currently playing : "+ listIterator.previous().toString());
                }else {
                    System.out.println("Oops! Reached the start of the playlist!");
                    forward = false;
                }
                break;
				
			case 3:
				if(forward){
                    if(listIterator.hasPrevious()){
                        System.out.println("Currently playing : "+listIterator.previous().toString());
                        forward = false;
                    }else {
                        System.out.println("Oops! Reached the start of the playlist!");
                    }
                }else {
                    if(listIterator.hasNext()){
                        System.out.println("Currently playing : "+ listIterator.next().toString());
                        forward = true;
                    }else {
                        System.out.println("Oops! Reached the end of the playlist!");
                    }
                }
                break;
				
			case 4:
				printPlayList(playList);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size() > 0) {
					System.out.println(listIterator.next().toString()+" has been removed from the playlist!");
					listIterator.remove();
					
					if(listIterator.hasNext()) {
						System.out.println("Currently playing : "+ listIterator.next().toString());
						
					}
					else if(listIterator.hasPrevious()){
						System.out.println("Currently playing : "+ listIterator.previous().toString());
					}else {
						System.out.println("Oops! Playlist is empty!");
					}
				}
					
				
			}
				
		}

	}

}
