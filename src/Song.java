public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }  //constructor

    public String getTitle() {
        return title;
    } //getter

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    } // toString override
}
