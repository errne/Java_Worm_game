package wormgame.models;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

public class Worm {

    private int x;
    private int y;
    private Direction dir;
    private List<Piece> pieces;
    private boolean growth;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.dir = originalDirection;
        this.pieces = new ArrayList<Piece>();
        Piece head = new Piece(originalX, originalY);
        this.pieces.add(head);
    }

    public Direction getDirection() {
        return this.dir;
    }

    public void setDirection(Direction dir) {
        this.dir = dir;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        int newX = pieces.get(pieces.size() - 1).getX();
        int newY = pieces.get(pieces.size() - 1).getY();

        if (dir == Direction.UP) {
            newY--;
        } else if (dir == Direction.DOWN) {
            newY++;
        } else if (dir == Direction.LEFT) {
            newX--;
        } else if (dir == Direction.RIGHT) {
            newX++;
        }

        if (getLength() > 2 && !growth) {
            pieces.remove(0);
        }
        if (growth = true) {
            growth = false;
        }

        pieces.add(new Piece(newX, newY));
    }

    public void grow() {
        growth = true;
    }

    public boolean runsInto(Piece piece) {
        for (int i = 0; i < getLength(); i++) {
            if (pieces.get(i).getX() == piece.getX() && pieces.get(i).getY() == piece.getY()) {
                return true;
            }
        }

        return false;
    }

    public boolean runsIntoItself() {
        for (int i = 0; i < getLength() - 1; i++) {
            if (wormHead().getX() == pieces.get(i).getX() && wormHead().getY() == pieces.get(i).getY()) {
                return true;
            }
        }

        return false;
    }

    public Piece wormHead() {
        return pieces.get(getLength() - 1);
    }
}