public class Weapon {
    private String name;
    private int damage;
    private int range;
    private int attackBonus;

    public Weapon() {
        this("Basic weapon", 1, 1, 0);
    }

    public Weapon(String name, int damage, int range, int attackBonus) {
        if (!setAll(name, damage, range, attackBonus)) {
            System.out.println("ERROR: bad weapon data!");
            System.exit(0);
        }
    }

    public Weapon(Weapon original) {
        if (original == null) {
            System.out.println("ERROR: cannot copy null Weapon.");
            System.exit(0);
        }

        setAll(original.name, original.damage, original.range, original.attackBonus);
    }

    public boolean setAll(String name, int damage, int range, int attackBonus) {
        if (name != null && name.length() > 0
                && damage >= 0 && range >= 0 && attackBonus >= 0) {
            this.name = name;
            this.damage = damage;
            this.range = range;
            this.attackBonus = attackBonus;
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

    public int getDamage() {
        return damage;
    }

    public boolean setDamage(int damage) {
        if (damage >= 0) {
            this.damage = damage;
            return true;
        }

        return false;
    }

    public int getRange() {
        return range;
    }

    public boolean setRange(int range) {
        if (range >= 0) {
            this.range = range;
            return true;
        }

        return false;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public boolean setAttackBonus(int attackBonus) {
        if (attackBonus >= 0) {
            this.attackBonus = attackBonus;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return name + " [damage=" + damage + ", range=" + range
                + ", attack bonus=" + attackBonus + "]";
    }

    @Override
    public boolean equals(Object other) {
        Weapon otherWeapon;

        if (other == null) {
            return false;
        } else if (!(other instanceof Weapon)) {
            return false;
        } else {
            otherWeapon = (Weapon) other;
            return name.equals(otherWeapon.name)
                    && damage == otherWeapon.damage
                    && range == otherWeapon.range
                    && attackBonus == otherWeapon.attackBonus;
        }
    }
}