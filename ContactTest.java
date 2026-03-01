package contact;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactCreatesSuccessfully() {
        Contact contact = new Contact("12345", "Devin", "Shalles", "1234567890", "555 Broad Street");
        assertEquals("12345", contact.getContactId());
        assertEquals("Devin", contact.getFirstName());
        assertEquals("Shalles", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("555 Broad Street", contact.getAddress());
    }

    @Test
    public void testContactIdCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Devin", "Shalles", "1234567890", "555 Broad Street");
        });
    }

    @Test
    public void testContactIdCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Devin", "Shalles", "1234567890", "555 Broad Street");
        });
    }

    @Test
    public void testFirstNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Shalles", "1234567890", "555 Broad Street");
        });
    }

    @Test
    public void testFirstNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "DevinDevinDevin", "Shalles", "1234567890", "555 Broad Street");
        });
    }

    @Test
    public void testLastNameCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", null, "1234567890", "555 Broad Street");
        });
    }

    @Test
    public void testLastNameCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", "ShallesShalles", "1234567890", "555 Broad Street");
        });
    }

    @Test
    public void testPhoneCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", "Shalles", null, "555 Broad Street");
        });
    }

    @Test
    public void testPhoneMustBeExactlyTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", "Shalles", "12345", "555 Broad Street");
        });
    }

    @Test
    public void testPhoneMustBeOnlyDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", "Shalles", "12345abcde", "555 Broad Street");
        });
    }

    @Test
    public void testAddressCannotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", "Shalles", "1234567890", null);
        });
    }

    @Test
    public void testAddressCannotBeTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Devin", "Shalles", "1234567890",
                    "1234567890123456789012345678901");
        });
    }
}
