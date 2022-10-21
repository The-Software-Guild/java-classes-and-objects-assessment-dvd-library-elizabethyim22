package com.sal.dvdlibrary.ui;

import com.sal.dvdlibrary.dto.DvD;
import java.util.List;

/**
 *
 * @author Elizabeth Yim
 *
 * */
public class DvdLibraryView {
    private UserIO io;
    public DvdLibraryView(UserIO io) {
        this.io=io;
    }

    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. Add DVD");
        io.print("2. Remove DVD");
        io.print("3. Edit DVD");
        io.print("4. List All DVDs");
        io.print("5. Display DVD");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices. ", 1, 6);
    }
    public int printEditMenuAndGetSelection(){
        io.print("Edit Menu");
        io.print("1. Edit Release Date");
        io.print("2. Edit MPAA Ratings");
        io.print("3. Edit Director's Name");
        io.print("4. Edit Studio Name");
        io.print("5. Edit User Ratings");
        io.print("6. Exit");
        return io.readInt("Please select from the above choices. ", 1, 6);
    }
    //gets the info for the new dvd object to be created
    public DvD getNewDvDInfo() {
        String title =io.readString("Please enter the title of the DVD ");
        String releaseDate=io.readString("Please enter the release date of the DVD ");
        String MPAA=io.readString("Please enter the MPAA rating of the DVD ");
        String directorName=io.readString("Please enter the director's name of the DVD ");
        String Studio=io.readString("Please enter the studio name of the DVD ");
        String userRating=io.readString("Please enter the user ratings of the DVD ");
        //creates a new DvD object and instantiates with title
        DvD currentDvD=new DvD(title);
        currentDvD.setReleaseDate(releaseDate);
        currentDvD.setMPAA(MPAA);
        currentDvD.setDirectorName(directorName);
        currentDvD.setStudio(Studio);
        currentDvD.setUserRating(userRating);
        return currentDvD;
    }

    public void displayCreateDvDBanner() {
        io.print("=== Create DvD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DvD successfully created.  Please hit enter to continue");
    }

    //goes through the arrayList of dvds, formats the info and displays it
    public void displayDvdList(List<DvD> dvdList) {
        for (DvD currentDvD : dvdList) {
            String DvDInfo=String.format("%s : %s, %s, %s, %s, %s",
                    currentDvD.getTitle(),
                    currentDvD.getReleaseDate(),
                    currentDvD.getMPAA(),
                    currentDvD.getDirectorName(),
                    currentDvD.getStudio(),
                    currentDvD.getUserRating());
            io.print(DvDInfo);
        }
        io.readString("Please hit enter to continue. ");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    public void displayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    //gets title input from user
    public String getDvdTitleChoice() {
        return io.readString("Please enter the dvd title.");
    }

    //displays the info of a dvd object
    public void displayDvd(DvD dvd) {
        if (dvd!=null){
            io.print(String.format("title: %s", dvd.getTitle()));
            io.print(String.format("release date: %s", dvd.getReleaseDate()));
            io.print(String.format("MPAA rating: %s", dvd.getMPAA()));
            io.print(String.format("director's name: %s" ,dvd.getDirectorName()));
            io.print(String.format("studio: %s" , dvd.getStudio()));
            io.print(String.format("user rating: %s" ,dvd.getUserRating()));
        } else {
            io.print("No such DVD. ");
        }
        io.readString("Please press enter to continue. ");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(DvD dvdRecord) {
        if(dvdRecord!=null){
            io.print("DVD successfully removed! ");
        }else{
            io.print("No such DVD. ");
        }
        io.readString("Please press enter to continue. ");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    public void displayEditDvdBanner() {
        io.print("=== Edit DVD ===");
    }

    public void displayEditDvdSuccess() {
        io.readString(
                "DVD successfully Edited.  Please hit enter to continue");
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMpaaBanner() {
        io.print("=== Edit DVD MPAA rating ===");
    }

    public void displayEditDirectorNameBanner() {
        io.print("=== Edit DVD Director's Name ===");
    }

    public void displayEditStudio() {
        io.print("=== Edit DVD Studio ===");
    }

    public void displayEditUserRating() {
        io.print("=== Edit DVD User Rating ===");
    }

    public String getNewReleaseDate() {
        return io.readString("Please enter new release date.");
    }

    public String getNewMpaaRating() {
        return io.readString("Please enter new MPAA rating.");
    }

    public String getNewDirectorName() {
        return io.readString("Please enter new director's name.");
    }

    public String getNewUserRating() {
        return io.readString("Please enter new user rating.");
    }

    public String getNewStudio() {
        return io.readString("Please enter new studio.");
    }

    public void displayNullDVD() {
        io.print("No such DVD.");
        io.readString("Please hit enter to continue.");
    }
}
