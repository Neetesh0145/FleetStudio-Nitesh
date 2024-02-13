package org.example.fleetstudionitesh.service;

import org.example.fleetstudionitesh.entity.County;
import org.example.fleetstudionitesh.repository.CountyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CountyServiceTest {

    @Mock
    private CountyRepository countyRepository;

    @InjectMocks
    private CountyService countyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSuggestCounties() {
        County county1 = new County("County1", "State1");
        County county2 = new County("County2", "State2");
        List<County> mockCounties = Arrays.asList(county1, county2);
        when(countyRepository.findByNameContainingIgnoreCaseOrStateContainingIgnoreCase("query1", ""))
                .thenReturn(mockCounties);

        List<County> result = countyService.suggestCounties("query1");

        assertEquals(2, result.size());
        assertEquals("County1", result.get(0).getName());
        assertEquals("State1", result.get(0).getState());
        assertEquals("County2", result.get(1).getName());
        assertEquals("State2", result.get(1).getState());
    }
}
