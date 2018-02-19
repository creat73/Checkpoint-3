package book;

import java.util.ArrayList;

public class BookController{
    static ArrayList<BookModel> bookCollection = new ArrayList<>();

    public BookController(){
        boolean isRunning = true;
        Integer optionIndex;

        while(isRunning){
            optionIndex = getMenuOptionIndex();
            redirectToOption(optionIndex);

        }
    }

    private Integer getMenuOptionIndex(){
        BookView view = new BookView();
        Integer minOptionIndex = 0;
        Integer maxOptionIndex = 6;
        Integer noOptionSelected = -1;

        Integer chosenOptionIndex = noOptionSelected;
        while(chosenOptionIndex<minOptionIndex || chosenOptionIndex>maxOptionIndex) {
            chosenOptionIndex = view.getIntFromUserInput(view.menuText);
        }
        return chosenOptionIndex;
    }

    private void redirectToOption(Integer optionIndex){
        switch (optionIndex){
            case 0:
                break;
            case 1:
                addBook();
            case 2:
                editBook();

        }
    }

    private void addBook(){
        BookView view = new BookView();
        BookDaoImpl dao = new BookDaoImpl();
        BookModel newBook;

        String ISBN = getISBNFromUser();
        String authorName = view.getStringFromUserInput(view.authorQuestionText);
        String title = view.getStringFromUserInput(view.titleQuestionText);
        String publisherName = view.getStringFromUserInput(view.publisherNameQuestionText);
        String publicationYear = view.getIntFromUserInput(view.publicationYearQuestionText).toString();
        String price = view.getIntFromUserInput(view.priceQuestionText).toString();
        String type = view.getStringFromUserInput(view.typeQuestionText);

        newBook = new BookModel(ISBN, authorName, title, publisherName, publicationYear, price, type);
        try {
            dao.addBook(newBook);
            bookCollection.add(newBook);
        }
        catch(java.sql.SQLException e){
            view.print(e.toString());
        }
    }

    private String getISBNFromUser(){
        BookView view = new BookView();
        String ISBN = "";
        boolean isISBNCorrect = false;
        Integer validISBNLength = 13;

        while(!isISBNCorrect){
            ISBN = view.getStringFromUserInput(view.ISBNQuestionText);
            ISBN = ISBN.replaceAll("\\D+","");
            if (ISBN.length() == validISBNLength){
                isISBNCorrect = true;
            }
        }

        return ISBN;
    }

    private void editBook(){
        BookDaoImpl dao = new BookDaoImpl();
        BookView view = new BookView();
        Integer noOptionChosen = -1;
        Integer chosenMenuOption = noOptionChosen;
        Integer minMenuOption = 0;
        Integer maxMenuOption = 7;

        BookModel book = chooseBookToEdit();

        while (chosenMenuOption<minMenuOption || chosenMenuOption>maxMenuOption){
            chosenMenuOption = view.getIntFromUserInput(view.bookEditQuestion);
        }
        try {
            switch (chosenMenuOption) {
                case 1:
                    String ISBN = getISBNFromUser();
                    book.setISBN(ISBN);
                    break;
                case 2:
                    String authorName = view.getStringFromUserInput(view.authorQuestionText);
                    book.setAuthorName(authorName);
                    break;
                case 3:
                    String title = view.getStringFromUserInput(view.titleQuestionText);
                    book.setTitle(title);
                    break;
                case 4:
                    String publisherName = view.getStringFromUserInput(view.publisherNameQuestionText);
                    book.setPublisherName(publisherName);
                    break;
                case 5:
                    String publicationYear = view.getIntFromUserInput(view.publicationYearQuestionText).toString();
                    book.setPublicationYear(publicationYear);
                    break;
                case 6:
                    String price = view.getIntFromUserInput(view.priceQuestionText).toString();
                    book.setPrice(price);
                    break;
                case 7:
                    String type = view.getStringFromUserInput(view.typeQuestionText);
                    book.setType(type);
            }
            dao.updateBookInfo(book);
        }
        catch(java.sql.SQLException e){
            view.printLine(e.toString());
        }
    }

    private BookModel chooseBookToEdit(){
        BookView view = new BookView();
        Integer bookIndex = 0;
        Integer noIndexChosen = -1;
        Integer chosenIndex = noIndexChosen;

        for(BookModel book:bookCollection){
            view.printLine(bookIndex.toString() + " " + book.getTitle());
            bookIndex++;
        }

        while(chosenIndex<0 || chosenIndex>bookIndex) {
            chosenIndex = view.getIntFromUserInput(view.whichBook);
        }

        return(bookCollection.get(chosenIndex));
    }

}