import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void createAndRetrieveUser() {
        // Create new user and save it
        new User("cuongbm0211@gmail.com", "123456", "Bui Manh Cuong").save();

        // Retrieve the user with email
        User cuong = User.find("byEmail", "cuongbm0211@gmail.com").first();

        // Test
        assertNotNull(cuong);
        assertEquals("Bui Manh Cuong", cuong.fullname);
    }

}
