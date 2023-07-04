package spring.models;
/*  Project1
    май
    @author DiachenkoDanylo
*/

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;



    @NotEmpty(message = " Name should not be empty")
    @Size(min = 2, max = 60, message = "Name should be between 2 and 30 char")
    private String name;

    @NotEmpty(message = " Name should not be empty")
    @Size(min = 2, max = 60, message = "Name should be between 2 and 30 char")
    private String author;

    @Min(value = 0, message = " age should be grater than  0")
    private int year;

    public Book(){
    }

    public Book(int id, String name,int year, String author){
        this.id =id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
