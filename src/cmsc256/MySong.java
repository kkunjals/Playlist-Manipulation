/*****************************************************************************************************************
 * Kunjal Sangroula
 * CMSC 256
 * Project 3
 * ***************************************************************************************************************
 * This Project creates objects MySong that stores the name of a song, the artist, album, release date, and lyrics
 * The MySong objects are populated into a SongList that implements methods that enable manipulation of the list
 * SongList implements an inner class Iterator that can be used to iterate through the list
 *****************************************************************************************************************/
package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.Song;

/**
 * MySong class constructs MySong objects and gets/sets private instance variables
 * Class extends Bridges song class and implements Comparable<>
 */
public class MySong extends bridges.data_src_dependent.Song implements Comparable<MySong>{


    /**
     * Private string variable artist stores the name of the song artist
     */
    private String artist;
    /**
     * Private string variable song stores the song name
     */
    private String song;
    /**
     * Private string variable album stores the name of the album the song is in
     */
    private String album;
    /**
     * Private string variable lyrics stores the lyrics of the song
     */
    private String lyrics;
    /**
     * Private string variable release_date store
     */
    private String release_date;


    /**
     * Public constructor, constructs a MySong object setting all private variables to null
     */
    public MySong(){
        artist = null; song = null; album = null;
        lyrics = null; release_date = null ;
    }

    /**
     * Public constructor that constructs a MySong object
     * @param artist
     * @param song
     * @param album
     * @param lyrics
     * @param release_date
     */
    public MySong(String artist, String song, String album, String lyrics, String release_date){
        this.artist = artist; this.song = song;
        this.album = album; this.lyrics = lyrics; this.release_date = release_date;
    }

    /**
     * Public constructor that constructs a MySong object
     * @param s of type Song
     * Methods from the song class are used to retrieve String variables
     */
    public MySong(Song s){
        this.artist = s.getArtist(); this.song = s.getSongTitle(); this.album = s.getAlbumTitle();
        this.lyrics = s.getLyrics(); this.release_date = s.getReleaseDate();
    }


    /**
     * Compares the songs of two objects
     * @param o a MySong object
     * @return an integer that correlates to whether or not one object's song is greater than the other
     */
    public int compareTo(MySong o) {
        int result = this.song.compareTo(o.song);
        return result;
    }

    /**
     * Gets value of artist
     * @return String artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the value of artist to what is passed in
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets value of song
     * @return String song
     */
    public String getSong() {
        return song;
    }

    /**
     * Sets the value of song to what is passed in
     * @param song
     */
    public void setSong(String song) {
        this.song = song;
    }

    /**
     * Gets vale of album name
     * @return String album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Sets the value of album to what is passed in
     * @param album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Gets vale of the song lyrics
     * @return String lyrics
     */
    public String getLyrics() {
        return lyrics;
    }

    /**
     * Sets the value of lyrics to what is passed in
     * @param lyrics
     */
    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * Gets vale of release_date
     * @return String release_date
     */
    public String getRelease_date() {
        return release_date;
    }

    /**
     * Sets the value of release_date to what is passed in
     * @param release_date
     */
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

}


