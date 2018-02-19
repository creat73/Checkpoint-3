package author;

import java.util.ArrayList;

public class AuthorController {
    static ArrayList<AuthorModel> authors;

    public AuthorController() {
        AuthorDaoImpl dao = new AuthorDaoImpl();
        AuthorView view = new AuthorView();
        try {
            authors = dao.importAuthors();

        }
        catch(java.sql.SQLException e){
            view.print(e.toString());
        }
    }

    public static ArrayList<AuthorModel> getAuthors() {
        return authors;
    }
}
