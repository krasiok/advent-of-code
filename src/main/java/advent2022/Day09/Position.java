public class Position {
    int x;
    int y;
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (!(obj instanceof Position)) return false;
        Position pos = (Position) obj;
        return this.x == pos.x && this.y == pos.y;
    }

    @Override
    public int hashCode(){
        return 31 * x + y;
    }
}
