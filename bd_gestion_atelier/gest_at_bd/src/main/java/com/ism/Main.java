package com.ism;
import java.util.Scanner;

import com.ism.entities.Categorie;
import com.ism.repository.ITables;
import com.ism.repository.list.TableCategories;
import com.ism.services.CategorieService;
import com.ism.services.CategorieServiceImpl;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        ITables<Categorie> categorieRepository = new TableCategories();
        CategorieService categorieService = new CategorieServiceImpl(categorieRepository);
        
        int choice;
        
        do {
            System.out.println("-------MENU GENERAL-------");
            System.out.println("1----Ajouter une catégorie-----");
            System.out.println("2----Lister les catégories------");
            System.out.println("3----Modifier une catégorie------");
            System.out.println("4----Supprimer une catégorie-----");
            System.out.println("5----Rechercher une catégorie----");
            System.out.println("6----Supprimer plusieurs catégories------");
            System.out.println("7----Quitter------");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Lire la ligne en trop après le nombre
            
            switch (choice) {
                case 1:
                    System.out.println("Entrer le libellé de la catégorie :");
                    String libelle = scanner.nextLine();
                    Categorie newCategorie = new Categorie(libelle);
                    categorieService.add(newCategorie);
                    break;
                case 2:
                    System.out.println("Liste de toutes les catégories :");
                    categorieService.getAll().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Entrer l'ID de la catégorie à modifier :");
                    int categoryIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Lire la ligne en trop après le nombre
                    System.out.println("Entrer le nouveau libellé :");
                    String newLibelle = scanner.nextLine();
                    Categorie categorieToUpdate = new Categorie(newLibelle);
                    categorieToUpdate.setId(categoryIdToUpdate);
                    int updateResult = categorieService.update(categorieToUpdate);
                    if (updateResult >= 1) {
                        System.out.println("Catégorie mise à jour avec succès.");
                    } else {
                        System.out.println("La catégorie n'a pas pu être mise à jour.");
                    }
                    break;
                case 4:
                    System.out.println("Entrer l'ID de la catégorie à supprimer :");
                    int categoryIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Lire la ligne en trop après le nombre
                    int deleteResult = categorieService.remove(categoryIdToDelete);
                    if (deleteResult == 1) {
                        System.out.println("Catégorie supprimée avec succès.");
                    } else {
                        System.out.println("La catégorie n'a pas pu être supprimée.");
                    }
                    break;
                case 5:
                    System.out.println("Entrer l'ID de la catégorie à afficher :");
                    int categoryIdToShow = scanner.nextInt();
                    scanner.nextLine(); // Lire la ligne en trop après le nombre
                    Categorie categorieToShow = categorieService.show(categoryIdToShow);
                    if (categorieToShow != null) {
                        System.out.println("Catégorie : " + categorieToShow);
                    } else {
                        System.out.println("Catégorie non trouvée.");
                    }
                    break;
                case 6:
                    System.out.println("Entrer le nombre d'IDs à supprimer :");
                    int countToDelete = scanner.nextInt();
                    scanner.nextLine(); // Lire la ligne en trop après le nombre
                    int[] idsToDelete = new int[countToDelete];
                    for (int i = 0; i < countToDelete; i++) {
                        System.out.println("Entrer l'ID " + (i + 1) + " à supprimer :");
                        idsToDelete[i] = scanner.nextInt();
                        scanner.nextLine(); // Lire la ligne en trop après le nombre
                    }
                    int[] notDeletedIds = categorieService.remove(idsToDelete);
                    if (notDeletedIds.length == 0) {
                        System.out.println("Toutes les catégories ont été supprimées avec succès.");
                    } else {
                        System.out.println("Les catégories suivantes n'ont pas pu être supprimées :");
                        for (int id : notDeletedIds) {
                            System.out.println("ID " + id);
                        }
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (choice != 7);
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
