public class Entity {
  int hp = 10;
  int attack = 2;

  void attackTarget(Entity target) {
    double randomNum = Math.ceil(Math.random() * 3);
    if (randomNum == 3) {
      System.out.println("HIT ⚔️");
      target.hp -= attack;
    } else {
      System.out.println("Miss 🛡️");
    }
  }

  void heal() {
    hp = 10;
  }

}
