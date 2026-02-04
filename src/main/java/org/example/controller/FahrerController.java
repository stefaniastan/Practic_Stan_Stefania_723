package org.example.controller;

import org.example.model.Fahrer;
import org.example.service.FahrerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FahrerController {
    private FahrerService fahrerService;

    private final Scanner scanner = new Scanner(System.in);

    public FahrerController(FahrerService fahrerService) {
        this.fahrerService = fahrerService;
    }


    public void showFahrers() {
        fahrerService.getAll().forEach(f ->
                System.out.println("[" + f.getId() + "]" + f.getName() + " ( " + f.getTeam() + " ) " + "-" + f.getStatus() + ", skill=" + f.getSkillLevel())
        );
    }

    //aufgabe 2
    public void getActiveFahrersFromTeam(String team) {
        List<Fahrer> fahrers = fahrerService.getActiveFahrersFromTeam(team);
        for (Fahrer fahrer : fahrers) {
            System.out.println(fahrer);
        }
    }



}


