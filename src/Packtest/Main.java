package Packtest;
import Packwork.Pixel;
import Packwork.Producer;
import Packwork.Consumer;


import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Main {
	

	public static BufferedImage readInputImage(String path) {  //citesc din fisier
		File file = new File(path);
		BufferedImage inputImage = null;
		try {
			inputImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputImage;
	}
	
	public static void writeOutputImage(BufferedImage outputImage, String path) { //pun in fisier imaginea modificata
		File file = new File(path);
		try {
			ImageIO.write(outputImage, "bmp", file);
		} catch(IOException e) {
			System.out.println("Write error: " + e);
		}
	}

	public static void main(String[] args) {
		String inputPath = "";
		String outputPath = "";
		if(args.length == 0) {                 // daca nu am parametrii, ii cer de la utilizator
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Source file path: ");
	        inputPath = scanner.nextLine();
	        System.out.print("Destination file path: ");
	        outputPath = scanner.nextLine();
	        scanner.close();
		}
		else if (args.length == 1){   //un parametru dat va reloca imaginea modificata in locul celei originale
			inputPath = args[0];
			outputPath = args[0];
		}
		else {
			inputPath = args[0];    // la cel putin 2 argumente, se vor lua primele 2 si vom lucra cu ele
			outputPath = args[1];
		}

		BufferedImage original_image = Main.readInputImage(inputPath);
		Pixel buffer = new Pixel();
		Producer image_read = new Producer(buffer, original_image);
		Consumer image_normalize = new Consumer(original_image.getWidth(), original_image.getHeight(), buffer);
		
		image_read.start();
		image_normalize.start();
		
		while(image_read.isAlive() || image_normalize.isAlive()) {}  //astept pana se termina citirea pentru a incepe procesarea
		
		BufferedImage modified_image = image_normalize.getModifiedImage(original_image); //iau imaginea modificata
		
		Main.writeOutputImage(modified_image, outputPath); //o pun in fisier
	}

}
