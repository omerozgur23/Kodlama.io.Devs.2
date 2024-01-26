package io.kodlama.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}
