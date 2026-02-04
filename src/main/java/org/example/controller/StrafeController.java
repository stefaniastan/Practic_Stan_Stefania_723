package org.example.controller;
import org.example.model.Strafe;
import org.example.service.StrafeService;

import java.util.Scanner;

public class StrafeController {
    private StrafeService  strafeService;

    private final Scanner scanner = new Scanner(System.in);

    public StrafeController(StrafeService strafeService) {
        this.strafeService = strafeService;
    }


    public void showStrafen() {
        strafeService.getAll().forEach(f ->
                System.out.println("[" + f.getId() + "]" + f.getFahrerId() + " ( " + f.getGrund() + " ) " + "-" + f.getSeconds() + ", lap=" + f.getLap())
        );
    }

}
