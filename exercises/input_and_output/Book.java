class Book {
    private final String title;
    private final int year;
    private final String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }
}
