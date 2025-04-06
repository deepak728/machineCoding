package dao;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Chess {

    private static Chess instance = null;

    public static GAME_STATE game_state;

    List<Player> players;
    List<Move> moves;

    private Board board;
    public static Player currentPlayer;

    private Chess(){
        players = new ArrayList<>();
        moves = new ArrayList<>();
        board = new Board();
        board.initBoard();
        game_state=GAME_STATE.CREATED;

    }

    public void startGame(Player player1, Player player2){
        players.add(player1);
        players.add(player2);
        currentPlayer = player1;
        game_state = GAME_STATE.STARTED;
    }


    public static Chess getInstance(){
        if(instance==null)
            instance= new Chess();
        return instance;
    }

    public boolean isCheckMate(){
        return false;
    }

    public boolean isStaleMate(){
        return false;
    }

    public boolean isCheck(){
        return false;
    }

    public void gameView(){
        System.out.println(board.toString());
    }

    public void viewHistory(){
        moves.stream().forEach(m -> {
            String captured = "";
            if(m.getCapturedPiece()!=null)
                captured = m.getCapturedPiece().getClass().getSimpleName();
            System.out.println(m.getPlayer().getColor()+", "+m.getSrc().toString()+ " -> "+ m.getDest()+", Captured: "+captured);
        });
    }

    public void switchTurn(){
        if(currentPlayer == players.get(0))
            currentPlayer = players.get(1);
        else
            currentPlayer = players.get(0);
    }

    public boolean validateMove(Loc src, Loc dest){
        Piece srcPiece = board.getPiece(src);
        Piece destPiece = board.getPiece(dest);
        if(srcPiece==null) return false;
        if(srcPiece.getColor()!=currentPlayer.getColor()) return false;
        if(destPiece!=null && destPiece.getColor()==currentPlayer.getColor()) return false;
        return srcPiece.canMove(board,src,dest);
    }

    public void makeMove(Move move){
        Piece srcPiece = board.getPiece(move.getSrc());
        Piece destPiece = board.getPiece(move.getDest());
        if(destPiece instanceof King){
            if(destPiece.getColor()!=currentPlayer.getColor()){
                System.out.println("Game won by "+currentPlayer.getName());
            }
        }

        if(isCheck()){
            System.out.println("Checked by player "+currentPlayer.getName());
        }

        if(isCheckMate()){
            System.out.println("Game won by"+currentPlayer.getName());
        }

        if(isStaleMate()){
            System.out.println("Game staleMate");
        }

        move.setCapturedPiece(destPiece);
        board.setPiece(move.getDest(),srcPiece);
        board.setPiece(move.getSrc(),null);
        moves.add(move);
    }

}
