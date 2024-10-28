package Pokemon;

public class WaterPokemon extends Pokemon {

    //Constructors
    public WaterPokemon(String name, String status, String type, int grade, int health, int damage) {
        super(name, status, type, grade, health, damage);
    }
  
    //toString
    @Override
    public String toString() {
        return String.format("Water Pokemon | [%s]",
            super.toString());
    }

    //Method
    public void attackEffect(Pokemon opponent) {
        if ("Caught".equals(this.getStatus()) && "Wild".equals(opponent.getStatus())) {    	
            switch (opponent.getType()) {
            case "Water": // Normal damage
                System.out.println("Same type, no damage increase.");
                break;
            case "Fire": // Increase damage by 50%
                int increasedDamage = (int) (this.getDamage() * 1.5);
                super.setDamage(increasedDamage);
                System.out.println("Increased damage by 50% against opponent " + opponent.getName() + " (Weak to Water)!");
                break;
            case "Grass": // Decrease damage by 50% 
                int decreasedDamage = (int) (this.getDamage() * 0.5);
                super.setDamage(decreasedDamage);
                System.out.println("Decreased damage by 50% against opponent " + opponent.getName() + " (Resistant to Water)!");
                break;
            default:
                break;
            }
        }
    }

    @Override
    public void attack(Pokemon opponent) {
        attackEffect(opponent);
        super.attack(opponent);
    }
}
