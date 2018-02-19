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
        String bookName = book.getName();

        Connection con = connectToDatabase();
        Objects.requireNonNull(con).setAutoCommit(false);
        Statement stmt = con.createStatement();

        String sql = "DELETE from artifact_store WHERE name='" + bookName + "';";

        stmt.executeUpdate(sql);
        con.commit();

        stmt.close();
        con.close();
    }

    
}