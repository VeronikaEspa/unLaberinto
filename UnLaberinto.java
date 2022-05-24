package matriz.unLaberinto;

import java.util.Scanner;

public class UnLaberinto {
	static int positionY, positionX;

	static String[] Elements = {
			" \uD83E\uDD93 ", // Personaje index = 0
			//gato 🐈
			"\uD83C\uDF59\uD83C\uDF59",  // Pared[0] index = 1 🌪️🌪️🌪️🌪️🌪️ 🍙🍙🍙🍙🍙🍙 🌄🌄🌄🌄🌄
			// cajas 📦📦
			" . ",  // Suelo[1] index = 2
			"\uD83C\uDF0A\uD83C\uDF0A",  // Agua[2] index = 3
			"\uD83C\uDF32\uD83C\uDF32" // Bosque[3] index = 4
	};

	public static void main(String[] args) {
		int[][] matrix = {
				{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,3,3,3,3,3,3,1},
				{0,0,0,1,1,1,1,1,1,0,3,3,3,0,0,3,0},
				{0,3,3,1,1,0,0,0,1,3,3,3,3,3,0,3,0},
				{0,3,3,1,1,1,1,1,1,0,3,3,3,3,0,3,0},
				{0,3,0,1,0,0,0,1,1,0,3,3,0,3,3,3,0},
				{0,3,0,1,1,1,1,1,1,3,3,0,0,3,3,3,0},
				{0,3,3,3,1,1,1,1,1,3,3,3,3,3,0,3,0},
				{0,3,3,3,1,1,0,1,1,2,2,2,2,2,0,2,0},
				{0,3,3,3,3,3,0,1,1,1,1,1,2,2,0,2,0},
				{0,3,3,0,0,0,0,1,2,2,1,1,2,2,2,2,0},
				{0,3,3,0,1,1,1,1,2,2,2,1,1,2,2,2,0},
				{0,3,3,0,1,1,2,2,2,2,2,1,1,1,1,2,0},
				{0,3,3,0,1,2,2,2,2,2,2,2,2,2,2,2,0},
				{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		positionX = 1;
		positionY = 1;
		do {
			unMapa(matrix);
		} while (teclas(matrix));
	}

	static boolean teclas(int[][] matrix) {
		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		inputUsuario = entrada.nextLine();
		if(positionY >= 0 && positionX >= 0 && positionX <= matrix.length - 1 && positionY <= matrix[0].length - 1) {
			if (inputUsuario.equals("a")
					&& (matrix[positionX][positionY - 1] == 1
					|| matrix[positionX][positionY - 1] == 3)) {
				positionY = positionY - 1;
			} else if (inputUsuario.equals("d")
					&& (matrix[positionX][positionY + 1] == 1
					|| matrix[positionX][positionY + 1] == 3)) {
				positionY = positionY + 1;
			} else if (inputUsuario.equals("w")
					&& (matrix[positionX - 1][positionY] == 1
					|| matrix[positionX - 1][positionY] == 3)) {
				positionX = positionX - 1;
			} else if (inputUsuario.equals("s")
					&& (matrix[positionX + 1][positionY] == 1
					|| matrix[positionX + 1][positionY] == 3)) {
				positionX = positionX + 1;
			} else if (inputUsuario.equals("f")) {
				return false;
			}
		}
		return true;
	}

	static void unMapa(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == positionX && j == positionY) {
					printElements(0);
				} else {
					if (matrix[i][j] == 0) {
						printElements(1);
					} else if (matrix[i][j] == 1) {
						printElements(2);
					}
					else if (matrix[i][j] == 2) {
						printElements(3);
					}
					else if (matrix[i][j] == 3) {
						printElements(4);
					}
				}
			}
			System.out.println();
		}
		System.out.println("Personaje en X: " + positionY + " , en Y: " + positionX);
	}

	static void printElements(int index){
		System.out.print(Elements[index]);
	}
}