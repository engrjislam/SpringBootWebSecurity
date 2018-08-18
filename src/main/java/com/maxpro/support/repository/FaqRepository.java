package com.maxpro.support.repository;

import com.maxpro.model.Faq;
import com.maxpro.support.model.FaqStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FaqRepository extends JpaRepository<Faq, Long>{

    List<Faq> findByStatus(FaqStatus faqStatus);

}
