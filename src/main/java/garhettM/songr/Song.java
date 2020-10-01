package garhettM.songr;

import javax.persistence.*;

@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    public Album album;

    public String songTitle;
    public int trackNumber;
    public int songLength;

    public Song(){};

    public Song(String songTitle, int trackNumber, int songLength, Album album) {
        this.songTitle = songTitle;
        this.trackNumber = trackNumber;
        this.songLength = songLength;
        this.album = album;
    }
}
