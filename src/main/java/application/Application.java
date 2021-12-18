package application;

import model.Author;
import model.Book;
import model.Epoch;
import service.AppService;
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
                    String searchingTitle = scanner.nextLine().toUpperCase();
                    System.out.println();
                    Book searchingBook= new Book();
                    searchingBook=appService.getTitle(searchingTitle);
                    System.out.println("Szukana przez Ciebie książka zostałą napisana przez "+searchingBook.getAuthor()+ ". Jej gatunek to "+searchingBook.getGenre()+
                            ". Epoka, w której powstała to "+searchingBook.getEpoch() + ". Możesz ją przeczytać pod linkiem "+searchingBook.getUrl());


                    break;

                case 2:
                    System.out.println("Podaj szukanego autora");
                    String searchingAuthor = scanner.nextLine().toUpperCase();
                    Author author=new Author();
                    author=appService.getAuthor(searchingAuthor);
                    System.out.println("Wszystkie ksiązki autora dostępne pod linkiem "+author.getAuthorUrl());
                    break;

                case 3:
                    System.out.println("Podaj interesującą epokę");
                    String searchingEpoch = scanner.nextLine().toUpperCase();
                    Epoch epoch=new Epoch();
                    epoch=appService.getEpoch(searchingEpoch);
                    System.out.println("Wszyskie ksiązki z podanej epoki znajdują się pod linkiem "+epoch.getEpochUrl());

                    break;


                default:
                    System.out.println("Wybrano niepoprawą opcję");
            }


        } catch (NumberFormatException e) {
            System.err.println("Wrong number");
        }

    }


}