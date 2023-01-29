package com.course.courses.Repository;
import com.course.courses.domain.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor // Jdbctemplates di 해주기 위함
public class CourseRepository implements CourseRepositoryInterface{

    final private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void save(Course course) {
        String name = course.getName();
        String author = course.getAuthor();
        String sql = "INSERT INTO course(name, author) VALUES(?,?)";
        jdbcTemplate.update(sql,name,author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        String sql = "SELECT * FROM course";
        return jdbcTemplate.query(sql, ROW_MAPPER());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findById(int id) {
        String sql = "SELECT * FROM course WHERE ID = ?";
        boolean isCourseNotExist = jdbcTemplate.query(sql,(rs,rowNum)->0,id).isEmpty();
        if(isCourseNotExist){
            return Optional.empty();
        }else{
            List<Course> res = jdbcTemplate.query(sql, ROW_MAPPER(), id);
            return res.stream().findAny();
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        String sql = "DELETE FROM course WHERE ID = ?";
        String search = "SELECT * FROM course WHERE ID = ?";
        boolean isCourseNotExist = jdbcTemplate.query(search, (rs,rowNum)->0, id).isEmpty();
        if(!isCourseNotExist){
            jdbcTemplate.update(sql, id);
        }
    }


    private RowMapper<Course> ROW_MAPPER() {
        return (rs, rowNum)->{
            int ID = rs.getInt("ID");
            String name = rs.getString("name");
            String author = rs.getString("author");
            return new Course(ID,name,author);
        };
    }
}
