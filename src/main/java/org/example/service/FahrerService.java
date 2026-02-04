package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Fahrer;
import org.example.repository.AbstractRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FahrerService {
    private final AbstractRepository<Fahrer> fahrerRepository;


    //aufgabe 1
    private List<Fahrer> fahrers = new ArrayList<>();

    // Load events from events.json file
    public void loadFahrers(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.fahrers = mapper.readValue(new File(filePath), new TypeReference<List<Fahrer>>() {
        });
    }
    public int getNumberOfFahrers() {
        return fahrerRepository.findAll().size();
    }

    //aufgabe 2
    //die fahrers die active sind von ein team (gelesen vo tastatur)

    public List<Fahrer> getActiveFahrersFromTeam(String team) {
        return fahrerRepository.findAll().stream()
                .filter(f -> f.getTeam().equalsIgnoreCase(team))
                .filter(f-> "active".equalsIgnoreCase(f.getStatus().toString()))
                .collect(Collectors.toList());

    }


    public FahrerService(AbstractRepository<Fahrer> fahrerRepository) {
        this.fahrerRepository = fahrerRepository;
    }

    public void add(Fahrer fahrer) {
        fahrerRepository.save(fahrer);
    }

    public Fahrer findById(Integer id) {
        return fahrerRepository.findById(id);
    }

    public List<Fahrer> getAll() {
        return fahrerRepository.findAll();
    }

    public void delete(Integer id) {
        fahrerRepository.deleteById(id);
    }
}


