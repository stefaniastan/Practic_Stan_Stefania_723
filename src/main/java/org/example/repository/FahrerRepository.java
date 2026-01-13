package org.example.repository;

import org.example.model.Fahrer;

public class FahrerRepository extends InFileRepository<Fahrer> {

    public FahrerRepository(String filepath) {
        super(Fahrer.class, filepath);
    }
}



