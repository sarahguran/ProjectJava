package Packwork;

public class Pixel implements Buffer { //permite comunicarea intre producer si consumer
	
	private int pix;  //valoarea pixelului
	private boolean available; //daca este disponibil pt a fi citit sau scris in buffer
	
	{
		this.available = false;  //bloc de initializare
	}
	
	public Pixel() {   //constructor fara parametrii
		this.pix = 0;
	
	} 
	
	public synchronized int get() {
		while(!available) {
			try {
				wait();
			} catch (InterruptedException e) {   //tratarea exceptiilor
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return this.pix;
	}
	
	public synchronized void put(int ... pix) { //argumente variabile
		while(available) {
			try {
				wait();
			} catch (InterruptedException e) { //tratarea exceptiilor
				e.printStackTrace();
			}
		}
		if(pix.length > 2) {
			int red = 0;
			int green = 0;
			int blue = 0;
			
			if(pix[0] < 0) {
				red = 0;
			} else if (pix[0] > 255) {
				red = 255;
			} else {
				red = pix[0];
			}
			
			if(pix[1] < 0) {
				green = 0;
			} else if (pix[1] > 255) {
				green = 255;
			} else {
				green = pix[1];
			}
			
			if(pix[2] < 0) {
				blue = 0;
			} else if (pix[2] > 255) {
				blue = 255;
			} else {
				blue = pix[2];
			}
			
			this.pix = (red << 16) + (green << 8) + blue;
			
		} else if (pix.length > 0){
			this.pix = pix[0];
		} else {
			this.pix = 0;
		}
		
		
		available = true;
		notifyAll();
	}
}
