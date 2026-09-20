package DesignPatterns.BehaviourDesignPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IteratorDesignPattern {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2 Fav");
        playlist.addSong("Song 3");
        playlist.addSong("Song 4 Fav");
        playlist.addSong("Song 5");

        PlayListIterator simpleIterator = playlist.iterator("simple");
        while (simpleIterator.hasNext()) {
            System.out.println("Playing: " + simpleIterator.next());
        }

        PlayListIterator shuffledIterator = playlist.iterator("shuffled");
        while (shuffledIterator.hasNext()) {
            System.out.println("Playing: " + shuffledIterator.next());
        }

    }

}

class Playlist {

    List<String> songs;

    Playlist() {
        songs = new ArrayList<>();

    }

    void addSong(String SongName) {
        songs.add(SongName);
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    // void iterateOverPlayList(boolean isShuffle) {

    // if (isShuffle) {
    // // shuffing playList
    // // Iterating over Shuffled Playlist

    // } else {
    // for (int i = 0; i < songs.size(); i++) {
    // System.out.println("playing song " + songs.get(i));
    // }
    // }

    // }

    public PlayListIterator iterator(String type) {

        if (type.equals("Simple")) {
            return new SimplePlayListIterator(this);
        } else if (type.equals("Shuffled")) {
            return new ShuffledPlayListIterator(this);
        }
        return null;

    }

}

class SimplePlayListIterator implements PlayListIterator {
    int index;
    Playlist playlist;

    SimplePlayListIterator(Playlist playlist) {
        index = 0;
        this.playlist = playlist;

    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSongs().size();
    }

    @Override
    public String next() {
        return playlist.getSongs().get(index++);
    }
}

class ShuffledPlayListIterator implements PlayListIterator {
    int index;
    Playlist playlist;
    List<String> shuffledSongs;

    ShuffledPlayListIterator(Playlist playlist) {
        index = 0;
        this.playlist = playlist;
        shuffledSongs = playlist.getSongs();
        Collections.shuffle(shuffledSongs);
    }

    @Override
    public boolean hasNext() {
        return index < shuffledSongs.size();
    }

    @Override
    public String next() {
        return shuffledSongs.get(index++);
    }
}

/**
 * PlayListIterator
 */
interface PlayListIterator {
    boolean hasNext();

    String next();

}
