package Packwork;

public class NormalizeColors extends Image { //al treilea nivel de mostenire
	
	
	static{ 
		System.out.println("S-a inceput normalizare"); //bloc static de initializare
	}
	
	
	public NormalizeColors(int[][] image, int width, int height) {  //constructor
		super(image, width, height);
	}
	

	
	public void normalize() {
		
		int red = 0;
		int green = 0;
		int blue = 0;
		int sum = 0;
		
		//metoda cu min si max 
		
		/* red = (this.image[0][0] >> 16) ; //iau valoarea de pe fiecare bit shiftand ul
		green = (this.image[0][0] >> 8) ;
		blue = (this.image[0][0]) ;
		
		int newMin = 0;   // sa zicem ca normalizam spre valorile acestea
		int newMax = 255;
		
		int maxRed = red;
		int maxGreen = green;
		int maxBlue = blue;
		
		int minRed = red;
		int minGreen = green;
		int minBlue = blue;
												//calculez min si max pt fiecare valoare
		for(int r = 0; r < this.height; r++){
			for(int c = 0; c <this.width; c++){
				
				red = (this.image[r][c] >> 16) ;
				green = (this.image[r][c] >> 8) ;
				blue = (this.image[r][c]) ;
				
				if (red > maxRed) {
					maxRed = red;
				}
				if (green > maxGreen) {
					maxGreen = green;
				}
				if (blue > maxBlue) {
					maxBlue = blue;
				}	
				if (red < minRed) {
					minRed = red;
				}
				if (green < minGreen) {
					minGreen = green;
				}
				if (blue < minBlue) {
					minBlue = blue;
				}			
			}
		}
		
		for(int r = 0; r < this.height; r++) {
			for(int c = 0; c < this.width; c++) {
				red = (this.image[r][c] >> 16) ;
				green = (this.image[r][c] >> 8) ;
				blue = (this.image[r][c]) ;
				// System.out.println(red + ", " + green + ", " + blue);
				red = (red-minRed)*((newMax-newMin)/(maxRed-minRed)) + newMin;
				green = (green-minGreen)*((newMax-newMin)/(maxGreen-minGreen)) + newMin;
				blue = (blue-minBlue)*((newMax-newMin)/(maxBlue-minBlue)) + newMin;
						
				this.image[r][c] = (red << 16) + (green << 8) + blue;
			}
		} */
			// metoda Grey World 
		for(int r = 0; r < this.height; r++) {
			for(int c = 0; c < this.width; c++) {
				red = (this.image[r][c] >> 16) % (int)Math.pow(2, 8);
				green = (this.image[r][c] >> 8) % (int)Math.pow(2, 8);
				blue = (this.image[r][c]) % (int)Math.pow(2, 8);
				// System.out.println(red + ", " + green + ", " + blue);
				sum = red + green + blue;
				red = (int)Math.floor(255 * ((double)red / (double)sum));
				green = (int)Math.floor(255 * ((double)green / (double)sum));
				blue = (int)Math.floor(255 * ((double)blue / (double)sum));
				// System.out.println(red + ", " + green + ", " + blue);
				this.image[r][c] = (red << 16) + (green << 8) + blue;
			}
		}
	}
}
