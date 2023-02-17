package Packwork;

public abstract class Dimensions { // prima clasa - abstracta
	
	    protected int width; 
	    protected int height;
	    
	    public abstract void displayDimensions(); // metoda abstracta
	    
	    //metode concrete
	    
	    public Dimensions(int width, int height) { //constructor
	        this.width = width;
	        this.height = height;
	    }
	    
	    public int getWidth() {
	        return this.width;
	    }
	    
	    public void setWidth(int width){
	    	this.width = width;
	    }
	    
	    public int getHeight() {
	        return this.height;
	    }
	    public void setHeight(int height){
	    	this.height = height;
	    }
	

}
