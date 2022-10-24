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

import bridges.base.SLelement;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;
import bridges.data_src_dependent.Song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * SongList class constructs SongList objects and implements the list interface and Iterable
 * This class utilizes the Bridges class SLelement<> for linked list storage
 */
public class SongList implements cmsc256.List<MySong>, Iterable<MySong>{

    /**
     * Private SLelement variable that will store a MySong object
     */
    private SLelement<MySong> head;
    /**
     * Private int variable that stores the size of the list
     */
    private int size;
    /**
     * Private String variable that stores the name of a playlist
     */
    private String playlist;



    /**
     * Parameterless constructor for SongList that will initialize variables to default values
     */
    public SongList(){
        head = null;
        size = 0;
        playlist = "";
    }

    /**
     * SongList constructor that sets playlist to parameter and head to null
     * @param playlist
     */
    public SongList(String playlist){
        this.playlist = playlist;
        head = null;
    }

    /**
     * SongList constructor that sets playlist to parameter and head to the MySong object
     * @param playlist
     * @param song
     */
    public SongList(String playlist, MySong song){
        this.playlist = playlist;
        head = new SLelement<MySong>(song);
    }



    /**
     * Gets the value of head
     * @return head
     */
    public SLelement<MySong> getHead() {
        return head;
    }

    /**
     * Sets the value of head to the parameter
     * @param head
     */
    public void setHead(SLelement<MySong> head) {
        this.head = head;
    }

    /**
     * Gets the value of size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of size to the parameter
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Gets the playlist name
     * @return playlist
     */
    public String getPlaylistName() {
        return playlist;
    }

    /**
     * Sets the value of playlist to the parameter
     * @param playlist
     */
    public void setPlaylistName(String playlist) {
        this.playlist = playlist;
    }



    /**
     * 	Remove all contents from the list, so it is once again empty
     */
    public void clear(){
        head = null;
        size = 0;
    }


    /**
     * 	Inserts element at the given position
     * @param 	it
     * @param 	position
     * @return	true if successful
     * @throws IllegalArgumentException if position is < 0 or > number of elements in the list
     */
    public boolean insert(MySong it, int position){
        //check for illegal argument
        if(position < 0 || position >= size){
            throw new IllegalArgumentException();
        }
        if(position == 0){

        }
        return false;
    }


    /**
     * 	Appends element to the end of the list
     * @param 	it
     * @return	true if successful
     */
    public boolean add(MySong it){
        //create SLelement that will store MySong object that is passed in
        SLelement<MySong> newIt = new SLelement<MySong>(it);
        //Set current to the head of the list
        SLelement<MySong> current = head;

        //check if the head of the list is null
        if(current == null) {
            //set the head equal to the new SLelement object
            head = newIt;
            size++;
            return true;
        }

        //check for instances where the head isn't null and iterate
        while(current.getNext() != null){
            current = current.getNext();
        }
        //when there is a position that points to null, set the next value to newIt object
        current.setNext(newIt);

        //Check if the next value is newIt and return T/F accordingly. Manipulate size variable.
        if(current.getNext() == newIt){
            size++;
            return true;
        }
        else{
            return false;
        }
    }


    /**
     * @param 	position
     * @return	Remove and return the element at position
     * @throws IllegalArgumentException if position is < 0 or > number of elements in the list
     */
    public MySong remove(int position){
        //create SLelement current that will store the head of the list
        SLelement<MySong> current = head;
        //create a counter that will keep track of where we are in list
        int counter = 0;
        MySong object;

        //check for illegal argument
        if(position < 0 || position >= size){
            throw new IllegalArgumentException();
        }

        //check for if the position is at the head
        if(position == 0 && current.getValue() != null){
            object = head.getValue();
            head = head.getNext();
            //increment size
            size--;
            return object;
        }

        //while loop that will let us traverse through the list
        while(current.getNext() != null){
            //increment counter if there is a next value
            //once the counter is equal to the position we want
            if(counter == position){
                object = current.getValue();
                //set current to the next, next value
                current = current.getNext().getNext();
                //increment size
                size--;
                return object;

            }
            counter++;
            current = current.getNext();
        }
        return current.getValue();
    }


    /**
     * @return	the number of elements in this list
     */
    public int size(){
        return size;
    }


    /**
     * @return	true if this list has no elements
     */
    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }


    /**
     * @param 	target
     * @return 	true if the target element is in this list
     * 			false otherwise
     */
    public boolean contains(MySong target){
        SLelement<MySong> current = head;


        while(current != null){
            if(current.getValue() == target){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    /**
     * @return	the element at the given position
     * @throws IllegalArgumentException if position is < 0 or > number of elements in the list
     */
    public MySong getValue(int position){
        int counter = 0;
        SLelement<MySong> current = head;
        MySong value = null;

        if(position < 0 && position >= size){
            throw new IllegalArgumentException();
        }

        if(position == 0 && current.getValue() != null){
            return current.getValue();
        }

        while(current != null){
            if(counter == position){
                value = current.getValue();
            }
            counter++;
            current = current.getNext();
        }
        return value;
    }

    /**
     * @param artist
     * @return A formatted String with a list of each song on a separate line
     *         with the song title and album labeled for the artist passed in
     */
    public String getSongsByArtist(String artist){
        //create SLelement current that will store head
        SLelement<MySong> current = head;
        //Initialize the string we will return
        String answer = "";
        String albumName = null;
        ArrayList<MySong> storage = new ArrayList<>();
        while(current != null){
            if(current.getValue().getArtist().equals(artist)){
                storage.add(current.getValue());
            }
            current = current.getNext();
        }

        if(storage.size() == 0){
            return "There are no songs by " + artist +  " in this playlist.";
        }

        Collections.sort(storage);

        for(int i = 0; i < storage.size(); i++){
            answer += "Title: " + storage.get(i).getSong() + " Album: " + storage.get(i).getAlbum() + "\n";
        }
        return answer;
    }

    /**
     * Iterator method of type MySong that returns an iterator object
     * @return Iterator<MySong>
     */
    public Iterator<MySong> iterator() {

        return new SongIterator();
    }

    /**
     * Inner Songiterator class that will implement Iterator methods
     */
    public class SongIterator implements Iterator<MySong>{

        /**
         * Integer index value that is initialized to 0
         * Will help keep track of location
         */
        int index = 0;

        /**
         * SLelement of type mysong that is set equal to the head
         */
        SLelement<MySong> current = head;

        /**
         * Checks if there is a next value from the current position
         * @return boolean , true if there is a next value, false otherwise
         */
        public boolean hasNext() {
            return index < size;
        }

        /**
         * Gets the next value from the current position
         * @return MySong object
         */
        public MySong next() {
            MySong object;
            object = current.getValue();
            current = current.getNext();
            return object;
        }

    }

    /**
     * Main method that will test SongList and MySong classes
     * @param args
     */
    public static void main(String[] args){
        /*Bridges bridges = new Bridges(3, "sangroulak", "1347023844948");

        bridges.setTitle("Accessing song data");
        DataSource ds = bridges.getDataSource();
         */





        MySong example = new MySong("The Weeknd", "Die for me","Melancholy","yuh","2018");
        MySong example1 = new MySong("Stardew","Night Market","Instrumental","yur","2019");
        MySong example2 = new MySong("MJ","Thriller","I am cool","I forget","1980");
        SongList list = new SongList();

        MySong artist1 = new MySong("Piyush","I love you","Mwah", "Yuh","2021");
        MySong artist2 = new MySong("Piyush", "HoneyBunny", "Poopoo","Pp","2020");
        MySong artist3 = new MySong("Piyush","I wanna marry u","Okie","Yuh","2026");

        SongList test = new SongList();
        test.add(artist1);
        test.add(artist2);
        test.add(artist3);



        //test for add method
        list.add(example); list.add(example1); list.add(example2);
        //System.out.println(list.getValue(0));
        //test for size
        System.out.println(list.size());
        //test for remove method
        //list.remove(1);
        //test for size (decrement)
        System.out.println(list.size());
        //test for clearing the list
        list.clear();
        //print size if list is cleared
        System.out.println(list.size());

        //tests for getSongsbyArtist both pass and fail
        System.out.println(test.getSongsByArtist("Piyush"));
        System.out.println(test.getSongsByArtist("Kunjal"));

        System.out.println(artist3);
        System.out.println(test.getValue(2));

        System.out.println(test.contains(artist1));
        System.out.println();
        System.out.println("Now testing for remove");
        System.out.println(artist1);
        System.out.println("The item we removed was: " + test.remove(0));

    }

}
