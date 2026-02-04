package org.example;

import org.example.controller.FahrerController;
import org.example.controller.RennenEreignisController;
import org.example.controller.StrafeController;
import org.example.model.Fahrer;
import org.example.model.RennenEreignis;
import org.example.model.Strafe;
import org.example.repository.InFileRepository;
import org.example.service.FahrerService;
import org.example.service.RennenEreignisService;
import org.example.service.StrafeService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        InFileRepository<Fahrer> fahrerRepository = new InFileRepository<>(Fahrer.class, "src/main/resources/data/drivers.json");
        FahrerService fahrerService = new FahrerService(fahrerRepository);
        FahrerController fahrerController = new FahrerController(fahrerService);

        InFileRepository<Strafe> strafeRepository = new InFileRepository<>(Strafe.class, "src/main/resources/data/penalties.json");
        StrafeService strafeService = new StrafeService(strafeRepository);
        StrafeController strafeController =  new StrafeController(strafeService);

        InFileRepository<RennenEreignis> rennenEreignisRepository = new InFileRepository<>(RennenEreignis.class, "src/main/resources/data/events.json");
        RennenEreignisService rennenEreignisService = new RennenEreignisService(rennenEreignisRepository);
        RennenEreignisController rennenEreignisController =  new RennenEreignisController(rennenEreignisService);



        int optiune;
        do {
            System.out.println("\n=== MENIU PRINCIPAL ===");
            System.out.println("1. Show all fahrers");
            System.out.println("2. Show all penalties");
            System.out.println("3. Show all events");
            System.out.println("0. Iesire");
            System.out.print("Alege optiunea: ");
            optiune = scanner.nextInt();
            scanner.nextLine();

            switch (optiune) {
                case 1: fahrerController.showFahrers(); System.out.println("nr total de soferi: " + fahrerService.getNumberOfFahrers()); break;
                case 2: strafeController.showStrafen(); System.out.println("nr total de penalizari: " + strafeService.getNumberOfPenalties()); break;
                case 3: rennenEreignisController.showRennenEreignissen(); System.out.println("nr total de evenimente: " + rennenEreignisService.getNumberOfEvents()); break;
                case 0: System.out.println("La revedere!"); break;
                default: System.out.println("Optiune invalida!");
            }
        } while (optiune != 0);

        }

}

