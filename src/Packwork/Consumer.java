package Packwork;
import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.PipedInputStream;
//import java.io.PipedOutputStream;
//import Packwork.WriterResult;


public class Consumer extends Thread {

	private int width;
	private int height;
	private int[][] image;  //matrice ce contine valorile pixelilor ce va fi ulterior prelucrata
	private Pixel buffer;
/*	private PipedOutputStream pos;
    private PipedInputStream pis;
    private WriterResult writer;
    private String fileName;
	*/
	public Consumer(int width, int height, Pixel buffer) {
		if(width < 0) {
			width = 0;
		}
		if(height < 0) {
			height = 0;
		}
		this.width = width;
		this.height = height;
		this.image = new int[this.height][this.width];  //initializez matricea cu 0
		for(int r = 0; r < this.height; r++) {
			for(int c = 0; c < this.width; c++) {
				this.image[r][c] = 0;
			}
		}
		this.buffer = buffer;
	/*	this.pos = new PipedOutputStream();
        this.pis = new PipedInputStream(pos);
        this.writer = writer;
        this.fileName = fileName; */
	}
	
	public BufferedImage getModifiedImage(BufferedImage original) { //incarc imaginea modificata in imaginea originala
		BufferedImage modified_image = original;
		for(int r = 0; r < this.height; r++) {
			for(int c = 0; c < this.width; c++) {
				modified_image.setRGB(c, r, this.image[r][c]);
			}
		}
		return modified_image;
	}
	
	public void run() {
		
		for(int r = 0; r < this.height / 2; r ++) {            // pun pe rand valorile in matrice
			for(int c = 0; c < this.width / 2; c ++) {
				this.image[r][c] = this.buffer.get();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int r = 0; r < this.height / 2; r ++) {
			for(int c = this.width / 2; c < this.width; c ++) {
				this.image[r][c] = this.buffer.get();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int r = this.height / 2; r < this.height; r ++) {
			for(int c = 0; c < this.width / 2; c ++) {
				this.image[r][c] = this.buffer.get();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int r = this.height / 2; r < this.height; r ++) {
			for(int c = this.width / 2; c < this.width; c ++) {
				this.image[r][c] = this.buffer.get();
			}
		}
		
		NormalizeColors normColors = new NormalizeColors(image, width, height);
		normColors.normalize();
		this.image = normColors.getImage();
	
	// incercare de transmitere prin metoda pipe a imaginii procesate catre un fisier
	/*
    // First segment
    System.out.println("Sending first segment...");
    for(int r = 0; r < this.height / 2; r ++) {            
        for(int c = 0; c < this.width / 2; c ++) {
            pos.write(this.image[r][c]);
        }
    }
    System.out.println("First segment sent!");

    // Second segment
    System.out.println("Sending second segment...");
    for(int r = 0; r < this.height / 2; r ++) {
        for(int c = this.width / 2; c < this.width; c ++) {
            pos.write(this.image[r][c]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    System.out.println("Second segment sent!");

    // Third segment
    System.out.println("Sending third segment...");
    for(int r = this.height / 2; r < this.height; r ++) {
        for(int c = 0; c < this.width / 2; c ++) {
            pos.write(this.image[r][c]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    System.out.println("Third segment sent!");

    // Fourth segment
    System.out.println("Sending fourth segment...");
    for(int r = this.height / 2; r < this.height; r ++) {
        for(int c = this.width / 2; c < this.width; c ++) {
            pos.write(this.image[r][c]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    System.out.println("Fourth segment sent!");
    writer.writeToFile(pis, fileName);

	*/
	} 
	
	
	
	
		

}