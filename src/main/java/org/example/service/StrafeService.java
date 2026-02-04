package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Fahrer;
import org.example.model.Strafe;
import org.example.repository.AbstractRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StrafeService {

    private final AbstractRepository<Strafe> strafeRepository;

    public StrafeService(AbstractRepository<Strafe> strafeRepository) {
        this.strafeRepository = strafeRepository;
    }

    //aufgabe 1
    private List<Strafe> strafen = new ArrayList<>();


    // Load events from penalties.json file
    public void loadStrafen(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        this.strafen = mapper.readValue(new File(filePath), new TypeReference<List<Strafe>>() {
        });
    }

    public int getNumberOfPenalties() {
        return strafeRepository.findAll().size();
    }

    public void add(Strafe strafe) {
        strafeRepository.save(strafe);
    }

    public Strafe findById(Integer id) {
        return strafeRepository.findById(id);
    }

    public List<Strafe> getAll() {
        return strafeRepository.findAll();
    }

    public void delete(Integer id) {
        strafeRepository.deleteById(id);
    }

}
