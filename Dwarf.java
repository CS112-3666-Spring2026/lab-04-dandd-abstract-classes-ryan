public class Dwarf extends GameCharacter {
    public Dwarf() {
        super();
    }

    public Dwarf(String name, String charClass, String alignment,
                 int gold, int expPoints, int hitPoints, int armorClass,
                 Weapon weapon1, Weapon weapon2) {
        super(name, charClass, alignment, gold, expPoints, hitPoints,
                armorClass, weapon1, weapon2);
    }

    public Dwarf(Dwarf original) {
        super(original);
    }

    @Override
    public void assist(GameCharacter otherCharacter) {
        if (otherCharacter != null) {
            otherCharacter.setArmorClass(otherCharacter.getArmorClass() + 2);
            System.out.println(getName() + " reinforced " + otherCharacter.getName() + "'s armor.");
        }
    }

    @Override
    public boolean attack(GameCharacter otherCharacter) {
        Weapon weapon;
        int damage;

        if (otherCharacter == null || otherCharacter.getHitPoints() == 0) {
            return false;
        }

        weapon = getWeapon1();

        if (weapon == null) {
            damage = 1;
        } else {
            damage = weapon.getDamage() + weapon.getAttackBonus() - otherCharacter.getArmorClass() / 5;
        }

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