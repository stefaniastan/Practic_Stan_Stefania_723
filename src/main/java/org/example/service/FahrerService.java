package org.example.service;

import org.example.model.Fahrer;
import org.example.repository.AbstractRepository;

import java.util.List;

public class FahrerService {
    private final AbstractRepository<Fahrer> fahrerRepository;

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


