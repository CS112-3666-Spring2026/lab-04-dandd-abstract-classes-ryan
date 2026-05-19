public abstract class GameCharacter {
    private String name;
    private String charClass;
    private String alignment;
    private int gold;
    private int expPoints;
    private int hitPoints;
    private int armorClass;
    private Weapon weapon1;
    private Weapon weapon2;

    public GameCharacter() {
        this("Unknown", "Adventurer", "Neutral", 0, 0, 10, 10, null, null);
    }

    public GameCharacter(String name, String charClass, String alignment,
                         int gold, int expPoints, int hitPoints, int armorClass,
                         Weapon weapon1, Weapon weapon2) {
        if (!setAll(name, charClass, alignment, gold, expPoints,
                hitPoints, armorClass, weapon1, weapon2)) {
            System.out.println("ERROR: bad character data!");
            System.exit(0);
        }
    }

    public GameCharacter(GameCharacter original) {
        if (original == null) {
            System.out.println("ERROR: cannot copy null GameCharacter.");
            System.exit(0);
        }

        setAll(original.name, original.charClass, original.alignment,
                original.gold, original.expPoints, original.hitPoints,
                original.armorClass, original.weapon1, original.weapon2);
    }

    public boolean setAll(String name, String charClass, String alignment,
                          int gold, int expPoints, int hitPoints, int armorClass,
                          Weapon weapon1, Weapon weapon2) {
        if (name != null && name.length() > 0
                && charClass != null && charClass.length() > 0
                && alignment != null && alignment.length() > 0
                && gold >= 0 && expPoints >= 0 && hitPoints >= 0 && armorClass >= 0) {
            this.name = name;
            this.charClass = charClass;
            this.alignment = alignment;
            this.gold = gold;
            this.expPoints = expPoints;
            this.hitPoints = hitPoints;
            this.armorClass = armorClass;
            setWeapon1(weapon1);
            setWeapon2(weapon2);
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        }

        return false;
    }

    public String getCharClass() {
        return charClass;
    }

    public boolean setCharClass(String charClass) {
        if (charClass != null && charClass.length() > 0) {
            this.charClass = charClass;
            return true;
        }

        return false;
    }

    public String getAlignment() {
        return alignment;
    }

    public boolean setAlignment(String alignment) {
        if (alignment != null && alignment.length() > 0) {
            this.alignment = alignment;
            return true;
        }

        return false;
    }

    public int getGold() {
        return gold;
    }

    public boolean setGold(int gold) {
        if (gold >= 0) {
            this.gold = gold;
            return true;
        }

        return false;
    }

    public int getExpPoints() {
        return expPoints;
    }

    public boolean setExpPoints(int expPoints) {
        if (expPoints >= 0) {
            this.expPoints = expPoints;
            return true;
        }

        return false;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean setHitPoints(int hitPoints) {
        if (hitPoints >= 0) {
            this.hitPoints = hitPoints;
            return true;
        }

        return false;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public boolean setArmorClass(int armorClass) {
        if (armorClass >= 0) {
            this.armorClass = armorClass;
            return true;
        }

        return false;
    }

    public Weapon getWeapon1() {
        if (weapon1 == null) {
            return null;
        }

        return new Weapon(weapon1);
    }

    public boolean setWeapon1(Weapon weapon1) {
        if (weapon1 == null) {
            this.weapon1 = null;
        } else {
            this.weapon1 = new Weapon(weapon1);
        }

        return true;
    }

    public Weapon getWeapon2() {
        if (weapon2 == null) {
            return null;
        }

        return new Weapon(weapon2);
    }

    public boolean setWeapon2(Weapon weapon2) {
        if (weapon2 == null) {
            this.weapon2 = null;
        } else {
            this.weapon2 = new Weapon(weapon2);
        }

        return true;
    }

    public abstract void assist(GameCharacter otherCharacter);

    public abstract boolean attack(GameCharacter otherCharacter);

    @Override
    public String toString() {
        return "Name: " + name
                + "\nClass: " + charClass
                + "\nAlignment: " + alignment
                + "\nGold: " + gold
                + "\nExperience: " + expPoints
                + "\nHit points: " + hitPoints
                + "\nArmor class: " + armorClass
                + "\nWeapon 1: " + weapon1
                + "\nWeapon 2: " + weapon2;
    }

    @Override
    public boolean equals(Object other) {
        GameCharacter otherCharacter;

        if (other == null) {
            return false;
        } else if (getClass() != other.getClass()) {
            return false;
        } else {
            otherCharacter = (GameCharacter) other;
            return name.equals(otherCharacter.name)
                    && charClass.equals(otherCharacter.charClass)
                    && alignment.equals(otherCharacter.alignment)
                    && gold == otherCharacter.gold
                    && expPoints == otherCharacter.expPoints
                    && hitPoints == otherCharacter.hitPoints
                    && armorClass == otherCharacter.armorClass
                    && weaponsEqual(weapon1, otherCharacter.weapon1)
                    && weaponsEqual(weapon2, otherCharacter.weapon2);
        }
    }

    private boolean weaponsEqual(Weapon first, Weapon second) {
        if (first == null && second == null) {
            return true;
        } else if (first == null || second == null) {
            return false;
        } else {
            return first.equals(second);
        }
    }
}