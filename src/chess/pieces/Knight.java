package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}
	
	private boolean canMove(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		return p == null || p.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		Position p = new Position(0,0);
				
		for (int i=-2; i<=2 ; i++) {
			for(int j=-2; j<=2 ; j++) {
				
				if (i == 0 || j == 0 ) {
					continue;
				}
				if(i == 1 && j == 1 || i == -1 && j == -1 || i == 1 && j == -1 || i == -1 && j == 1){
					continue;
				}
				if(i == 2 && j == 2 || i == -2 && j == -2 || i == 2 && j == -2 || i == -2 && j == 2){
					continue;
				}
				
				p.setValues(position.getRow() + i, position.getColumn() + j);
				if(getBoard().positionExists(p) && canMove(p)){
					mat[p.getRow()][p.getColumn()] = true;
				}	
			}
		}	
		return mat;
	 }
}
