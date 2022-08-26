package com.bilgeadam.boost.Marathon01;

import java.util.Scanner;

public class ShapeTest {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ShapeTest shapeTest = new ShapeTest();
		shapeTest.readInput();
		System.out.println("Bye....");
	}

	private void readInput() {
		int shape = 1;
		do {

			int firstEdge = 0;
			int secondEdge = 0;
			int thirdEgde = 0;
			int fourthEdge = 0;
			int areaCalc = 0;
			int perimeterSum = 0;

			System.out.println("Lutfen hesaplamak istediginiz seklin (en fazla 4 kenar) "
					+ "kenar uzunluklarini giriniz (-1 ile cikis): ");
			while (true) {
				int i = 1;

				firstEdge = this.scanEdge(i);
				if (this.isEnd(firstEdge)) {
					return;
				}
				if (this.isExit(firstEdge)) {
					break;
				}

				i++;

				secondEdge = scanEdge(i);
				if (this.isEnd(secondEdge)) {
					return;
				}
				if (this.isExit(secondEdge)) {
					break;
				}

				i++;

				thirdEgde = scanEdge(i);
				if (this.isEnd(thirdEgde)) {
					return;
				}
				if (this.isExit(thirdEgde)) {
					break;
				}

				i++;

				fourthEdge = scanEdge(i);
				if (this.isEnd(fourthEdge)) {
					return;
				}
				if (this.isExit(fourthEdge)) {
					break;
				}

				break;

			}

			if ((secondEdge != 0) && (thirdEgde != 0)) {

				showMenu();
				System.out.print("\nSecim: ");
				String operation = scanString();

				switch (operation) {

				case "1":
					perimeterSum = this.doPerimeterCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
					System.out.println(shape + ". Sekilin cevresi:" + perimeterSum);
					shape++;
					break;

				case "2":
					areaCalc = this.doAreaCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
					System.out.println(shape + ". Sekilin alani:" + areaCalc);
					shape++;
					break;

				case "3":
					perimeterSum = this.doPerimeterCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
					areaCalc = this.doAreaCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
					System.out.println(shape + ". Sekilin cevresi:" + perimeterSum);
					System.out.println(shape + ". Sekilin alani:" + areaCalc);
					shape++;
					break;

				default:
					System.out.println("Wrong input!! Try Again.");
					break;
				}
				
			} else if (secondEdge == 0) {
				System.err.println("Tek kenarli sekil olamaz");
			} else if (thirdEgde == 0) {
				System.err.println("Iki kenarli sekil olamaz");
			}
		} while (true);

	}

	private int doAreaCalc(int firstEdge, int secondEdge, int thirdEgde, int fourthEdge) {
		int areaCalc = 0;
		if (this.isTriangle(fourthEdge)) {
			areaCalc = this.calcTriangleArea(firstEdge, secondEdge, thirdEgde);

		} else {
			areaCalc = this.calcTrapezoidalArea(firstEdge, secondEdge, thirdEgde, fourthEdge);

		}
		return areaCalc;
	}

	private int doPerimeterCalc(int firstEdge, int secondEdge, int thirdEgde, int fourthEdge) {
		int perimeterSum = firstEdge + secondEdge + thirdEgde + fourthEdge;
		return perimeterSum;
	}

	private static void showMenu() {
		System.out.println("\n1- Cevre");
		System.out.println("2- Alan");
		System.out.println("3- Hem Cevre hem Alan");
	}

	private boolean isTriangle(int fourthEdge) {
		if (fourthEdge == 0) {
			return true;
		}
		return false;
	}

	private int calcTriangleArea(int firstEdge, int secondEdge, int thirdEgde) {
		int area = 0;
		int sum = firstEdge + secondEdge + thirdEgde;
		area = (int) Math.sqrt(sum * (sum - firstEdge) * (sum - secondEdge) * (sum - thirdEgde));
		return area;
	}

	private int calcTrapezoidalArea(int firstEdge, int secondEdge, int thirdEgde, int fourthEdge) {
		int area = 0;
		// trapezoidal area (a+b/2)*h
		// But I made a wrong calculation here please ignore
		area = (firstEdge + thirdEgde) * secondEdge / 2;
		return area;

	}

	private boolean isExit(int edge) {
		if (edge == 0) {
			return true;
		}
		return false;
	}

	private boolean isEnd(int edge) {
		if (edge == -1) {
			return true;
		}
		return false;
	}

	private int scanEdge(int i) {
		System.out.print("Lutfen " + i + ". kenar uzunlugunu giriniz (0 ile sonlandir): ");
		int number = scanInt();
		return number;
	}

	private static int scanInt() {
		int number = sc.nextInt();
		return number;
	}

	private static String scanString() {
		String input = sc.next();
		return input;
	}

}
