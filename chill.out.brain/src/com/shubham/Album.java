package com.shubham;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String AlbumName;
    private String ArtistName;
    private ArrayList<Song> AlbumSongs;

    public Album(String name, String artist)
    {
        this.AlbumName = name;
        this.ArtistName = artist;
        this.AlbumSongs = new ArrayList<Song>();
    }
    public Song SearchSong(String title)
    {
        for(Song LookupSong: this.AlbumSongs)
        {
            if(LookupSong.getName().equals(title))
            {
                return LookupSong;
            }
        }
        return null;
    }

    public boolean addSongtoAlbum(String name, double duration)
    {
        if(SearchSong(name) == null)
        {
            this.AlbumSongs.add(new Song(name,duration));
            return true;
        }
        return false;
    }
    public boolean addSongtoPlayList(String name, LinkedList<Song> playList)
    {
        Song chekedSong = SearchSong(name);
        if(chekedSong != null)
        {
            playList.add(chekedSong);
            return true;
        }
        System.out.println("This song " + name + "is not in this album");
        return false;
    }

}
