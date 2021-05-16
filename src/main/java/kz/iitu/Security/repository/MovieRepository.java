package kz.iitu.Security.repository;

import kz.iitu.Security.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {
    @Query(value = "select * from test1.movies where match(name, description)" + "against(?1)",nativeQuery = true) public List<Movie> search(String keyword);
}
