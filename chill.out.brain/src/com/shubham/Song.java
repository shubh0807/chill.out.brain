package com.shubham;

public class Song {
    private String SongName;
    private double SongDuration;

    public Song(String name,double time)
    {
        this.SongName = name;
        this.SongDuration = time;
    }
    public String getName()
    {
        return this.SongName;
    }
    @Override
    public String toString()
    {
        return this.SongName + " : " + this.SongDuration;
    }
}
