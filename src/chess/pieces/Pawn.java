package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		int i = 0;
		int x = 0;
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);
		
		if(getColor() == Color.WHITE) {
			i = -1;
			x = -2;
		}
		else {
			i = 1;
			x = 2;
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

		return mat;
	}
}
