package Balls;

public class UltraBall extends Ball {

    public UltraBall(String name, float catchChance, float useChance, float smallMultiplier, float bigMultiplier){
        super(name, catchChance, useChance, smallMultiplier, bigMultiplier);
    }

    @Override
    public String toString() {
        return String.format("Ultra Ball | [%s]",
          super.toString());
    }
}