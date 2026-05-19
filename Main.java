public class Main {
    public static void main(String[] args) {
        Weapon axe = new Weapon("Battle Axe", 12, 1, 3);
        Weapon bow = new Weapon("Longbow", 8, 15, 2);

        Dwarf dwarf = new Dwarf("Thorin", "Fighter", "Lawful Good",
                25, 40, 35, 16, axe, null);

        Elf elf = new Elf("Elrond", "Wizard", "Neutral Good",
                50, 80, 28, 12, bow, null);

        System.out.println("DWARF CHARACTER:");
        System.out.println(dwarf);

        System.out.println("\nELF CHARACTER:");
        System.out.println(elf);

        System.out.println("\nELF ASSISTS DWARF:");
        elf.assist(dwarf);
        System.out.println(dwarf.getName() + " hit points: " + dwarf.getHitPoints());

        System.out.println("\nDWARF ATTACKS ELF:");
        dwarf.attack(elf);
        System.out.println(elf.getName() + " hit points: " + elf.getHitPoints());
    }
}