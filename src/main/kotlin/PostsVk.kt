data class Post(
    var id: Int?,
    var ownerId: Int,
    var fromId: Int?,
    var created_by: Int,
    var date: Int?,
    var text: String,
    var reply_owner_id: Int,
    var reply_post_id: Int,
    var friends_only: Boolean,
    val Comments: Comments,
    val Copyright: Copyright,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isFavorite: Boolean,
    val likes: Likes,
    var is_pinned: Boolean,
    var marked_as_ads: Boolean,
    val Donut: Donut,
    var postponed_id: Int,
    var attachments: Array<Attachments> = emptyArray()

)


class Likes(var count: Int, var userLikes: Boolean, var canLike: Boolean, var canPublish: Boolean)
class Comments(
    var id: Int,
    var can_post: Boolean,
    var groups_can_post: Boolean,
    var can_close: Boolean,
    var can_open: Boolean
)

class Copyright(var id: Int, var link: String, var name: String, var type: String)
class Donut(var is_donut: Boolean, var paid_duration: Int)
interface Attachments {
    val type: String
}

class Audio(override val type: String = "audio", var audioAttachment: AudioAttachment) : Attachments
class AudioAttachment(
    var id: Int = 0,
    var ownerId: Int = 0,
    var artist: String = "artist",
    var title: String = "name",
    var duration: Int = 0
)

class Doc(override val type: String = "doc", var docAttachments: DocAttachments) : Attachments
class DocAttachments(var id: Int, var ownerId: Int, var title: String, var size: Int, var ext: String)
class Graffiti(override val type: String = "graffiti", var graffitiAttachments: GraffitiAttachments) : Attachments
class GraffitiAttachments(var id: Int, var ownerId: Int, var photo130: String, var photo604: String)
class Note(override val type: String = "note", var note: NoteAttachments) : Attachments
class NoteAttachments(var id: Int, var ownerId: Int, var title: String, var text: String, var date: Int)
class Video(override val type: String = "video", var videoAttachments: VideoAttachments) : Attachments
class VideoAttachments(var id: Int, var ownerId: Int, var title: String, var description: String, var duration: Int)
class PostNotFoundException(message: String) : RuntimeException(message)
object WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0
    private var comments = emptyArray<Comments>()
    private var commentIdNext = 0
    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }

    fun printAll() {
        for (post in posts) {
            println(post)
        }
    }

    fun update(post: Post): Boolean {
        for ((index, currentPost) in posts.withIndex()) {
            if (post.id == currentPost.id) {
                posts[index] = post.copy()
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comments): Comments {
        for ((index, postsId) in posts.withIndex()) {
            if (postId == postsId.id) {
                comments += comment
                comment.id = ++commentIdNext
                return comments.last()
            }
        }
        throw PostNotFoundException("Such a post doesn't exist")
    }

    fun clear() {
        posts = emptyArray()
        lastId = 0
    }
}

fun main() {
    val post1 = Post(
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
    WallService.add(post1)
    WallService.printAll()
}