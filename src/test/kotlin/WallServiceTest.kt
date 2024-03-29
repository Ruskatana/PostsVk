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
        val result = WallService.update(post)

        assertEquals(false, result)

    }

    @Test
    fun updateWithAdd() {
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
        val result = WallService.update(post)
        assertEquals(true, result)

    }
    @Test
    fun createCommentCorrect() {
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
            true,
            false,
            Donut(true, 5),
            5,
        )
        WallService.add(post)

        var newComment = Comments(5, true, true, false, true)
        val result = WallService.createComment(1, newComment)


        assertEquals (newComment, result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowPost() {
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
            true,
            false,
            Donut(true, 5),
            5,
        )
        WallService.add(post)

        var newComment = Comments(5, true, true, false, true)
        WallService.createComment(10000, newComment)
    }


}