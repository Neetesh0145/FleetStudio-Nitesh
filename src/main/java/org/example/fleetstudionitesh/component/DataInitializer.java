package org.example.fleetstudionitesh.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.example.fleetstudionitesh.entity.County;
import org.example.fleetstudionitesh.repository.CountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializer {

    @Autowired
    private CountyRepository countyRepository;

    @PostConstruct
    public void initData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<County>> typeReference = new TypeReference<List<County>>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/data.json");

        try {
            List<County> counties = mapper.readValue(inputStream, typeReference);
            countyRepository.saveAll(counties);
            System.out.println("Data imported successfully");
        } catch (IOException e) {
            System.out.println("Unable to import data: " + e.getMessage());
        }
    }
}
