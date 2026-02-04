package org.example.repository;

import org.example.model.Strafe;

public class StrafeRepository extends InFileRepository<Strafe> {

    public StrafeRepository(String filepath) {
        super(Strafe.class, filepath);
    }
}
