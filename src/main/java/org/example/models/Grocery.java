package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("Pazar Arabası Uygulaması");
            System.out.println("0: Çık");
            System.out.println("1: Eleman ekle");
            System.out.println("2: Eleman çıkar");
            System.out.print("Seçiminizi yapın: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Eklemek istediğiniz ürünleri giriniz (virgülle ayırarak): ");
                String addInput = scanner.nextLine();
                addItems(addInput);
            } else if (choice == 2) {
                System.out.print("Çıkarmak istediğiniz ürünleri giriniz (virgülle ayırarak): ");
                String removeInput = scanner.nextLine();
                removeItems(removeInput);
            } else if (choice != 0) {
                System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
            }
        }

        System.out.println("Uygulama sonlandırılıyor.");
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        printSorted();
    }


    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        groceryList = new ArrayList<>(new HashSet<>(groceryList));
        Collections.sort(groceryList);
        System.out.println("Pazar Arabası: " + groceryList);
    }

}
