package org.elvio.chess.elements;

import java.util.ArrayList;
import java.util.List;

public class Pion extends Piece {
	
	static final String valeurBinaire = "01000000";
	
	public Pion(byte couleur) {
		setValue(couleur);
	}

	@Override
	protected List<byte[]> getPositionsJouables(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected List<byte[]> getCheminsJouables(byte[] maPosition, Board board) {
		List<byte[]> cheminsJouables = new ArrayList<byte[]>();
		if(board.isEnPositionInitial(this)){
			cheminsJouables.add(board.getPosition(maPosition, 0, 1));
			cheminsJouables.add(board.getPosition(maPosition, 0, 2));
		}
		return null;
	}

}
