import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class MessageManagerTest {

    private MessageManager messageManager;
    private User luffy;
    private User zoro;
    private Message message;

    @Before
    public void setUp() {
        messageManager = new MessageManager();

        luffy = new User(
                "luffy",
                "pirateking",
                "luffy@onepiece.com",
                "Monkey D.",
                "Luffy",
                "luffy.jpg"
        );

        zoro = new User(
                "zoro",
                "swordsman",
                "zoro@onepiece.com",
                "Roronoa",
                "Zoro",
                "zoro.jpg"
        );

        message = messageManager.createMessageObject(
                "Hello, Zoro!",
                false,
                luffy,
                zoro,
                LocalDateTime.now(),
                null
        );


    }


    // Test for rejectFriendRequest method
    @Test
    public void testRejectFriendRequest() throws UserNotFoundException {
        luffy.getRequestedFriends().add(zoro);
        zoro.getPendingFriendRequests().add(luffy);

        writeUsersToFile(new ArrayList<>(Arrays.asList(luffy, zoro)));

        assertTrue("Friend request should be rejected successfully", messageManager.rejectFriendRequest(luffy, zoro));
        assertFalse("Zoro should not be in Luffy's requested friends list", luffy.getRequestedFriends().contains(zoro));
        assertFalse("Luffy should not be in Zoro's pending friend requests list", 
                zoro.getPendingFriendRequests().contains(luffy));
    }

    // Helper Methods
    private ArrayList<User> readUsersFromFile() {
        ArrayList<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users.bin"))) {
            users = (ArrayList<User>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    private void writeUsersToFile(ArrayList<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("users.bin"))) {
            oos.writeObject(users);
        } catch (IOException e) {
            fail("Setup failed: Unable to write to users.bin");
        }
    }
}