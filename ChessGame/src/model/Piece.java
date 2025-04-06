package model;

public abstract class Piece {
    String id;
    COLOR color;

    public abstract boolean canMove(Board board, Loc src, Loc dest);

    public Piece(String id, COLOR color) {
        this.id = id;
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }

    public void setColor(COLOR color) {
        this.color = color;
    }

    public boolean isValidCoordinate(Loc src, Loc dest){
        if(src.getX()<0||src.getX()>=8 || src.getY()<0||src.getY()>=8) return false;
        if(dest.getX()<0||dest.getX()>=8 || dest.getY()<0||dest.getY()>=8) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "id='" + id + '\'' +
                ", color=" + color +
                '}';
    }
}
