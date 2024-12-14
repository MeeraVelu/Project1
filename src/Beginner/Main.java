package Beginner;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	

		    final Scanner keyboard = new Scanner(System.in);

		        Generator generator = new Generator(keyboard);
		        generator.mainLoop();
		        keyboard.close();
		    }
		}

