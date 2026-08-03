package advent_2022.AoC2;

public class Move {
    private char myMove;
    private char opponentMove;
    public Move(char opponentMove, char myMove){
        this.opponentMove=opponentMove;
        this.myMove=myMove;
    }

    public char getMyMove() {
        return myMove;
    }

    public char getOpponentMove() {
        return opponentMove;
    }
}
