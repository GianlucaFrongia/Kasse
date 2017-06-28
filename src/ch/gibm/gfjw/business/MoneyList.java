package ch.gibm.gfjw.business;

import java.util.ArrayList;

import ch.gibm.gfjw.dto.Coint;

/**
 * Speichert alle Geldstücke in einem Array und verwaltet diesen.
 * 
 * 
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */

public class MoneyList{
	
	/**
	 * Neuer Arraylist für das bekommene Gelt.
	 */
	private ArrayList<Coint> moneyList = new ArrayList<>();
	
	/**
	 * Gibt eine Muenze nach ID aus.
	 * @param id der gewünschten Muenze.
	 * @return Eine Coint Objekt der gewuenschten Muenze.
	 */
	public Coint getCoint(int id){
		return moneyList.get(id);
	}
	
	/**
	 * Gibt alle Coint Objekte in diesem ArrayList aus.
	 * @return ArrayList aller Objekte.
	 */
	public ArrayList<Coint> getMoneyList() {
		return moneyList;
	}

	/**
	 * Loescht eine Coint Objekt aus der Liste.
	 * @param id ID des gewuenschten Coint Objekt.
	 */
	public void deleteCoint(int id){
		moneyList.remove(id);
	}
	
	 /**
	  * Berechnet den bekommen Betrag.
	  * @return Total
	  */
	public Double getTotal(){
		double total = 0;
		for (Coint coint : moneyList) {
			total += coint.getValue();
		}
		return total;
	}
	
	/**
	 * Fuegt ein Cointobjekt hinzu.
	 * @param coint Cointobjekt das hinzugefuegt werden soll.
	 */
	public void addCoint(Coint coint){
		moneyList.add(coint);
	}
}
