package LightSim;

import java.util.Scanner;

public class Snell {
	private double index1;
	private double index2;
	private double theta1;
	private double theta2;

	public Snell(double theta1, double theta2, double index1, double index2) {
		this.index1 = index1;
		this.index2 = index2;
		this.theta1 = theta1;
		this.theta2 = theta2;
	}

	public double getIndex1() {
		return index1;
	}

	public double getIndex2() {
		return index2;
	}

	public double getTheta1() {
		return theta1;
	}

	public double getTheta2() {
		return theta2;
	}

	public double calculateIndex1() {
		return index1 = checkIndex(index2) && checkTheta(theta1) && checkTheta(theta2)
				? (index2 * Math.sin(Math.toRadians(theta2))) / Math.sin(Math.toRadians(theta1))
				: -1;
	}

	public double calculateIndex2() {
		return index2 = checkIndex(index1) && checkTheta(theta1) && checkTheta(theta2)
				? (index1 * Math.sin(Math.toRadians(theta1))) / Math.sin(Math.toRadians(theta2))
				: -1;
	}

	public double calculateTheta1() {
		return theta1 = checkIndex(index2) && checkIndex(index1) && checkTheta(theta2)
				? Math.toDegrees(Math.asin((index2 * Math.sin(Math.toRadians(theta2))) / index1))
				: -1;
	}

	public double calculateTheta2() {
		return theta2 = checkIndex(index2) && checkIndex(index1) && checkTheta(theta1)
				? Math.toDegrees(Math.asin((index1 * Math.sin(Math.toRadians(theta1))) / index2))
				: -1;
	}

	private Boolean checkTheta(double theta) {
		return theta >= 0 && theta <= 90 ? true : false;
	}

	private Boolean checkIndex(double index) {
		return index >= 1 && index <= 4 ? true : false;
	}

}