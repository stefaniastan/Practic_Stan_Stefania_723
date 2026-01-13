package org.example;

import org.example.controller.FahrerController;
import org.example.model.Fahrer;
import org.example.repository.InFileRepository;
import org.example.service.FahrerService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        InFileRepository<Fahrer> fahrerRepository = new InFileRepository<>(Fahrer.class, "src/main/resources/data/drivers.json");
        FahrerService fahrerService = new FahrerService(fahrerRepository);
        FahrerController fahrerController = new FahrerController(fahrerService);

        int optiune;
        do {
            System.out.println("\n=== MENIU PRINCIPAL ===");
            System.out.println("1. Fahrer");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1: fahrerController.fahrerMenu(scanner, fahrerController); break;
                case 0: System.out.println("La revedere!"); break;
                default: System.out.println("Optiune invalida!");
            }
        } while (optiune != 0);

        }
    }

