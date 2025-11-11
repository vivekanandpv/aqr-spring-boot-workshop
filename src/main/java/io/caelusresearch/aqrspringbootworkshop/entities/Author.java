package io.caelusresearch.aqrspringbootworkshop.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Author {
    private int authorId;
    private String firstName;
    private String lastName;
    private String bio;
    private String email;
    private Set<Book> books = new HashSet<>();

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return authorId == author.authorId && Objects.equals(firstName, author.firstName) && Objects.equals(lastName, author.lastName) && Objects.equals(bio, author.bio) && Objects.equals(email, author.email) && Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, firstName, lastName, bio, email, books);
    }
}
