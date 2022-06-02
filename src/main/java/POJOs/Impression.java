package POJOs;

import java.time.ZonedDateTime;

public final class Impression {
    private Double rating;
    private final String time;

    public Impression(Double rating) {
        this.rating = rating;
        this.time = ZonedDateTime.now().toString();
    }

    public Impression(Double rating, String time) {
        this.rating = rating;
        this.time = time;
    }

    public String getTime() { // sort by tasting order for advanced sort
        return time;
    }

    public double getRating() {
        return rating;
    }

    public void setNewRating(double newRating) { // date of original tasting remains
        this.rating = newRating;
    }

    @Override
    public String toString() {
        return rating + " : " + time.substring(0, 10);
    }
}
