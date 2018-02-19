package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;

public class BookDaoImpl implements BookDao{

    @Override
    public Connection connectToDatabase() throws java.sql.SQLException {
        String dbPath = "jdbc:sqlite:database/database.db";
        return DriverManager.getConnection(dbPath);
    }

    @Override
    public void deleteBook(BookModel book) throws java.sql.SQLException{
        String bookName = book.getTitle();

        Connection con = connectToDatabase();
        Objects.requireNonNull(con).setAutoCommit(false);
        Statement stmt = con.createStatement();

        String sql = "DELETE from artifact_store WHERE name='" + bookName + "';";

        stmt.executeUpdate(sql);
        con.commit();

        stmt.close();
        con.close();
    }

    public void addBook(BookModel book) throws java.sql.SQLException{
        String ISBN = book.getISBN();
        String authorName = book.getAuthorName();
        String title = book.getTitle();
        String publisherName = book.getPublisherName();
        String publicationYear = book.getPublicationYear();
        String price = book.getPrice();
        String type = book.getType();

        Connection con = connectToDatabase();
        Objects.requireNonNull(con).setAutoCommit(false);
        Statement stmt = con.createStatement();

        String sql = ("INSERT INTO Books (ISBN, author, title, publisher, publication_year, price, type)" +
                "VALUES('"+ ISBN + "', '" + authorName + "', '" + title +
                "', '" + publisherName + "', '" + publicationYear +
                "', '" + price + "', '" + type + "');");
        stmt.executeUpdate(sql);

        con.commit();

        stmt.close();
        con.close();
    }

    public void updateBookInfo(BookModel book) throws java.sql.SQLException{
        String ISBN = book.getISBN();
        String authorName = book.getAuthorName();
        String title = book.getTitle();
        String publisherName = book.getPublisherName();
        String publicationYear = book.getPublicationYear();
        String price = book.getPrice();
        String type = book.getType();

        Connection con = connectToDatabase();
        Objects.requireNonNull(con).setAutoCommit(false);
        Statement stmt = con.createStatement();

        String sql = ("UPDATE Books SET " +
                "ISBN='" + ISBN + "', " +
                "author='" + authorName + "' " +
                "title=" + title + "' " +
                "publisher=" + publisherName + "' " +
                "publication_year=" + publicationYear + "' " +
                "price=" + price + "' " +
                "type=" + type + "' " +
                "WHERE ISBN='" + ISBN+ "';");

        stmt.executeUpdate(sql);
        con.commit();

        stmt.close();
        con.close();
    }
}