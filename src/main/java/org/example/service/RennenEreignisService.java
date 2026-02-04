package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.RennenEreignis;
import org.example.model.Strafe;
import org.example.repository.AbstractRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RennenEreignisService {

    private final AbstractRepository<RennenEreignis> rennenEreignisRepository;

    public RennenEreignisService(AbstractRepository<RennenEreignis> rennenEreignisRepository) {
        this.rennenEreignisRepository = rennenEreignisRepository;
    }

    //aufgabe 1
    private List<RennenEreignis> rennenEreignissen = new ArrayList<>();


    // Load events from events.json file
    public void loadRennenEreignissen(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.rennenEreignissen = mapper.readValue(new File(filePath), new TypeReference<List<RennenEreignis>>() {
        });
    }

    public int getNumberOfEvents() {
        return rennenEreignisRepository.findAll().size();
    }

    public void add(RennenEreignis rennenEreignis) {
        rennenEreignisRepository.save(rennenEreignis);
    }

    public RennenEreignis findById(Integer id) {
        return rennenEreignisRepository.findById(id);
    }

    public List<RennenEreignis> getAll() {
        return rennenEreignisRepository.findAll();
    }

    public void delete(Integer id) {
        rennenEreignisRepository.deleteById(id);
    }
}
