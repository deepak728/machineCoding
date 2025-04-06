package model;

public class Queen extends Piece{
    public Queen(String id, COLOR color) {
        super(id, color);
    }

    @Override
    public boolean canMove(Board board, Loc src, Loc dest) {
        if(!super.isValidCoordinate(src,dest)) return false;
        int rowDiff = Math.abs(src.getX()-dest.getX());
        int colDiff = Math.abs(src.getY()-dest.getY());

        return (rowDiff == colDiff) || (rowDiff ==0 || colDiff==0);
    }
}
