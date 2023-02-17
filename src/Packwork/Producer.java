package Packwork;
import java.awt.image.BufferedImage;

public class Producer extends Thread {
		
	private BufferedImage image; //imaginea din care se ia informatia
	private Pixel buffer; //bufferul prin care se face comunicare
	
	public Producer(Pixel buffer, BufferedImage image) {
		this.buffer = buffer;
		this.image = image;
	}
	
	public void run() {
		
		System.out.println("Se incepe citirea primului sfert...");
		for(int r = 0; r < this.image.getHeight() / 2; r ++) {
			for(int c = 0; c < this.image.getWidth() / 2; c ++) {
				this.buffer.put(this.image.getRGB(c, r));
				//System.out.println(this.image.getRGB(c, r));
			}
		}
		System.out.println("S-a terminat citirea primului sfert");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Se incepe citirea celui de-al doilea sfert...");
		for(int r = 0; r < this.image.getHeight() / 2; r ++) {
			for(int c = this.image.getWidth() / 2; c < this.image.getWidth(); c ++) {
				this.buffer.put(this.image.getRGB(c, r));
			}
		}
		System.out.println("S-a terminat citirea celui de-al doilea sfert");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Se incepe citirea celui de-al treilea sfert...");
		for(int r = this.image.getHeight() / 2; r < this.image.getHeight(); r ++) {
			for(int c = 0; c < this.image.getWidth() / 2; c ++) {
				this.buffer.put(this.image.getRGB(c, r));
			}
		}
		System.out.println("S-a terminat citirea celui de-al treilea sfert");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Se incepe citirea celui de-al patrulea sfert...");
		for(int r = this.image.getHeight() / 2; r < this.image.getHeight(); r ++) {
			for(int c = this.image.getWidth() / 2; c < this.image.getWidth(); c ++) {
				this.buffer.put(this.image.getRGB(c, r));
			}
		}
		System.out.println("S-a terminat citirea celui de-al patrulea sfert");
	}
	
	
}
