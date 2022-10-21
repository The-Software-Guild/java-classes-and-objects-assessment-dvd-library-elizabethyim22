package com.sal.dvdlibrary.dto;

/**
 *
 * @author Elizabeth Yim
 *
 * collection of getter and setter methods for the DvD object's attributes
 *
 **/
public class DvD {
    private String title;
    private String releaseDate;
    private String MPAA;
    private String directorName;
    private String Studio;
    private String userRating;

    //title is a read only field which means there is only a getter and no setter
    public DvD(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    public String getReleaseDate(){
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate){
        this.releaseDate=releaseDate;
    }
    public String getMPAA(){
        return MPAA;
    }
    public void setMPAA(String MPAA){
        this.MPAA=MPAA;
    }
    public String getDirectorName(){
        return directorName;
    }
    public void setDirectorName(String directorName){
        this.directorName=directorName;
    }
    public String getStudio(){
        return Studio;
    }
    public void setStudio(String Studio){
        this.Studio=Studio;
    }
    public String getUserRating(){
        return userRating;
    }
    public void setUserRating(String userRating){
        this.userRating=userRating;
    }
}
