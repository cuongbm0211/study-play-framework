import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteDatabase();
    }

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

    @Test
    public void createPost() {
        // Create user and save it
        User bob = new User("bob@gmail.com", "123", "Bob").save();

        // Create a new post
        new Post(bob, "My first post", "Hello world").save();

        // Test the post has been created
        assertEquals(1, Post.count());

        // Retrieve all posts created by Bob
        List<Post> bobPosts = Post.find("byAuthor", bob).fetch();

        // Test
        assertEquals(1, bobPosts.size());
        Post firstPost = bobPosts.get(0);
        assertNotNull(firstPost);
        assertEquals(bob, firstPost.author);
        assertEquals("My first post", firstPost.title);
        assertEquals("Hello world", firstPost.content);
        assertNotNull(firstPost.postedAt);
    }

}
