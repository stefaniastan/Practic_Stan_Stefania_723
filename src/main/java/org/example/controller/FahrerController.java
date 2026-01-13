package org.example.controller;

import org.example.model.Fahrer;
import org.example.service.FahrerService;

import java.util.List;
import java.util.Scanner;

public class FahrerController {
    private FahrerService fahrerService;

    private final Scanner scanner = new Scanner(System.in);

    public FahrerController(FahrerService fahrerService) {
        this.fahrerService = fahrerService;
    }


    public void fahrerMenu(Scanner scanner,FahrerController fahrerController) {
        while (true) {
            System.out.println("""
                1. show fahrers
                0. Exit
                """);

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> showFahrers();
                case 0 -> { return; }
                default -> System.out.println("Invalid option");
            }
        }
    }

//    private void addBook() {
//        System.out.print("Title: ");
//        String title = scanner.nextLine();
//
//        System.out.print("Author: ");
//        String author = scanner.nextLine();
//
//        System.out.print("Year: ");
//        int year = Integer.parseInt(scanner.nextLine());
//
//        bookService.add(new Book(title, author, year, true));
//    }

//    private void showBook(){
//        System.out.print("ID zu finden: ");
//        int id = Integer.parseInt(scanner.nextLine());
//
//        Book book = bookService.findById(id);
//
//        if (book == null) {
//            System.out.println("Book not found!");
//        } else {
//            System.out.println("Titel: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nYear: " + book.getYear());
//        }
//    }

    private void showFahrers() {
        fahrerService.getAll().forEach(f ->
                System.out.println(f.getId() + " | " + f.getName())
        );
    }

//    private void deleteBook() {
//        System.out.print("ID zu loschen: ");
//        bookService.delete(Integer.valueOf(scanner.nextLine()));
//    }
}


