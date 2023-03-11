public class Monster extends Entity {

  int villainy = 0;
  int loot;
  String species;

  Monster(String speciesName) {
    species = speciesName;
    loot = 3 + (int)Math.floor(Math.random() * 7);
  }

  Monster() {
    String[] speciesOptions = {
      "Goblin",
      "Slime",
      "Minotaur"
    };
    species = speciesOptions[(int)Math.floor(Math.random() * 3)];

    loot = 3 + (int)Math.floor(Math.random() * 7);
  }

}
