package com.maxpro.support.service;

import com.maxpro.support.repository.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FaqService {

    @Autowired
    private FaqRepository faqRepository;

}
