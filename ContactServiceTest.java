package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContactSuccessfully() {
        Contact c = new Contact("1", "Devin", "Shalles", "1234567890", "555 Broad Street");
        service.addContact(c);

        assertNotNull(service.getContact("1"));
        assertEquals("Devin", service.getContact("1").getFirstName());
    }

    @Test
    public void testAddContactDuplicateIdFails() {
        Contact c1 = new Contact("1", "Devin", "Shalles", "1234567890", "555 Broad Street");
        Contact c2 = new Contact("1", "Chris", "Smith", "0987654321", "123 Main Street");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    @Test
    public void testDeleteContactSuccessfully() {
        Contact c = new Contact("1", "Devin", "Shalles", "1234567890", "555 Broad Street");
        service.addContact(c);

        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteMissingIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("doesNotExist");
        });
    }

    @Test
    public void testUpdateContactFieldsSuccessfully() {
        Contact c = new Contact("1", "Devin", "Shalles", "1234567890", "555 Broad Street");
        service.addContact(c);

        service.updateContact("1", "Dev", "S", "1112223333", "777 New Ave");

        Contact updated = service.getContact("1");
        assertEquals("Dev", updated.getFirstName());
        assertEquals("S", updated.getLastName());
        assertEquals("1112223333", updated.getPhone());
        assertEquals("777 New Ave", updated.getAddress());
    }

    @Test
    public void testUpdateOnlyOneFieldLeavesOthersSame() {
        Contact c = new Contact("1", "Devin", "Shalles", "1234567890", "555 Broad Street");
        service.addContact(c);

        // Update only phone; pass null for others so they remain unchanged
        service.updateContact("1", null, null, "1112223333", null);

        Contact updated = service.getContact("1");
        assertEquals("Devin", updated.getFirstName());
        assertEquals("Shalles", updated.getLastName());
        assertEquals("1112223333", updated.getPhone());
        assertEquals("555 Broad Street", updated.getAddress());
    }

    @Test
    public void testUpdateInvalidPhoneFails() {
        Contact c = new Contact("1", "Devin", "Shalles", "1234567890", "555 Broad Street");
        service.addContact(c);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1", null, null, "123", null);
        });
    }

    @Test
    public void testUpdateMissingIdFails() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("missing", "Dev", null, null, null);
        });
    }
}

