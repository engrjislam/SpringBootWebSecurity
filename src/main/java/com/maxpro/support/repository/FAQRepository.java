package com.maxpro.support.repository;

import com.maxpro.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FaqRepository extends JpaRepository<Faq, Long>{
}
