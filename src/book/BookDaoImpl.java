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

    
}