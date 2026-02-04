package org.example.repository;

import org.example.model.Fahrer;
import org.example.model.RennenEreignis;

public class RennenEreignisRepository extends InFileRepository<RennenEreignis> {

    public RennenEreignisRepository(String filepath) {
        super(RennenEreignis.class, filepath);
    }
}
