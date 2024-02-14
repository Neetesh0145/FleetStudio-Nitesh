package org.example.fleetstudionitesh.rest;

import org.example.fleetstudionitesh.entity.County;
import org.example.fleetstudionitesh.service.CountyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CountyController {
    @Autowired
    private CountyService countyService;

    @GetMapping("/suggest")
    public ResponseEntity<List<County>> suggestCounties(@RequestParam("q") String query) {
        List<County> counties = countyService.suggestCounties(query);
        //return ResponseEntity.ok(counties.subList(0, Math.min(5, counties.size())));
        return ResponseEntity.ok(counties);
    }
}
