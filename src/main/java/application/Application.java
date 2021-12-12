package application;

import connector.ApiConnector;
import connector.ApiConnectorImpl;
import repository.Repository;
import repository.RepositoryImpl;
import service.AppService;
import service.AppServiceImpl;

import java.util.Scanner;

public class Application {

    private final AppService appService;

    public Application(AppService appService) {
        this.appService = appService;
    }

    public void start() {


        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWitaj w projekcie bibliotecznym\n");
        System.out.println("Podaj numer akcji, którą chciałbyś wykonać:\n");
        System.out.println("1. Wyszukaj ksiązkę po tytule");
        System.out.println("2. Pokaż książki danego autora");
        System.out.println("3. Pokaż książki z danej epoki");


        try {

            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {

                case 1:
                    System.out.println("Podaj szukany tytuł");
                    String searchingTitle = scanner.nextLine().toLowerCase();
                    System.out.println(appService.getTitle(searchingTitle));
                    break;

                case 2:
                    System.out.println("Podaj szukanego autora");
                    String searchingAuthor = scanner.nextLine().toLowerCase();
                    System.out.println(appService.getAuthor(searchingAuthor));
                    break;

                case 3:
                    System.out.println("Podaj interesującą epokę");
                    String searchingEpoch = scanner.nextLine().toLowerCase();
                    System.out.println(appService.getEpoch(searchingEpoch));

                    break;


                default:
                    System.out.println("Wybrano niepoprawą opcję");
            }


        } catch (NumberFormatException e) {
            System.err.println("Wrong number");
        }

    }


}