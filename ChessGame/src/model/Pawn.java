package model;

public class Pawn extends Piece{
    public Pawn(String id, COLOR color) {
        super(id, color);
    }

    @Override
    public boolean canMove(Board board, Loc src, Loc dest) {
        if(!super.isValidCoordinate(src,dest)) return false;
        int rowDiff = src.getX()-dest.getX();
        int colDiff = src.getY()-dest.getY();
        Piece target = board.getPiece(dest);

        if(this.color==COLOR.BLACK){
            if(target==null)
                return colDiff ==0 && rowDiff == -1;

            return Math.abs(colDiff) ==1 && rowDiff == -1;

        }else {
            if(target==null)
                return colDiff ==0 && rowDiff == 1;

            return Math.abs(colDiff) ==1 && rowDiff == 1;
        }
    }

}
