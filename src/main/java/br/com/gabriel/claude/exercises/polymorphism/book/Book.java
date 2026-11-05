package br.com.gabriel.claude.exercises.polymorphism.book;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int pages;
    private final LocalDate publicationDate;

    public Book(String isbn, String title, String author, int pages, LocalDate publicationDate) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.publicationDate = publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public int getYearsSincePublication() {
        return Period.between(publicationDate, LocalDate.now()).getYears();
    }

    public double calculatePopularityScore(int borrowCount) {
        return (double) borrowCount / (getYearsSincePublication() + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
