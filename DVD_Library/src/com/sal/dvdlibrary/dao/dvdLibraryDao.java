package com.sal.dvdlibrary.dao;

import com.sal.dvdlibrary.dto.DvD;
import java.io.IOException;
import java.util.List;
/**
 *
 * @author Elizabeth Yim
 *
 */
public interface dvdLibraryDao {
    /**
     *
     * adds new DvD object to the dvdFile.txt using corresponding title
     * if dvd already exists, returns existing DvD object. otherwise, returns null
     *
     * @param title-title of new dvd
     * @param dvd-dvd object created to be added
     * @return the previous dvd object associated with title, otherwise, returns null
     *
     * */
    DvD addDvd(String title, DvD dvd) throws DvdLibraryDaoException, IOException;

    /**
     *
     * gets all the existing dvds from dvdFile.txt and puts them into an arrayList
     * returns the arrayList
     *
     * @return arrayList of all the existing dvds
     *
     * */
    List<DvD> getAllDvds() throws DvdLibraryDaoException;

    /**
     *
     * gets the dvd object that corresponds with the inputted title
     * returns dvd, otherwise, returns null if doesn't exist
     *
     * @param title-title of dvd in question
     * @return dvd object of corresponding title or null if does not exist
     *
     * */
    DvD getDvd(String title) throws DvdLibraryDaoException;

    /**
     *
     * removes dvd object from dvdFiles.txt
     * returns object, otherwise returns null if doesn't exist
     *
     * @param title-title of dvd in question
     * @return dvd object being removed or null if does not exist
     *
     * */
    DvD removeDvd(String title) throws DvdLibraryDaoException, IOException;

    /**
     *
     * edits the release date of the dvd in question
     * returns the dvd object, otherwise returns null if does not exist
     *
     * @param title-title of dvd in question
     * @return dvd object being edited or null if does not exist
     *
     * */
    DvD editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException, IOException;

    /**
     *
     * edits the MPAA rating of the dvd in question
     * returns the dvd object, otherwise returns null if does not exist
     *
     * @param title-title of dvd in question
     * @return dvd object being edited or null if does not exist
     *
     * */
    DvD editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException, IOException;

    /**
     *
     * edits the director's name of the dvd in question
     * returns the dvd object, otherwise returns null if does not exist
     *
     * @param title-title of dvd in question
     * @return dvd object being edited or null if does not exist
     *
     * */
    DvD editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException, IOException;

    /**
     *
     * edits the studio name of the dvd in question
     * returns the dvd object, otherwise returns null if does not exist
     *
     * @param title-title of dvd in question
     * @return dvd object being edited or null if does not exist
     *
     * */
    DvD editStudio(String title, String newStudioName) throws DvdLibraryDaoException, IOException;

    /**
     *
     * edits the user rating of the dvd in question
     * returns the dvd object, otherwise returns null if does not exist
     *
     * @param title-title of dvd in question
     * @return dvd object being edited or null if does not exist
     *
     * */
    DvD editUserRating(String title, String newUserRating) throws DvdLibraryDaoException, IOException;

}
