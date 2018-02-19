package author;

import book.BookModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface AuthorDao {
    Connection connectToDatabase() throws SQLException;
    ArrayList<AuthorModel> importAuthors() throws SQLException ;
}
