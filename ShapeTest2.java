package com.bilgeadam.boost.Marathon01;

import java.util.Scanner;

// layout test for ShapeTest.java
// with english printouts

public class ShapeTest2 {
	int firstEdge;
	int secondEdge;
	int thirdEgde;
	int fourthEdge;
	int shape;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ShapeTest2 shapeTest = new ShapeTest2();
		shapeTest.readInput();
		System.out.println("Bye....");
	}

	private void readInput() {
		shape = 1;

		do {

			firstEdge = 0;
			secondEdge = 0;
			thirdEgde = 0;
			fourthEdge = 0;
			;

			System.out.println("\nPlease enter the side lengths of the shape "
					+ "(max. 4 sides) and (exit with -1): ");

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
				System.out.print("\nSelection: ");
				this.doOperation(ShapeTest2.scanString());

			} else if (secondEdge == 0) {
				System.err.println("It cannot be a single sided shape");
			} else if (thirdEgde == 0) {
				System.err.println("It cannot be a double-sided shape");
			}
		} while (true);

	}

	private void doOperation(String operation) {
		int areaCalc = 0;
		int perimeterSum = 0;

		switch (operation) {

		case "1":
			perimeterSum = this.doPerimeterCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
			System.out.println("Circumference of figure "+shape+".: "+ perimeterSum);
			shape++;
			break;

		case "2":
			areaCalc = this.doAreaCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
			System.out.println("Area of figure "+shape+".: "+ areaCalc);
			shape++;
			break;

		case "3":
			perimeterSum = this.doPerimeterCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
			areaCalc = this.doAreaCalc(firstEdge, secondEdge, thirdEgde, fourthEdge);
			System.out.println("Circumference of figure "+shape+": "+ perimeterSum);
			System.out.println("Area of figure "+shape+": "+ areaCalc);
			shape++;
			break;

		default:
			System.out.println("Wrong input!! Try Again.");
			System.out.print("\nSelection: ");
			doOperation(ShapeTest2.scanString());
		}

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
		System.out.println("\n1- Circumference");
		System.out.println("2- Area");
		System.out.println("3- Circumference and Area");
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
		System.out.print("Please enter "+i+". side length (end with 0): ");
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
