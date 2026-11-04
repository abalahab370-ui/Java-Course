import java.util.ArrayList;

// Base Movie Class
class Movie {
    protected int id;
    protected String title;
    protected int durationMin;

    public Movie(int id, String title, int durationMin) {
        this.id = id;
        this.title = title;
        this.durationMin = durationMin;
    }

    public int getId() {
        return id;
    }

    public int getDurationMin() {
        return durationMin;
    }

    public String info() {
        return "Movie [ID: " + id + ", Title: " + title + ", Duration: " + durationMin + " min]";
    }
}

// RegularMovie Subclass
class RegularMovie extends Movie {
    private String ageRating;

    public RegularMovie(int id, String title, int durationMin, String ageRating) {
        super(id, title, durationMin); // Initialize parent fields via super()[cite: 159]
        this.ageRating = ageRating;
    }

    @Override
    public String info() {
        return "RegularMovie {" + super.info() + ", Age Rating: " + ageRating + "}";
    }
}

// ThreeDMovie Subclass
class ThreeDMovie extends Movie {
    private boolean glassesRequired;

    public ThreeDMovie(int id, String title, int durationMin, boolean glassesRequired) {
        super(id, title, durationMin); // Initialize parent fields via super()[cite: 159]
        this.glassesRequired = glassesRequired;
    }

    @Override
    public String info() {
        return "ThreeDMovie {" + super.info() + ", Glasses Required: " + glassesRequired + "}";
    }
}

// Screen Class
class Screen {
    private int screenNumber;
    private int capacity;

    public Screen(int screenNumber, int capacity) {
        this.screenNumber = screenNumber;
        this.capacity = capacity;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public String info() {
        return "Screen [Number: " + screenNumber + ", Capacity: " + capacity + " seats]";
    }
}

// Cinema Class managing ArrayList associations
class Cinema {
    private String name;
    private ArrayList<Movie> movies;
    private ArrayList<Screen> screens;

    public Cinema(String name) {
        this.name = name;
        this.movies = new ArrayList<>();
        this.screens = new ArrayList<>();
    }

    public boolean addMovie(Movie m) {
        if (m != null) {
            movies.add(m);
            return true;
        }
        return false;
    }

    public boolean removeMovieById(int id) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                movies.remove(i);
                return true;
            }
        }
        return false;
    }

    public int totalDurationMin() {
        int total = 0;
        for (Movie m : movies) {
            total += m.getDurationMin();
        }
        return total;
    }

    public void printMovies() {
        System.out.println("=== Movies Catalog for " + name + " ===");
        for (Movie m : movies) {
            System.out.println(m.info());
        }
    }

    public boolean addScreen(Screen s) {
        if (s != null) {
            screens.add(s);
            return true;
        }
        return false;
    }

    public void printScreens() {
        System.out.println("=== Screens for " + name + " ===");
        for (Screen s : screens) {
            System.out.println(s.info());
        }
    }
}

// Main Test Class
public class Main {
    public static void main(String[] args) {
        // 1. Create a Cinema instance[cite: 159]
        Cinema cnxCinema = new Cinema("ESI-SBA Cineplex");

        // 2. Add Screens
        cnxCinema.addScreen(new Screen(1, 150));
        cnxCinema.addScreen(new Screen(2, 200));
        cnxCinema.printScreens();

        System.out.println();

        // 3. Add Movies (Demonstrating polymorphism with RegularMovie and ThreeDMovie)
        Movie m1 = new RegularMovie(101, "The Java Journey", 120, "PG-13");
        Movie m2 = new ThreeDMovie(102, "Object Oriented Universe", 145, true);
        
        cnxCinema.addMovie(m1);
        cnxCinema.addMovie(m2);
        cnxCinema.printMovies();

        // 4. Compute total duration of all movies[cite: 159]
        System.out.println("\nTotal runtime duration of all movies: " + cnxCinema.totalDurationMin() + " mins");

        // 5. Test removing a movie by ID[cite: 159]
        System.out.println("\nRemoving movie with ID 101...");
        cnxCinema.removeMovieById(101);
        cnxCinema.printMovies();
        System.out.println("New total duration: " + cnxCinema.totalDurationMin() + " mins");
    }
}
