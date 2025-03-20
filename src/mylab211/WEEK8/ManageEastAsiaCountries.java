package mylab211.WEEK8;

import java.util.*;

public class ManageEastAsiaCountries {
    private ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCountryInformation(EastAsiaCountries country) {
        countryList.add(country);
    }

    public void getRecentlyEnteredInformation() {
        if (countryList.isEmpty()) {
            System.out.println("No countries have been entered yet.");
        } else {
            countryList.get(countryList.size() - 1).display();
        }
    }

    public void searchInformationByName(String name) {
        boolean found = false;
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                country.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Country not found.");
        }
    }

    public void sortInformationByAscendingOrder() {
        Collections.sort(countryList, Comparator.comparing(EastAsiaCountries::getCountryName));
        for (EastAsiaCountries country : countryList) {
            country.display();
        }
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\n1. Enter country information");
            System.out.println("2. Display recently entered country");
            System.out.println("3. Search country by name");
            System.out.println("4. Display countries in ascending order");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inputCountryInformation();
                    break;
                case 2:
                    getRecentlyEnteredInformation();
                    break;
                case 3:
                    System.out.print("Enter country name: ");
                    String name = scanner.nextLine();
                    searchInformationByName(name);
                    break;
                case 4:
                    sortInformationByAscendingOrder();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void inputCountryInformation() {
        System.out.print("Enter country code: ");
        String code = scanner.nextLine();
        System.out.print("Enter country name: ");
        String name = scanner.nextLine();
        float area;
        while (true) {
            System.out.print("Enter total area: ");
            area = scanner.nextFloat();
            if (area > 0) break;
            System.out.println("Total area must be greater than 0. Try again.");
        }
        scanner.nextLine();
        System.out.print("Enter country terrain: ");
        String terrain = scanner.nextLine();

        EastAsiaCountries country = new EastAsiaCountries(code, name, area, terrain);
        addCountryInformation(country);
    }

    public static void main(String[] args) {
        ManageEastAsiaCountries manage = new ManageEastAsiaCountries();
        manage.displayMenu();
    }
}
