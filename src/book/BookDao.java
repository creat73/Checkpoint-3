package book;


import java.sql.Connection;
import java.sql.SQLException;

public interface BookDao{
    Connection connectToDatabase() throws SQLException;
    void addBook(BookModel book) throws SQLException ;
    void updateBookInfo(BookModel book) throws SQLException;
    void deleteBook(BookModel book) throws SQLException;
}