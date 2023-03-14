import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AddTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(1, 1, 5, 6, "т", true, false, true, false, Likes(5, true, false, true))
        WallService.add(post)
        var result = post.id != 0
        Assert.assertEquals(true, result)
       }
        }

