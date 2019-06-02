package com.ajh.aijihui.service;

import com.ajh.aijihui.mapper.AjhAddrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AjhAddrService {

    @Autowired
    private AjhAddrMapper ajhAddrMapper;


}