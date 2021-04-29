/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.Rating;
import model.Video;

/**
 *
 * @author adamg
 */
public abstract class ContentFilter {

    private static byte avgRating(Rating ratings) {
        byte result = 0;

        short sumRatings = (short) (ratings.getCsfd() + ratings.getImdb() + ratings.getOurs());
        short avgRate = 0;

        avgRate = (short) (sumRatings / 3);

        result = (byte) avgRate;

        return result;
    }

    public static ArrayList<Video> pickContent(ArrayList<Video> videos, String genre, int numberOfItems) {
        ArrayList<Video> picks = new ArrayList<>();

        for (int i = 0; i < videos.size(); i++) {
            Video video = videos.get(i);

            if (video.getGenre().equals(genre)) {
                picks.add(video);
            }

            if (picks.size() == numberOfItems) {
                break;
            }
        }

        return picks;
    }
    
    public static ArrayList<Video> pickContent(ArrayList<Video> videos, byte rating, int numberOfItems) {
        ArrayList<Video> picks = new ArrayList<>();

        for (int i = 0; i < videos.size(); i++) {
            Video video = videos.get(i);

            if (avgRating(video.getRatings()) >= rating) {
                picks.add(video);
            }

            if (picks.size() == numberOfItems) {
                break;
            }
        }

        return picks;
    }
    
    public static ArrayList<Video> pickContent(ArrayList<Video> videos, int year, int numberOfItems) {
        ArrayList<Video> picks = new ArrayList<>();

        for (int i = 0; i < videos.size(); i++) {
            Video video = videos.get(i);

            if (video.getYear() == year) {
                picks.add(video);
            }

            if (picks.size() == numberOfItems) {
                break;
            }
        }

        return picks;
    }
    
    public static ArrayList<Video> pickContent(ArrayList<Video> videos, boolean findMovie, int numberOfItems) {
        ArrayList<Video> picks = new ArrayList<>();

        for (int i = 0; i < videos.size(); i++) {
            Video video = videos.get(i);

            if (findMovie && (video.getClass().getSimpleName().equals("Movie"))) {
                picks.add(video);
            }
            else if (!findMovie && (video.getClass().getSimpleName().equals("TVShow"))){
                picks.add(video);
            }
            
            if (picks.size() == numberOfItems) {
                break;
            }
        }

        return picks;
    }

    public static ArrayList<Video> sortByPopularity(ArrayList<Video> videos, int amount) {
        videos.sort(Comparator.comparingInt(Video::getNumberOfReviews));
        for (Video video : videos) {
            video.setRelevantSortInfo("Number of our reviews: " + video.getNumberOfReviews());
        }
        return new ArrayList<>(videos.subList(0, amount));
    }

    public static ArrayList<Video> sortByRatings(ArrayList<Video> videos, int amount) {
        videos.sort(Collections.reverseOrder(Comparator.comparingInt(Video::getAvgRating)));

        for (Video video : videos) {
            video.setRelevantSortInfo("Rating: " + (float) video.getAvgRating() / 10);
        }

        return new ArrayList<>(videos.subList(0, amount));
    }

    public static ArrayList<Video> sortByYear(ArrayList<Video> videos, int amount) {
        videos.sort(Collections.reverseOrder(Comparator.comparingInt(Video::getYear)));

        for (Video video : videos) {
            video.setRelevantSortInfo("Year: " + video.getYear());
        }

        return new ArrayList<>(videos.subList(0, amount));
    }
}
