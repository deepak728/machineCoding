package model;

public class Knight extends Piece{

    public Knight(String id, COLOR color) {
        super(id, color);
    }

    @Override
    public boolean canMove(Board board, Loc src, Loc dest) {
        if(!super.isValidCoordinate(src,dest)) return false;
        int rowDiff = Math.abs(src.getX()-dest.getX());
        int colDiff = Math.abs(src.getY()-dest.getY());

        return (rowDiff==1 && colDiff ==2 ) || (rowDiff==2 && colDiff ==1);
    }
}
