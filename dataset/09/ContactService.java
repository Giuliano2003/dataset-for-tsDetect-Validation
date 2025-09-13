//Matthew Clockel
//05/21/2021	
//CS 320 - 21EW5
//This is the contactService class which will allow adding, deleting, and updating contacts.


package main.java.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// ContactService class
	public class ContactService {

		private static ContactService reference = new ContactService();
		//private final Map<String, Contact> contacts;
		//Hashtable where the key is a uniqueId and Contact is the value.
		private Map<Integer, Contact> contacts = new HashMap<>();
		//uniqueId variable
		private Integer uniqueId;
		//Contact Service method
		public ContactService() {
			this.contacts = new HashMap<Integer, Contact>();
		}

		//Create a singleton Contact Service
		public static ContactService getService() {
			return reference;
		}
		//Add contact
		public Map<Integer, Contact> addContact(Contact contact) {
			contacts.put(uniqueId, contact);
			return contacts;
		}
		//Delete contact
		public Map<Integer, Contact> deleteContact(String contactId) {
			//Gets the iterator
			Iterator<Entry<Integer, Contact>> itr = contacts.entrySet().iterator();
			while (itr.hasNext()) {
				Map.Entry<Integer, Contact> input = (Map.Entry<Integer, Contact>) itr.next();
				if (input.getValue().getContactId() == contactId) {
					itr.remove();
				}
			}
			return contacts;
		}
		//Update contact
		public Map<Integer, Contact> updateContact(String contactId, String firstName, String lastName, String number, String address) {
			Iterator<Entry<Integer, Contact>> itr = contacts.entrySet().iterator();
	         
	        while(itr.hasNext()) {
	        	Map.Entry<Integer, Contact> input = (Map.Entry<Integer, Contact>) itr.next();
	        	if(input.getValue().getContactId() == contactId) {
	        		input.getValue().setFirstName(firstName);
	        		input.getValue().setLastName(lastName);
	        		input.getValue().setPhone(number);
	        		input.getValue().setAddress(address);
	        	}
	        }
			return contacts;
		}

		public Map<Integer, Contact> deleteContact(Contact contact) {
			// TODO Auto-generated method stub
			return null;
		}

		public Map<Integer, Contact> updateContact(Contact contact) {
			// TODO Auto-generated method stub
			return null;
		}

		public Object addContact(Integer uniqueId2, Contact contact) {
			// TODO Auto-generated method stub
			return null;
		}
}