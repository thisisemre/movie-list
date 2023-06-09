import java.util.ArrayList;

public class Movie {
    private int year;
    private String name;
    private String genre;
    private String director;
    private ArrayList<Actor> actors;

    public Movie(int year,String name, String genre, String director, ArrayList<Actor> actors) {
        this.year=year;
        this.name = name;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
    }
    public Movie() {
        this.name = null;
        this.genre = null;
        this.director = null;
        this.actors = null;
    }
    public Movie(Movie m) {
        this.year=m.year;
        this.name = m.getName();
        this.genre =m.getGenre();
        this.director = m.getDirector();
        this.actors = m.getActors();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Actor> getActors() {
        return actors;
    }

    public void setActors(ArrayList<Actor> actors) {
        this.actors = actors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }
}
