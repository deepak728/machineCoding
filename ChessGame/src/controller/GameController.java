package controller;

import dao.Chess;
import model.Loc;
import model.Move;
import model.Player;

public class GameController {

    Chess chess;

    public GameController(){
        chess = Chess.getInstance();
    }
    public void start(Player p1,Player p2){
        chess.startGame(p1,p2);
    }

    public void makeMove(Player player, Loc src , Loc dest){
        if(Chess.currentPlayer!=player){
            System.out.println("Wrong player move");
            return;
        }

        if(!chess.validateMove(src,dest)){
            System.out.println("Invalid move by "+player.getColor() +" "+ src + " -> "+dest);
            return;
        }
        Move move = new Move(player,src,dest);
        chess.makeMove(move);

        chess.switchTurn();
    }

    public void gameView(){
        chess.gameView();
    }

    public void viewHistory(){
        chess.viewHistory();
    }
}
