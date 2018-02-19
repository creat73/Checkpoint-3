package book;

public class BookModel{
    private String ISBN;
    private String authorName;
    private String title;
    private String publisherName;
    private String publicationYear;
    private String price;
    private String type;

    public BookModel(String ISBN, String authorName, String title, String publisherName, String publicationYear
    ,String price, String type){
        this.ISBN = ISBN;
        this.authorName = authorName;
        this.title = title;
        this.publisherName = publisherName;
        this.publicationYear = publicationYear;
        this.price = price;
        this.type = type;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}