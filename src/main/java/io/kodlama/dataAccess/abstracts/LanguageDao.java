package io.kodlama.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language,Integer>{

}
