package com.kodilla.good.pattern.challenges;

import java.util.stream.Collectors;

public class DisplayBooksTitles {

    void displayBooksTitles () {
        MovieStore movieStore = new MovieStore();
        String translation = movieStore.getMovies().values().stream()
                .map(String::valueOf)
                //.map(List::toString)
                //.map(Object::toString)
                .collect(Collectors.joining(" ! ","<< "," >>"));
        System.out.println("\nList of titles in one string:\n" + translation);
    }
}
