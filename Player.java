public class Player extends Entity {

  String[] quotes = {
    "Hyaa! ⚔️",
    "OwO Die! 💀",
    "Tits!"
  };
  int reputation = 0;
  int stamina = 10;
  int gold = 0;
  Weapon main_hand;
  String name;
  Item inventoryHead;

  Player(String inputName) {
    name = inputName;
  }

  void specialAttack(Monster target) {
    if (stamina > 0) {
      stamina -= 5;
      target.hp -= 5;
    } else {
      System.out.println("Your stamina is too low to do this. Go home!");
    }
  }

  void attackTarget(Monster target) {
    int chance;
    if (main_hand != null) {
      chance = 2;
    } else {
      chance = 3;
    }

    double randomNum = Math.ceil(Math.random() * chance);
    if (randomNum == 3) {
      System.out.println("HIT ⚔️");
      if (main_hand != null) {
        target.hp -= attack + main_hand.power;
      } else {
        target.hp -= attack;
      }
    } else {
      System.out.println("Miss 🛡️");
    }
  }

  void quote() {
    int randomNum = (int)Math.floor(Math.random() * 3);
    System.out.println(quotes[randomNum]);
  }

  void equip(Weapon weapon) {
    main_hand = weapon;
  }

  void unequip() {
    main_hand = null;
  }

  void showCharacter() {
    System.out.print("\033\143");
    System.out.printf("name: %s\n", name);
    System.out.printf("attack: %s\n", attack);
    System.out.printf("hp: %s\n", hp);
    System.out.printf("stamina: %s\n", stamina);
    System.out.printf("gold: %s\n", gold);
    System.out.printf("reputation: %s\n", reputation);
    if (main_hand != null) {
      System.out.printf("weapon: %s\n", main_hand.name);
    }
    System.out.println();
    System.out.println("==============");
    System.out.println();
  }

  // void addToBag(Item a) {

  // }

}
