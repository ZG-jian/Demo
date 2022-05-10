package com.jian.service;

import com.jian.bean.Data;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LinkServiceTest {

    @Test
    public void findAll() {
        List<Data> data = LinkService.findAll();
        System.out.println(data);
    }

    @Test
    public void findById() {
        String link = LinkService.findById(100);
        System.out.println(link);
    }
}