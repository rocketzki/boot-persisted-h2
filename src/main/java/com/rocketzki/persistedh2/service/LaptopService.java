package com.rocketzki.persistedh2.service;

import com.rocketzki.persistedh2.model.Laptop;
import com.rocketzki.persistedh2.repository.LaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    private LaptopRepo repo;

    @Autowired
    public LaptopService(LaptopRepo repo) {
        this.repo = repo;
    }


    public List<Laptop> getAllLaptops() {
        return repo.getAllLaptops();
    }


}
