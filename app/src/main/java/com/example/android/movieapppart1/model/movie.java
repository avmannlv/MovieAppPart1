package com.example.android.movieapppart1.model;

//import java.util.List;

public class movie {

    private String origTitle;
    private String image;
    private int id;
    //    private boolean isVideo;
//    private String title;
//    private long popularity;
//    private String originalLanguage;
//    private List<Integer> genreIds;
//    private String backdropPath;
//    private Boolean isAdult;
    private String synopsis;
    private int rating;
    private String releaseDate;

//    private int vote_count;

    //public movie() { }  /*** No args constructor for use in serialization */

    public movie(Integer id, String title, String releaseDate, String synopsis, String image, Integer rating) {
        this.id = id;
        this.origTitle = title;
        this.releaseDate = releaseDate;
        this.synopsis = synopsis;
        this.image = image;
        this.rating = rating;
    }

    public movie() {
        //empty constructor
    }

    public Integer getid() { return id; }
    public String gettitle() { return origTitle; }
    public String getreleaseDate() { return releaseDate; }
    public String getsynopsis() { return synopsis;}
    public String getImage() { return image; }
    public Integer getrating() { return rating; }

    public void setid() { this.id = id;  }
    public void settitle(String title) { this.origTitle = title; }
    public void setreleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public void setsynopsis(String synopsis) { this.synopsis = synopsis;}
    public void setImage(String image) { this.image = image; }
    public void setrating(Integer rating) { this.rating = rating; }
}
