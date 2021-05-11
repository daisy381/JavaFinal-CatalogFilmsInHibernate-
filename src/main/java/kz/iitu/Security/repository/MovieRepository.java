package kz.iitu.Security.repository;

import kz.iitu.Security.entity.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,Long> {
}
