package ch.gibm.gfjw.business;

import java.util.ArrayList;

import ch.gibm.gfjw.dto.Coint;

public class MoneyList extends ArrayList{
	
	private ArrayList<Coint> moneyList = new ArrayList<>();
	
	public Coint getProduct(int id){
		return moneyList.get(id);
	}
	
	public ArrayList<Coint> getMoneyList() {
		return moneyList;
	}

	public void deleteCoint(int id){
		moneyList.remove(id);
	}
	
	public Double getTotal(){
		double total = 0;
		for (Coint coint : moneyList) {
			total += coint.getValue();
		}
		return total;
	}
	
	public void addCoint(Coint coint){
		moneyList.add(coint);
	}
}
