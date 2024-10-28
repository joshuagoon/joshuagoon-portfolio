package Score;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TopScore {
    //private Score[] topScore;
    private ArrayList<Score> topScore = new ArrayList<>();
        
    //Constructor
    public TopScore() {
    }

    //1 score
    public TopScore(Score s1) {
        topScore.add(s1);
    }

    //2 scores
    public TopScore(Score s1, Score s2) {
        topScore.add(s1);
        topScore.add(s2);
    }

    //3 scores
    public TopScore(Score s1, Score s2,Score s3) {
        topScore.add(s1);
        topScore.add(s2);
        topScore.add(s3);
    }

    //4 scores
    public TopScore(Score s1, Score s2,Score s3,Score s4) {
        topScore.add(s1);
        topScore.add(s2);
        topScore.add(s3);
        topScore.add(s4);
    }

    //5 scores
    public TopScore(Score s1, Score s2,Score s3,Score s4,Score s5) {
        topScore.add(s1);
        topScore.add(s2);
        topScore.add(s3);
        topScore.add(s4);
        topScore.add(s5);
    }

    //toString
    public String toString() {
        StringBuilder result = new StringBuilder("TopScore \n");
        for (Score score : topScore){
            if (score != null){
                result.append(score).append("\n\n");
            }
        }
        result.append("]");
        return result.toString();
    }

    //Add Score Method
    public void addScore(Score s) {
        topScore.add(s);
        Collections.sort(topScore,Collections.reverseOrder());
        if (topScore.size() > 5) {          
            int index = topScore.size() - 1;
            topScore.remove(index);
        }
    }

    //Read File Method
    public void readFile() {
        // Score File
        String filePath = "score.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Read each line of the file
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into name and score based on the comma
                String[] parts = line.split(",");

                // Assuming parts[0] is the name and parts[1] is the score
                String name = parts[0].trim();
                int score = Integer.parseInt(parts[1].trim());

                Score scoreInstance = new Score(name, score);
                addScore(scoreInstance);
            }
        } catch (IOException e) {
            // Handle IOException, e.g., print an error message or log the exception
            e.printStackTrace();
        }
    }

    //Write to the File
    public void Store() {
        String filePath = "path/to/output.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Score score : topScore) {
                writer.write(score.getName() + "," + score.getScore() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}