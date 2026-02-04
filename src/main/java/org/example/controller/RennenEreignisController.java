package org.example.controller;

import org.example.service.RennenEreignisService;

import java.util.Scanner;

public class RennenEreignisController {

    private RennenEreignisService rennenEreignisService;

    private final Scanner scanner = new Scanner(System.in);

    public RennenEreignisController(RennenEreignisService rennenEreignisService) {
        this.rennenEreignisService = rennenEreignisService;
    }


    public void showRennenEreignissen() {
        rennenEreignisService.getAll().forEach(f ->
                System.out.println("[" + f.getId() + "]" + f.getFahrerId() + " ( " + f.getTyp() + " ) " + "-" + f.getBasePoints() + ", lap=" + f.getLap())
        );
    }
}
