package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Opt;

public interface OptRepo extends JpaRepository<Opt, Integer> {

}
