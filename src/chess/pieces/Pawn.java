package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color,ChessMatch chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		int i= 0 ,x = 0, z = 0;
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		if(getColor() == Color.WHITE) {
			i = -1;
			x = -2;
			z = 3;
		}
		else {
			i = 1;
			x = 2;
			z = 4;
		}
		
		p.setValues(position.getRow() + i, position.getColumn());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		p.setValues(position.getRow() + x, position.getColumn());
		Position p2 = new Position(position.getRow() + i, position.getColumn());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		p.setValues(position.getRow() + i, position.getColumn() + i);
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		p.setValues(position.getRow() + i, position.getColumn() - i);
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		if(position.getRow() == z) {
			Position left = new Position(position.getRow(), position.getColumn() + 1);
			if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
				mat[left.getRow() + i][left.getColumn()]= true;
			}
			Position right = new Position(position.getRow(), position.getColumn() - 1);
			if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
				mat[left.getRow() + i][left.getColumn()]= true;
			}
						
		}

		return mat;
	}
}
