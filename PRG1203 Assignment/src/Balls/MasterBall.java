package Balls;

public class MasterBall extends Ball {

    public MasterBall(String name, float catchChance, float useChance, float smallMultiplier, float bigMultiplier){
        super(name, catchChance, useChance, smallMultiplier, bigMultiplier);
    }

    @Override
    public String toString() {
        return String.format("Master Ball | [%s]",
          super.toString());
    }
}
