import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    } //constructor

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }
    //factory method calling inner class method and creating new Song object with passed parameters and returns boolean if added/not

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }

        System.out.println("This album does not have a track " + trackNumber);
        return false;
    } //querries 'songs' innerClass through inner
    // class method passing track number parameter and returns a Song object

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(title);
        if(checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    } // as above but uses different querrying method
    // of the 'songs' innerClass



    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        } //initialize ArrayList field

        public boolean add(Song song) {
            if(songs.contains(song)) {
                return false;
            }
            this.songs.add(song);
            return true;
        } //adds Song to ArrayList field if not found

        private Song findSong(String title) {
            for(Song checkedSong: this.songs) {
                if(checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;
        } // returns song title if found

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index >= 0) && (index<songs.size())) {
                return songs.get(index);
            }
            return null;
        }  //returns Song object at trackNumber if trackNumber exists
    }  // inner class with field of ArrayList with methods to querry and add to ArrayList of songs
}
