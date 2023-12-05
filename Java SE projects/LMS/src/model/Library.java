package model;

public class Library {
    private long id;
    private String name;
    private String author;
    private String genre;
    private int pageCount;
    private String language;
    private double price;
    private int count;
    private byte stockStatus;
    private boolean bookStatus;


    public Library(long id, String name, String author, String genre, int pageCount, String language, double price, int count, byte stockStatus, boolean bookStatus) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.pageCount = pageCount;
        this.language = language;
        this.price = price;
        this.count = count;
        this.stockStatus = stockStatus;
        this.bookStatus = bookStatus;
    }

    @Override
    public String
    toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", pageCount=" + pageCount +
                ", language='" + language + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", stockStatus=" + stockStatus +
                ", bookStatus=" + bookStatus +
                '}';
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public byte getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(byte stockStatus) {
        this.stockStatus = stockStatus;
    }

    public void getInfo() {
        System.out.println(
                "name='" + name + '\'' +
                        ", author='" + author + '\'' +
                        ", genre='" + genre + '\'' +
                        ", pageCount=" + pageCount +
                        ", language='" + language + '\''
        );

    }
}
