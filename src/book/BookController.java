package book;

import java.util.ArrayList;

public class BookController{
    static ArrayList<BookModel> bookCollection = new ArrayList<>();

    public BookController(){
        boolean isRunning = true;
        Integer optionIndex;

        while(isRunning){
            optionIndex = getMenuOptionIndex();

        }
    }

    private Integer getMenuOptionIndex(){
        BookView view = new BookView();
        Integer minOptionIndex = 0;
        Integer maxOptionIndex = 6;
        Integer noOptionSelected = -1;

        Integer chosenOptionIndex = noOptionSelected;
        while(chosenOptionIndex<minOptionIndex || chosenOptionIndex>maxOptionIndex) {
            chosenOptionIndex = view.getIntFromUserInput(view.displayMenu);
        }
        return chosenOptionIndex;
    }

    private void redirectToOption(Integer optionIndex){
        switch (optionIndex){
            case 0:
                break;
            case 1:

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


}