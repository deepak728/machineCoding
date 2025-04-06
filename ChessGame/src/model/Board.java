package model;

import java.util.Arrays;

public class Board {
    private Piece[][] board;

    public Board(){
        this.board = new Piece[8][8];
        for(int i=0;i<8;i++){
            Arrays.fill(board[i],null);
        }
    }
    public void initBoard() {
        // Pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn("1" + i, COLOR.BLACK);
            board[6][i] = new Pawn("6" + i, COLOR.WHITE);
        }

        // Rooks
        board[0][0] = new Rook("00", COLOR.BLACK);
        board[0][7] = new Rook("07", COLOR.BLACK);
        board[7][0] = new Rook("70", COLOR.WHITE);
        board[7][7] = new Rook("77", COLOR.WHITE);

        // Knights
        board[0][1] = new Knight("01", COLOR.BLACK);
        board[0][6] = new Knight("06", COLOR.BLACK);
        board[7][1] = new Knight("71", COLOR.WHITE);
        board[7][6] = new Knight("76", COLOR.WHITE);

        // Bishops
        board[0][2] = new Bishop("02", COLOR.BLACK);
        board[0][5] = new Bishop("05", COLOR.BLACK);
        board[7][2] = new Bishop("72", COLOR.WHITE);
        board[7][5] = new Bishop("75", COLOR.WHITE);

        // Queens
        board[0][3] = new Queen("03", COLOR.BLACK);
        board[7][3] = new Queen("73", COLOR.WHITE);

        // Kings
        board[0][4] = new King("04", COLOR.BLACK);
        board[7][4] = new King("74", COLOR.WHITE);
    }


    public Piece[][] getBoard(){
        return board;
    }

    public Piece getPiece(Loc src){
        return board[src.getX()][src.getY()];
    }

    public void setPiece(Loc dest,Piece piece){
        board[dest.getX()][dest.getY()] = piece;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece = board[i][j];
                if (piece == null) {
                    sb.append("- ");
                } else {
                    char symbol;
                    if (piece instanceof Knight) {
                        symbol = 'H';
                    } else {
                        symbol = piece.getClass().getSimpleName().charAt(0);
                    }
                    if (piece.getColor() == COLOR.WHITE) {
                        sb.append(Character.toUpperCase(symbol)).append(" ");
                    } else {
                        sb.append(Character.toLowerCase(symbol)).append(" ");
                    }
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
