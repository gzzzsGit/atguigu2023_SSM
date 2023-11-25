package com.gzzz.ioc_02;

/**
 * className: SimpleMovieLister
 * Package : com.gzzz.ioc_02
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/25 21:58
 * @Version 1.0
 */
public class SimpleMovieLister {
    private MovieFinder movieFinder;

    private String movieName;

    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
