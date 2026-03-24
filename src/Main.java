import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File data = new File("src/movies_data.csv");
        Scanner scan = null;
        try {
            scan = new Scanner(data);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<Movie> movies = new ArrayList<>();
        while (scan.hasNext()) {
            String line = scan.nextLine();
            String[] split = line.split(",");
            String title = split[0];
            String cast = split[1];
            String director = split[2];
            String overview = split[3];
            int runtime = Integer.parseInt(split[4]);
            double userRating = Double.parseDouble(split[5]);
            Movie movie = new Movie(title, cast, director, overview, runtime, userRating);
            movies.add(movie);
        }

        System.out.println("Number of movies: " + movies.size());
        System.out.println();
        System.out.println(movies.get(2));
        System.out.println();
        System.out.println(movies.get(4998));
        System.out.println();

        double aveRun = 0;
        for (int i = 0; i < movies.size(); i++) {
            aveRun += movies.get(i).getRuntime();
        }
        aveRun /= movies.size();

        double aveRate = 0;
        for (int i = 0; i < movies.size(); i++) {
            aveRate += movies.get(i).getUserRating();
        }
        aveRate /= movies.size();

        System.out.println(aveRun);
        System.out.println(aveRate);
    }
}