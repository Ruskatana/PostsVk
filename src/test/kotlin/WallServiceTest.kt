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
        val post = Post(2, 1, 5, 6, 6, "r", 6, 8, false, Comments(5,true,false,true,false), Copyright (5, "h", "f", "f"), canPin = true, canDelete = false, canEdit = true, isFavorite = true, Likes(5,true,false,true),false, false, Donut(true, 5), 5)
        val result = WallService.update(post)

        assertEquals(false, result)

    }
    @Test
    fun updateWithAdd() {
        val post = Post(2, 1, 5, 6, 6, "r", 6, 8, false, Comments(5,true,false,true,false), Copyright (5, "h", "f", "f"), canPin = true, canDelete = false, canEdit = true, isFavorite = true, Likes(5,true,false,true),false, false, Donut(true, 5), 5)
        WallService.add(post)
        val result = WallService.update(post)
        assertEquals(true, result)

    }


}