package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0,0);

		for (int i=-1; i<=1 ; i++) {
			for(int j=-1; j<=1 ; j++) {
				
				if (i == 0 || j == 0) {
					continue;
				}
				
				p.setValues(position.getRow() + i, position.getColumn() + j);
				while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
						mat[p.getRow()][p.getColumn()] = true;
						p.setValues(p.getRow() + i, p.getColumn() + j);
				}
				if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
					mat[p.getRow()][p.getColumn()] = true;
				}
			}
		}	
		return mat;
	}

}
