package com.app.catagory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.catagory.model.Catagories;

@Repository
public interface CatagoryRepository extends JpaRepository<Catagories, Integer>
{

}
