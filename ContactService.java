package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }

        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }

        contacts.put(id, contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        contacts.remove(contactId);
    }

    // Update fields by ID 
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null.");
        }

        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }

        // Only update if a new value is provided (non-null)
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}

        
    
    
    

    