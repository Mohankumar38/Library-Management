import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    boolean isIssued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isIssued = false;
    }
}

public class Library {

    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    books.add(new Book(id, title));
                    System.out.println("Book Added!");
                    break;

                case 2:
                    for (Book b : books) {
                        System.out.println("ID: " + b.id +
                                ", Title: " + b.title +
                                ", Issued: " + (b.isIssued ? "Yes" : "No"));
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = sc.nextInt();

                    for (Book b : books) {
                        if (b.id == issueId && !b.isIssued) {
                            b.isIssued = true;
                            System.out.println("Book Issued!");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}