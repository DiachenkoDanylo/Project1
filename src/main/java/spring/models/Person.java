package spring.models;
/*  Project1
    май
    @author DiachenkoDanylo
*/

//import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = " Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 char")
    private String name;

    @Min(value = 1900, message = "Age should not be less than 18")
    @Max(value = 2005, message = "Age should not be greater than 150")
    private int year;

    public Person(){
    }

    public Person(int id, String name,int year ){
        this.id = id;
        this.name = name;
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

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}

}
