package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BankSystem {
	
	public static ObservableList<Movement> mvmnts=FXCollections.observableArrayList();
	
	public static double earnings=0;
    
    public static double expenses=0;
    
    public static double totalBalance=0;
    
    public static void setBalanceValues(ObservableList<Movement> lst) {
    	
    	double earningsTotal=0;
    	double expensesTotal=0;
    	for(Movement m: lst) {
    		if(m.getType().equals("Ingreso")) {
    			earningsTotal+=m.getMount();
    		}else if(m.getType().equals("Gasto")){
    			expensesTotal+=m.getMount();
    		}
    	}
    	earnings=earningsTotal;
    	expenses=expensesTotal;
    	totalBalance=earningsTotal-expensesTotal;
    }
}
