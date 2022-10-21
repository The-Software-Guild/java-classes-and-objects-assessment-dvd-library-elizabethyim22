package com.sal.dvdlibrary.controller;
import com.sal.dvdlibrary.dao.DvdLibraryDaoException;
import com.sal.dvdlibrary.dao.dvdLibraryDao;
import com.sal.dvdlibrary.dto.DvD;
import com.sal.dvdlibrary.ui.DvdLibraryView;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Elizabeth Yim
 *
 * */

public class DvdLibraryController {
    private DvdLibraryView view;
    private dvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryView view, dvdLibraryDao dao) {
        this.view=view;
        this.dao=dao;
    }

    public void run() throws IOException {
        boolean endSwitch = true;
        int menuSelection = 0;
        try {
            while (endSwitch) {
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        endSwitch = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        }catch(DvdLibraryDaoException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    //displays the menu selection
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    //creates a new DvD object by getting dvd info from user and adds the new dvd to dvdFile.txt
    private void createDvd() throws DvdLibraryDaoException, IOException {
        view.displayCreateDvDBanner();
        DvD newDvD=view.getNewDvDInfo();
        dao.addDvd(newDvD.getTitle(), newDvD);
        view.displayCreateSuccessBanner();
    }

    //lists all existing dvds in dvdDile.txt
    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DvD> dvdList=dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    //takes title input from user and displays the dvd info that corresponds with that title
    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDvdBanner();
        String title=view.getDvdTitleChoice();
        DvD dvd = dao.getDvd(title);
        if (dvd==null){
            view.displayNullDVD();
        } else{
            view.displayDvd(dvd);
        }
    }

    //takes title input from user and removes corresponding dvd object from dvdFile.txt
    private void removeDvd() throws DvdLibraryDaoException, IOException {
        view.displayRemoveDvdBanner();
        String dvdTitle= view.getDvdTitleChoice();
        DvD removedDvD=dao.removeDvd(dvdTitle);
        if (removedDvD==null){
            view.displayNullDVD();
        } else{
            view.displayRemoveResult(removedDvD);
        }
    }

    //takes title input from user, displays edit menu options, takes in edit choice from user, and updates the
    //corresponding info for the chosen title
    private void editDvd() throws DvdLibraryDaoException, IOException {
        view.displayEditDvdBanner();
        String title = view.getDvdTitleChoice();
        DvD currentDVD = dao.getDvd(title);
        if (currentDVD == null) {
            view.displayNullDVD();
        } else {
            view.displayDvd(currentDVD);
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection) {
                    case 1:
                        editReleaseDate(title);
                        break;
                    case 2:
                        editMPAA(title);
                        break;
                    case 3:
                        editDirectorName(title);
                        break;
                    case 4:
                        editStudioName(title);
                        break;
                    case 5:
                        editUserRating(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
                if (keepGoing == false) {
                    break;
                }
            }
        }
    }

    //displays the edit menu options
    private int getEditMenuSelection(){
        return view.printEditMenuAndGetSelection();
    }

    //takes in title input from the user and edits the release date of the dvd object that corresponds with the title
    private void editReleaseDate(String title) throws DvdLibraryDaoException, IOException {
        view.displayEditReleaseDateBanner();
        String newReleaseDate = view.getNewReleaseDate();
        dao.editReleaseDate(title, newReleaseDate);
        view.displayEditDvdSuccess();
    }

    //takes in title input from the user and edits the MPAA rating of the dvd object that corresponds with the title
    private void editMPAA(String title) throws DvdLibraryDaoException, IOException {
        view.displayEditMpaaBanner();
        String newMPAA = view.getNewMpaaRating();
        dao.editMPAA(title, newMPAA);
        view.displayEditDvdSuccess();
    }

    //takes in title input from the user and edits the director's name of the dvd object that corresponds with the title
    private void editDirectorName(String title) throws DvdLibraryDaoException, IOException {
        view.displayEditDirectorNameBanner();
        String newDirector = view.getNewDirectorName();
        dao.editDirectorName(title, newDirector);
        view.displayEditDvdSuccess();
    }

    //takes in title input from the user and edits the studio name of the dvd object that corresponds with the title
    private void editStudioName(String title) throws DvdLibraryDaoException, IOException {
        view.displayEditStudio();
        String newStudio = view.getNewStudio();
        dao.editStudio(title, newStudio);
        view.displayEditDvdSuccess();
    }

    //takes in title input from the use and edits the user rating of the dvd object that corresponds with the title
    private void editUserRating(String title) throws DvdLibraryDaoException, IOException {
        view.displayEditUserRating();
        String newRating = view.getNewUserRating();
        dao.editUserRating(title, newRating);
        view.displayEditDvdSuccess();
    }

    //displays unknown command banner when the user inputs an option that is not supported
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }

}
