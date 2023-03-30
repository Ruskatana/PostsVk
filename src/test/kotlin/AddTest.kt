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
        val post = Post(
            2,
            1,
            5,
            6,
            6,
            "r",
            6,
            8,
            false,
            Comments(5, true, false, true, false),
            Copyright(5, "h", "f", "f"),
            canPin = true,
            canDelete = false,
            canEdit = true,
            isFavorite = true,
            Likes(5, true, false, true),
            false,
            false,
            Donut(true, 5),
            5
        )
        WallService.add(post)
        var result = post.id != 0
        Assert.assertEquals(true, result)
    }
}

