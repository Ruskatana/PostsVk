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
    @Test(expected = PostNotFoundException::class)
    fun shouldThrowPost() {
        var id: Int?
        var ownerId: Int
        var fromId: Int?
        var created_by: Int
        var date: Int?
        var text: String
        var reply_owner_id: Int
        var reply_post_id: Int
        var friends_only: Boolean
        val Comments: Comments
        val Copyright: Copyright
        var canPin: Boolean
        var canDelete: Boolean
        var canEdit: Boolean
        var isFavorite: Boolean
        val likes: Likes
        var is_pinned: Boolean
        var marked_as_ads: Boolean
        val Donut: Donut
        var postponed_id: Int
        var attachments: Array<Attachments> = emptyArray()
        val post = Post(2, 1, 5, 6, 6, "r", 6, 8, false, Comments(5,true,false,true,false), Copyright (5, "h", "f", "f"), canPin = true, canDelete = false, canEdit = true, isFavorite = true, Likes(5,true,false,true), true, false, Donut(true, 5), 5,)
        WallService.add(post)

        var newComment = Comments(5,true,true,false,true)
        WallService.createComment(10000, newComment)
    }


}