package tictactoe.be;

public class Player {

    private String name;

    private String finalScore;

    public Player(String name,String score) {
        this.name = name;
        this.finalScore = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return finalScore;
    }

    public void setScore(String score) {
        this.finalScore = score;
    }
}
