public class Move {
    int steps;
    char direction;

    public Move(char direction, int move) {
        this.direction = direction;
        this.steps = move;
    }

    @Override
    public String toString() {
        return direction + " " + steps;
    }
}
