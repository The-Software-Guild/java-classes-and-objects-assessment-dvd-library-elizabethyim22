import com.sal.dvdlibrary.controller.DvdLibraryController;
import com.sal.dvdlibrary.dao.DvdLibraryDaoException;
import com.sal.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.sal.dvdlibrary.dao.dvdLibraryDao;
import com.sal.dvdlibrary.ui.DvdLibraryView;
import com.sal.dvdlibrary.ui.UserIO;
import com.sal.dvdlibrary.ui.UserIOConsoleImpl;
import java.io.IOException;
/**
*
* @author Elizabeth Yim
*
* */
public class App {
    public static void main(String[] args) throws DvdLibraryDaoException, IOException {
        UserIO myIo =  new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        dvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myView, myDao);
        controller.run();
    }

}