package Score;

public class Score implements Comparable<Score> {
    private String name;
    private int score;

    // Constructor
    public Score(){
    }

    public Score(String name, int score){
        this.name = name;
        this.score = score;
    }

    // Setter
    public void setName(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    // Getter
    public String getName(){
        return name;
    }
    
    public int getScore(){
        return score;
    }

    // toString
    public String toString(){
        return "Name: " + getName() + "\nScore: " + getScore();
    }
    
    // Method
    public void calculateScore(int roundsWon, int catchBonus){
        score = roundsWon*4000+catchBonus*1000;
    }

    // Comparable interface implementaion, for arrays.sort
    @Override
    public int compareTo(Score otherScore) {
        return Integer.compare(this.score, otherScore.score);
    }

}
