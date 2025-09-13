package LightSim;

public class Albedo {
	private double reflectedSolar;	//intensity w/m^2
	private double incidentSolar;	//intensity w/m^2
	private double albedo;
	
	public Albedo(double reflectedSolar, double incidentSolar) {
		this.reflectedSolar = reflectedSolar;
		this.incidentSolar = incidentSolar;
	}
	
	public double getIncidentSolar() {
		return incidentSolar ;
	}
	public double getReflectedSolar() {
		return reflectedSolar ;
	}
	public double getAlbedo() {
		return albedo;
	}
	
	public double calculateAlbedo() {
		return albedo = checkSolar(reflectedSolar) && checkSolar(incidentSolar) ? reflectedSolar / incidentSolar : -1;
	}
	private boolean checkSolar(double solar) {
		return solar > 0 && solar <=1000;
	}
	
}