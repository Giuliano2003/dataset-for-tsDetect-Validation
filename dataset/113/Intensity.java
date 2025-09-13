
package LightSim;

public class Intensity {
	double power;
	double energy;
	double time;
	double area;
	double intensity;

	public Intensity(double power, double energy, double time, double area) {
		this.power = power;
		this.energy = energy;
		this.time = time;
		this.area = area;
	}

	public double getPower() {
		return power;
	}

	public double getEnergy() {
		return energy;
	}

	public double getTime() {
		return time;
	}

	public double getArea() {
		return area;
	}

	public double getIntensity() {
		return intensity;
	}

	public double calculateIntensity(double energy, double time, double area) {
		return intensity = checkArea(area) && checkTime(time) && checkEnergy(energy) ? energy / (area * time) : -1;
	}

	public double calculateIntensity(double power, double area) {
		return intensity = checkArea(area) && checkPower(power) ? power / area : -1;
	}
	private boolean checkArea(double area) {
		return area > 0;
	}
	private boolean checkEnergy(double energy) {
		return energy > 0;
	}
	private boolean checkTime(double time) {
		return time > 0;
	}
	private boolean checkPower(double power) {
		return power > 0;
	}
}
