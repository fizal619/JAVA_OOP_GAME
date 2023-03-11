import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("\033\143");
    System.out.print("\n");

    System.out.println("Please enter a name:");
    Player player1 = new Player(input.nextLine());

    System.out.printf("\nHi %s\n", player1.name);
    System.out.println("Welcome to Battle Kingdom 🏰");
    String userInput = "";

    while (!userInput.equals("0")) {
      System.out.println("Please select an option or enter 0 to quit");
      System.out.println("1 - CHARACTER 🧑");
      System.out.println("2 - FIGHT 🥊");
      userInput = input.nextLine();

      switch(userInput){
        case ("1"):
          player1.showCharacter();
          break;
      }

    }
    input.close();
  }



}
