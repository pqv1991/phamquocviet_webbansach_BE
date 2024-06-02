package pqv.webbansach.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pqv.webbansach.entity.Genre;

@RepositoryRestResource(path = "genres")
public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
