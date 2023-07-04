package spring.Dao;
/*  Project1
    май
    @author DiachenkoDanylo
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import spring.models.Book;
import spring.models.Person;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Person> index()  {
       return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){
        return  jdbcTemplate.query("SELECT * FROM Person  WHERE id = ?",new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
       jdbcTemplate.update("INSERT INTO Person(name, year) VALUES(?, ?)",
               person.getName(), person.getYear());
    }

    public void update(int id, Person updatePerson) {
        jdbcTemplate.update("UPDATE Person SET name=?, year=? WHERE id=?", updatePerson.getName(),
                updatePerson.getYear(), id);
    }


    public List<Book> getBooksByIdPerson(int id)  {
        return jdbcTemplate.query("SELECT * FROM Book WHERE personid = ?",new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }


    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

}
