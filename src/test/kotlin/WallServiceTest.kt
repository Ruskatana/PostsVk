import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }
    @Test
    fun updateWithoutAdd() {
        val post = Post(1, 1, 5, 6, "т", true, false, true, false, Likes(5, true, false, true))
        val result = WallService.update(post)

        assertEquals(false, result)

    }
    @Test
    fun updateWithAdd() {
        val post = Post(1, 1, 5, 6, "т", true, false, true, false, Likes(5, true, false, true))
        WallService.add(post)
        val result = WallService.update(post)
        assertEquals(true, result)

    }


}