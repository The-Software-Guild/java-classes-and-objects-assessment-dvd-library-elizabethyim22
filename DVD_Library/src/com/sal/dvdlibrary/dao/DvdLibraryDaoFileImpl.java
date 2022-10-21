package com.sal.dvdlibrary.dao;

import com.sal.dvdlibrary.dto.DvD;
import java.io.*;
import java.util.*;
/**
 *
 * @author Elizabeth Yim
 *
 * */
public class DvdLibraryDaoFileImpl implements dvdLibraryDao{
    public final String DVD_FILE ;
    public static final String DELIMITER="::";
    //hashmap to hold newly created dvd Objects
    //key:title , value:dvd info
    private Map<String, DvD> dvds=new HashMap<>();
    public DvdLibraryDaoFileImpl(){
        DVD_FILE="dvdFile.txt";
    }

    @Override
    public DvD addDvd(String title, DvD dvd) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            return dvds.get(title);
        } else {
            DvD newDvD=dvds.put(title, dvd);
            writeDvdFile();
            return null;
        }
    }

    @Override
    public List<DvD> getAllDvds() throws DvdLibraryDaoException {
        loadDvdFile();
        return new ArrayList<DvD>(dvds.values());
    }

    @Override
    public DvD getDvd(String title) throws DvdLibraryDaoException{
        loadDvdFile();
        if (dvds.containsKey(title)){
            return dvds.get(title);
        } else {
            return null;
        }
    }

    @Override
    public DvD removeDvd(String title) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            DvD removedDvD = dvds.remove(title);
            writeDvdFile();
            return removedDvD;
        } else {
            return null;
        }
    }

    @Override
    public DvD editReleaseDate(String title, String newReleaseDate) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            DvD currentDVD = dvds.get(title);
            currentDVD.setReleaseDate(newReleaseDate);
            writeDvdFile();
            return currentDVD;
        } else {
            return null;
        }
    }
    @Override
    public DvD editMPAA(String title, String newMpaaRating) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            DvD currentDVD = dvds.get(title);
            currentDVD.setMPAA(newMpaaRating);
            writeDvdFile();
            return currentDVD;
        } else {
            return null;
        }
    }
    @Override
    public DvD editDirectorName(String title, String newDirectorName) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            DvD currentDVD = dvds.get(title);
            currentDVD.setDirectorName(newDirectorName);
            writeDvdFile();
            return currentDVD;
        } else {
            return null;
        }
    }
    @Override
    public DvD editStudio(String title, String newStudioName) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            DvD currentDVD = dvds.get(title);
            currentDVD.setStudio(newStudioName);
            writeDvdFile();
            return currentDVD;
        } else {
            return null;
        }

    }
    @Override
    public DvD editUserRating(String title, String newUserRating) throws DvdLibraryDaoException {
        loadDvdFile();
        if (dvds.containsKey(title)){
            DvD currentDVD = dvds.get(title);
            currentDVD.setUserRating(newUserRating);
            writeDvdFile();
            return currentDVD;
        } else {
            return null;
        }
    }

    /**
     *
     * takes in dvd info as string and unmarshalls it into a DvD object
     * returns the dvd object
     *
     * @param dvdAsText-string version of dvd object
     * @return dvdAsText converted into a DvD object
     *
     * */
    private DvD unmarshallDvd(String dvdAsText) {
        //array of strings
        String[] dvdTokens=dvdAsText.split(DELIMITER);
        String dvdTitle=dvdTokens[0];
        DvD dvdFromFile=new DvD(dvdTitle);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMPAA(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserRating(dvdTokens[5]);
        return dvdFromFile;
    }

    //reads in characters from DVD_FILE, going line by line and converting each string to an object
    //and puts that object in dvds hashmap
    private void loadDvdFile() throws DvdLibraryDaoException {
        Scanner scanner;
        try{
            scanner=new Scanner(new BufferedReader
                    (new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e){
            throw new DvdLibraryDaoException("Could not load dvd " +
                    "data into memory.", e);
        }
        //holds most recent line read from file
        String currentLine="";
        //holds most recent dvd unmarshalled
        DvD currentDvd = null;
        //unmarshalls each line in the text
        while(scanner.hasNextLine()){
            currentLine=scanner.nextLine();
            currentDvd=unmarshallDvd(currentLine);
            //puts the new dvd object in dvds map
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();

    }

    /**
     *
     * takes in dvd info as dvd object and marshalls it into a string
     * returns the string
     *
     * @param aDvd-dvd object
     * @return aDvd converted to a string
     *
     * */
    private String marshallDvd(DvD aDvd) throws DvdLibraryDaoException {
        String dvdString=aDvd.getTitle()+DELIMITER+aDvd.getReleaseDate()+DELIMITER+
                aDvd.getMPAA()+DELIMITER+aDvd.getDirectorName()+DELIMITER+aDvd.getStudio()
                +DELIMITER+aDvd.getUserRating();
        return dvdString;

    }

    //updates the DVD_FILE with any changes
    private void writeDvdFile() throws DvdLibraryDaoException {
        PrintWriter out;
        try{
            out=new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e){
            throw new DvdLibraryDaoException("Could not save dvd data.", e);
        }
        String dvdAsText;
        List<DvD> dvdList=this.getAllDvds();
        for (DvD currentDvd : dvdList){
            dvdAsText=marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();



    }


}