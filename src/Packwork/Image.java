package Packwork;


	public class Image extends Dimensions { // al doilea nivel
	    protected int[][] image;
	    private String mesaj;
	    
	    public Image(int[][] image, int width, int height) { //constructor
	        super(width, height);
	        this.image = image;
	    }
	    
	    public int[][] getImage() {
	        return this.image;
	    }
	    // implementare metoda abstracta
	    @Override
	    public void displayDimensions() {
	        System.out.println("Width: " + this.width + " Height: " + this.height);
	    }
	    //POLIMORFISM
	    public void displayDimensions(String mesaj) {
	    	this.mesaj = mesaj;
	    	System.out.println("Width: " + this.width + " Height: " + this.height + this.mesaj);
	        
	    }
	}


