package model;

public class Move {
    private Player player;
    private Loc src;
    private Loc dest;
    private Piece movedPiece;
    private Piece capturedPiece;
    private boolean isCastlingMove;

    public Move(Player player, Loc src, Loc dest) {
        this.player = player;
        this.src = src;
        this.dest = dest;
        this.capturedPiece=null;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Loc getSrc() {
        return src;
    }

    public void setSrc(Loc src) {
        this.src = src;
    }

    public Loc getDest() {
        return dest;
    }

    public void setDest(Loc dest) {
        this.dest = dest;
    }

    public Piece getMovedPiece() {
        return movedPiece;
    }

    public void setMovedPiece(Piece movedPiece) {
        this.movedPiece = movedPiece;
    }

    public Piece getCapturedPiece() {
        return capturedPiece;
    }

    public void setCapturedPiece(Piece capturedPiece) {
        this.capturedPiece = capturedPiece;
    }

    public boolean isCastlingMove() {
        return isCastlingMove;
    }

    public void setCastlingMove(boolean castlingMove) {
        isCastlingMove = castlingMove;
    }

    @Override
    public String toString() {
        return "Move{" +
                "player=" + player +
                ", src=" + src +
                ", dest=" + dest +
                ", movedPiece=" + movedPiece +
                ", capturedPiece=" + capturedPiece +
                ", isCastlingMove=" + isCastlingMove +
                '}';
    }
}
