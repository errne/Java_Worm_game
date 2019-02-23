package wormgame.models;

public class Piece {
    int x;
    int y;

    public Piece(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean runsInto(Piece piece){
        if (piece.getX() == this.x && piece.getY() == this.y){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}