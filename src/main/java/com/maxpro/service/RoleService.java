package com.maxpro.service;

import com.maxpro.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

}
