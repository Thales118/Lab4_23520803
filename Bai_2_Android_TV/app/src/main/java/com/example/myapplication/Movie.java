package com.example.myapplication;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

public class Movie implements Serializable {
    static final long serialVersionUID = 7275661750759686531L;
    private long id;
    private String title;
    private String studio;
    private String description;
    private String cardImageUrl;
    private String videoUrl;

    public Movie() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getStudio() { return studio; }
    public void setStudio(String studio) { this.studio = studio; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCardImageUrl() { return cardImageUrl; }
    public void setCardImageUrl(String cardImageUrl) { this.cardImageUrl = cardImageUrl; }

    public String getBackgroundImageUrl() { return cardImageUrl; }
    public void setBackgroundImageUrl(String bgUrl) { this.cardImageUrl = bgUrl; }
    public String getVideoUrl() { return videoUrl; }
    public void setVideoUrl(String videoUrl) { this.videoUrl = videoUrl; }

    public URI getCardImageURI() {
        try { return new URI(getCardImageUrl()); }
        catch (URISyntaxException e) { return null; }
    }
}