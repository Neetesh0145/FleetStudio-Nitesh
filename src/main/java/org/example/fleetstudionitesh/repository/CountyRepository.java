package org.example.fleetstudionitesh.repository;

import org.example.fleetstudionitesh.entity.County;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountyRepository extends JpaRepository<County, String> {
    List<County> findByNameContainingIgnoreCaseOrStateContainingIgnoreCase(String name, String state);
}
