package com.rocketzki.persistedh2.repository;

import com.rocketzki.persistedh2.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

    @Query(value = "select * from laptops", nativeQuery = true)
    List<Laptop> getAllLaptops();



}
