package org.example.fleetstudionitesh.service;

import org.example.fleetstudionitesh.entity.County;
import org.example.fleetstudionitesh.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountyService {
    @Autowired
    private CountyRepository countyRepository;

    public List<County> suggestCounties(String query) {
        String[] fragments = query.split(",");
        String nameFragment = fragments[0].trim();
        String stateFragment = fragments.length > 1 ? fragments[1].trim() : "";
        return countyRepository.findByNameContainingIgnoreCaseOrStateContainingIgnoreCase(nameFragment, stateFragment);
    }
}
