package ch.gibm.gfjw.data;
/**
 * ProductFactory Klasse
 * Ist ein Singleton
 * Erstell Objekte von ProductData und ProductLogData
 * @author Gianluca Frongia und Joel Weissenberger
 * @version 1.0
 */
public class ProductFactory {
	private static ProductFactory instance;
	  
	private ProductFactory() {
	}
	
	/***
	 * @return ProductData Object
	 * */
	public ProductDao createProductDao(){
		return new ProductData();
	};
	
	
	/***
	 * @return ProductLogData Object
	 * */
	public ProductLogDAO createProdctLogDAO(){
		return new ProductLogData();
	};
	/***
	 * @return ProductFactory instance
	 * */
	public static ProductFactory getInstance(){
		if(instance == null){
			instance = new ProductFactory();
		} 
		return instance;};
	

}
