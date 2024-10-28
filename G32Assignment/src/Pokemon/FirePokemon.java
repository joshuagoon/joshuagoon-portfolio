package Pokemon;

public class FirePokemon extends Pokemon {
  
	//Constructors
	public FirePokemon(String name, String status, String type, int grade, int health, int damage) {
		super(name, status, type, grade, health, damage);
	}

	//toString
	@Override
	public String toString() {
		return String.format("Fire Pokemon | [%s]",
			super.toString());
	}

	//Method
	public void attackEffect(Pokemon opponent) {
		if ("Caught".equals(this.getStatus()) && "Wild".equals(opponent.getStatus())) {    	
			switch (opponent.getType()) {
			case "Fire": // Normal damage
				System.out.println("Same type, no damage increase.");
				break;
			case "Grass": // Increase damage by 50%
				int increasedDamage = (int) (this.getDamage() * 1.5);
				super.setDamage(increasedDamage);
				System.out.println("Increased damage by 50% against opponent " + opponent.getName() + " (Weak to Fire)!");
				break;
			case "Water": // Decrease damage by 50% 
				int decreasedDamage = (int) (this.getDamage() * 0.5);
				super.setDamage(decreasedDamage);
				System.out.println("Decreased damage by 50% against opponent " + opponent.getName() + " (Resistant to Fire)!");
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
