package org.example.QueueExamples;

import java.util.Comparator;

// this is a totally separate class that handles the comparison for movies
public class RatingCompare implements Comparator<Movie> {

    // we take in 2 objects as parameters because we have no "this"
    @Override
    public int compare(Movie movie1, Movie movie2) {
        // just return the comparison between the movies' ratings
        if(movie1.getRating() > movie2.getRating()) return 1;
        else if(movie1.getRating() < movie2.getRating()) return -1;
        else return 0;
    }
}
