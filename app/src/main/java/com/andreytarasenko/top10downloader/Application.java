package com.andreytarasenko.top10downloader;

public class Application {
    String name;
    String artist;
    String releaseDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Artist: " + artist + "\n" +
                "Release Date: " + releaseDate + "\n";
    }
}
