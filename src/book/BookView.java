package book;

import console.AbstractConsoleView;

public class BookView extends AbstractConsoleView{

    public String menuText = "What would you like to do: \n" +
            "1. Add new book\n" +
            "2. Edit book data\n" +
            "3. Delete book\n" +
            "4. Search book collection\n" +
            "5. View book collection\n" +
            "6. View books by author\n";

    public String ISBNQuestionText = "Type in ISBN\n it has to be 13 characters long and contain numbers only";
    public String authorQuestionText = "Type in authors name: ";
    public String titleQuestionText = "Type in title: ";
    public String publisherNameQuestionText = "Type in publisher's name: ";
    public String publicationYearQuestionText = "Type in publication year: ";
    public String priceQuestionText = "Type in price of the book: ";
    public String typeQuestionText = "Type in type of the book: ";
}
