package Balls;

public class PokeBall extends Ball {

    public PokeBall(String name, float catchChance, float useChance, float smallMultiplier, float bigMultiplier) {
        super(name, catchChance, useChance, smallMultiplier, bigMultiplier);
    }

    @Override
    public String toString() {
        return String.format("Poke Ball | [%s]",
          super.toString());
    }
}