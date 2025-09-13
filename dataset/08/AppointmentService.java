
package main.java.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//Matthew Clockel
//06/4/2021
//CS 320 - 21EW5
//Requirements:
/* Appointment service class requirements:
 * The appointment service shall be able to add appointments with a unique appointment ID.
 * The appointment service shall be able to delete appointments per appointment ID.
 */

public class AppointmentService {

		private static AppointmentService reference = new AppointmentService();
		//private final Map<String, Appointment> appointments;
		
		//Hashtable where the key is a uniqueId and Appointment is the value.
		private Map<Integer, Appointment> appointments = new HashMap<>();
		//uniqueId variable
		private Integer uniqueId;
		//Appointment Service method
		public AppointmentService() {
			this.appointments = new HashMap<Integer, Appointment>();
		}

		//Create a singleton Contact Service
		public static AppointmentService getService() {
			return reference;
		}
		//Add appointment
		public Map<Integer, Appointment> addAppointment(Appointment appointment) {
			appointments.put(uniqueId, appointment);
			return appointments;
		}
		//Delete appointment
		public Map<Integer, Appointment> deleteAppointment(String appointmentID) {
			//Gets the iterator
			Iterator<Entry<Integer, Appointment>> itr = appointments.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<Integer, Appointment> input = (Map.Entry<Integer, Appointment>) itr.next();
				if (input.getValue().getAppointmentID() == appointmentID) {
					itr.remove();
				}
			}
			return appointments;
		}

		public Map<Integer, Appointment> getAppointmentList() {
			// TODO Auto-generated method stub
			return null;
		}

		public Map<Integer, Appointment> deleteAppointment(Appointment appointment) {
			// TODO Auto-generated method stub
			return null;
		}
	}
