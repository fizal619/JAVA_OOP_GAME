import java.util.Scanner;
import java.lang.Thread;

public class Main {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("\033\143");
    System.out.print("\n");

    System.out.println("Please enter a name:");
    Player player1 = new Player(input.nextLine());

    int score = 0;

    String userInput = "";

    while (!userInput.equals("0")) {
      System.out.print("\033\143");
      System.out.printf("\nHi %s\n", player1.name);
      System.out.println("Welcome to Battle Kingdom 🏰");
      System.out.println("----------------------------");
      System.out.println("Please select an option or enter 0 to quit");
      System.out.println("1 - CHARACTER 🧑");
      System.out.println("2 - FIGHT 🥊");
      userInput = input.nextLine();

      switch(userInput){
        case ("1"):
          player1.showCharacter();
          break;
        case ("2"):
          String result = fight(player1);
          if (result.equals("player_died")) {
            System.out.println("You dead.");
            System.exit(0);
          }
          if (result.equals("monster_died")) {
            score++;
          }
          break;
      }

    }
    input.close();
  }

  // keep game logic in Main
  // Keep logic that affects objects in their classes
  static String fight(Player player1) {
    Scanner input = new Scanner(System.in);
    String userInput = "";
    Monster monster1 = new Monster();
    System.out.printf("\nA %s appears!\n", monster1.species);

    while (player1.hp > 0 && monster1.hp > 0) {
      System.out.print("\033\143");
      System.out.println();
      System.out.printf("Player: %shp\n", player1.hp);
      System.out.printf("%s: %shp\n", monster1.species, monster1.hp);
      System.out.println();
      System.out.println("1 - ATTACK ⚔️🛡️");
      System.out.println("2 - SPECIAL ATTACK 🔥");
      System.out.println("3 - FLEE 🏃‍♂️💨");
      userInput = input.nextLine();

      if (userInput.equals("1")) {
        System.out.println("Player Attacks");
        player1.attackTarget(monster1);
        System.out.println("Monster Attacks");
        monster1.attackTarget(player1);
      }

      if (userInput.equals("2")) {
        System.out.println("Player Special Attacks");
        player1.specialAttack(monster1);
      }

      if (userInput.equals("3")) {
        break;
      }

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    input.close();

    if (userInput.equals("3")) {
      return "player_fled";
    }
    if (player1.hp <= 0) {
      return "player_died";
    }

    System.out.printf("You slayed the %s.", monster1.species);
    return "monster_died";
  }


}
