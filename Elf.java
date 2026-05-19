public class Elf extends GameCharacter {
    public Elf() {
        super();
    }

    public Elf(String name, String charClass, String alignment,
               int gold, int expPoints, int hitPoints, int armorClass,
               Weapon weapon1, Weapon weapon2) {
        super(name, charClass, alignment, gold, expPoints, hitPoints,
                armorClass, weapon1, weapon2);
    }

    public Elf(Elf original) {
        super(original);
    }

    @Override
    public void assist(GameCharacter otherCharacter) {
        if (otherCharacter != null) {
            otherCharacter.setHitPoints(otherCharacter.getHitPoints() + 5);
            System.out.println(getName() + " healed " + otherCharacter.getName() + " for 5 hit points.");
        }
    }

    @Override
    public boolean attack(GameCharacter otherCharacter) {
        int damage;

        if (otherCharacter == null || otherCharacter.getHitPoints() == 0) {
            return false;
        }

        damage = 8 + getExpPoints() / 10 - otherCharacter.getArmorClass() / 5;

        if (damage < 1) {
            damage = 1;
        }

        if (damage >= otherCharacter.getHitPoints()) {
            otherCharacter.setHitPoints(0);
            return false;
        }

        otherCharacter.setHitPoints(otherCharacter.getHitPoints() - damage);
        return true;
    }
}