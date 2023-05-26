import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class Printer {
    private final Scanner scanner;

    public Printer() {
        scanner = new Scanner(System.in);
    }

    private void printList(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }

    public void printHelloLogin(){
        System.out.println("Etap logowania");
    }

    public int printSelectUser(){
        System.out.println("Wybór użytkownika: ");
        System.out.println("Admin - 1");
        System.out.println("User - 2");
        int user = scanner.nextInt();
        return user;
    }

    public void printCreateAdmin(){
        System.out.println("Zalogowano jako administrator");
    }

    public void printCreateClient(){
        System.out.println("Zalogowano jako użytkowik");
    }
    
    public int printMenuAdmin() {
        List<String> adminMenu = Arrays.asList("1-Utworz mebel", "2-Usun mebel", "3", "4", "5-Wyjscie","0-wyloguj");
        printList(adminMenu);
        int menuNr = scanner.nextInt();
        return menuNr;
    }
        
    public int printMenuClient() {
        List<String> clientMenu = Arrays.asList("1-Kup mebel", "2-Zwroc mebel", "3-Wyswietl dostepne meble", "4", "5-Wyjscie","0-wyloguj");
        printList(clientMenu);
        int menuNr = scanner.nextInt();
        return menuNr;
    }

    public void printCallMenu1(){
        System.out.println("Witaj w menu 1");
    }
    public void printCallMenu2(){
        System.out.println("Witaj w menu2");
    }
    public void printCallMenu3(){
        System.out.println("Witaj w menu3");
    }
    public void printCallMenu4(){
        System.out.println("Witaj w menu4");
    }
    public void printCallMenu5(){
        System.out.println("Zapraszamy ponownie!");
    }
    public void printCallWrong(){
        System.out.println("Witaj w callWrong");
    }

    public void printAdminConstructor(){
        System.out.println("Witaj w AdminConstructor");
    }
    public void printClientConstructor(){
        System.out.println("Witaj w ClientConstructor");
    }

    public String getTypeFromUser() {
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                return "Stół";
            case 2:
                return "Krzesło";
            case 3:
                return "Łóżko";
            case 4:
                return "Szafa";
            case 5:
                return "Komoda";
            default:
                return "Błąd";
        }
    }

    public int getIdFromUser() {
        System.out.println("Podaj id");
        int id = scanner.nextInt();
        return id;
    }
    
    public int getPriceFromUser() {
        System.out.println("Podaj cene");
        int price = scanner.nextInt();
        return price;
    }
    
    public String getColorFromUser() {
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                return "Czarny";
            case 2:
                return "Biały";
            case 3:
                return "Drewno";
            default:
                return "Błąd";
        }
    }
    
    public String getModelFromUser() {
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                return "Raz";
            case 2:
                return "Dwa";
            case 3:
                return "Trzy";
            default:
                return "Błąd";
        }
    }
    
    public void printFurniture(Furniture furniture) {
        System.out.println("Twoj mebel to: \n");
        System.out.println("Rodzaj: " + furniture.type);
        System.out.println("Model: " + furniture.model);
        System.out.println("Kolor: " + furniture.color);
        System.out.println("Cena: " + furniture.price);
        System.out.println("ID: " + furniture.id + "\n");
    }
    
    public boolean printFurniturePrice(Furniture furniture) {
        System.out.println("Cena twojego mebla to: " + furniture.price);
        System.out.println("Wpisz tak jesli chcesz kupic mebel");
        String input = scanner.next();
        return input.equals("tak");
    }
    
    public void printFurnitureId(Furniture furniture) {
        System.out.println("Dziekujemy za zakup!\n");
        System.out.println("ID mebla potrzebne do zwrotu to: " + furniture.id + "\n");
    }

    public void printFurnitureNotFound(){
        System.out.println("Nie znaleziono mebla");
    }

    public void printChooseFurniture(){
        System.out.println("Jaki mebel chcesz wybrać?");
        System.out.println("Stół - 1");
        System.out.println("Krzeszło - 2");
        System.out.println("Łóżko - 3");
        System.out.println("Szafa - 4");
        System.out.println("Komoda - 5");
    }

    public void printChooseTable(){
        System.out.println("Wybierz model");
        System.out.println("Pierwszy - 1");
        System.out.println("Drugi - 2");
        System.out.println("Trzeci - 3");
    }

    public void printChooseChair(){
        System.out.println("Wybierz model");
        System.out.println("Pierwszy - 1");
        System.out.println("Drugi - 2");
        System.out.println("Trzeci - 3");
    }

    public void printChooseBed(){
        System.out.println("Wybierz model");
        System.out.println("Pierwszy - 1");
        System.out.println("Drugi - 2");
        System.out.println("Trzeci - 3");
    }

    public void printChooseWardobe(){
        System.out.println("Wybierz model");
        System.out.println("Pierwszy - 1");
        System.out.println("Drugi - 2");
        System.out.println("Trzeci - 3");
    }

    public void printChooseDresser(){
        System.out.println("Wybierz model");
        System.out.println("Pierwszy - 1");
        System.out.println("Drugi - 2");
        System.out.println("Trzeci - 3");
    }

    public void printChooseColor(){
        System.out.println("Wybierz kolor");
        System.out.println("Czarny - 1");
        System.out.println("Biały - 2");
        System.out.println("Drewno - 3");
    }

    public void printBadChoice(){
        System.out.println("Zły wybór");
    }

    public void printLogout(){
        System.out.println("Wylogowano");
    }
    public void printInvalidLogin(){
        System.out.println("Złe dane logowania!");
    }
    public void userAlreadyLogged(Client user){
        System.out.println("Witamy ponownie " + user.getUsername() + "!");
    }
    public void printLogin(){
        System.out.println("Podaj login: ");
    }
    public void printPassword(){
        System.out.println("Podaj hasło: ");
    }
    public void printHelloClient(Client user){
        System.out.println("Cześć " + user.getUsername() + "!");
    }
    public void printHelloAdmin(Admin admin){
        System.out.println("Admin: "+ admin.getUsername()+ "!");
    }
}