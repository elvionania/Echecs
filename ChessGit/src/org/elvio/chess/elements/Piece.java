package org.elvio.chess.elements;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

	protected static final String valeurBinaire = "";
	
	public static final byte BLANC = (new Integer(Integer.parseInt("10000000",2))).byteValue();
	public static final byte NOIR = (new Integer(Integer.parseInt("00000000",2))).byteValue();
	
	protected byte value = (new Integer(Integer.parseInt(valeurBinaire,2))).byteValue();
	
	public Piece(byte couleur) {
		setValue(couleur);
	}

	public byte getValue() {
		return value;
	}
	
	public void setValue(byte couleur){
		value = (byte) (value & couleur);
	}

	public Piece() {
		super();
	}
	
	protected abstract List<byte[]> getPositionsJouables(Board board);
	
	/**
	 * lister les positions jouables sur une ligne par la piece a partir d elle
	 * @param board
	 * @return
	 */
	protected abstract List<byte[]> getCheminsJouables(byte[] maPosition, Board board);
	
	protected List<byte[]> getPositionsLibreSurUnChemin(List<byte[]> positionsDUnChemin, Board board){
		ArrayList<byte[]> positionsJouablesSurLeChemin = new ArrayList<byte[]>();
		
		for(byte[] position : positionsDUnChemin){
			if(board.getPieceAtPosition(position) == null){
				positionsJouablesSurLeChemin.add(position);
			}else if (!isMemeCouleur(board.getPieceAtPosition(position))){
				positionsJouablesSurLeChemin.add(position);
				break;
			}else{
				break;
			}
		}
		
		return positionsJouablesSurLeChemin;
	}
	
	public boolean isMemeCouleur(Piece piece){
		if((value & BLANC) == (piece.getValue() & BLANC)){
			return true;
		}
		return false;			
	}

}