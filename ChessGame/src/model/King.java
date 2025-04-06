package model;

public class King extends Piece{
    public King(String id, COLOR color) {
        super(id, color);
    }

    @Override
    public boolean canMove(Board board, Loc src, Loc dest) {
        if(!super.isValidCoordinate(src,dest)) return false;
        int rowDiff = Math.abs(src.getX()-dest.getX());
        int colDiff = Math.abs(src.getY()-dest.getY());
        return rowDiff<=1 && colDiff <=1;
    }
}
