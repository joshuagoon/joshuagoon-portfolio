package Balls;
public class Ball {

    private String name;
    private float catchChance;
    private float useChance;
    private float smallMultiplier;
    private float bigMultiplier;

    public Ball(){
        this.name = "Pokeball";
        this.catchChance = 0.5f;
        this.useChance = 0.5f;
        this.smallMultiplier = 0.0f;
        this.bigMultiplier = 0.0f;
    }

    public Ball(String name, float catchChance, float useChance, float smallMultiplier, float bigMultiplier) {
        this.name = name;
        this.catchChance = catchChance;
        this.useChance = useChance;
        this.smallMultiplier = smallMultiplier;
        this.bigMultiplier = bigMultiplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCatchChance() {
        return catchChance;
    }

    public void setCatchChance(float catchChance) {
        this.catchChance = 1.0f;
    }

    public float getUseChance() {
        return useChance;
    }

    public void setUseChance(float useChance) {
        this.useChance = 0.0f;
    }

    public float getSmallMultiplier(){
        return smallMultiplier;
    }

    public void setSmallMultiplier(float smallMultiplier){
        this.smallMultiplier = 1.0f;
    }

    public float getBigMultiplier(){
        return bigMultiplier;
    }

    public void setBigMultiplier(float bigMultiplier){
        this.bigMultiplier = 1.0f;
    }

    @Override
    public String toString() {
        return "name = " + name + ", catchChance = " + catchChance + ", useChance = " + useChance;
    }

    public boolean ballCalculation(int grade, float useChance, float catchChance, float smallMultiplier, float bigMultiplier){
        if (grade == 1) {
            catchChance = catchChance * smallMultiplier;
            return true;
        }
        if (grade == 2 || grade == 3) {
            catchChance = getCatchChance() * bigMultiplier;
            return true;
        } 
        else {
            return false;
        }
    }
}