 data class Post(
    var id: Int,
    var ownerId: Int,
    var fromId: Int,
    var date: Int,
    var text: String,
    var canPin: Boolean,
    var canDelete: Boolean,
    var canEdit: Boolean,
    var isFavorite: Boolean,
    val likes: Likes
)
 data class Likes(
     var count: Int,
     var userLikes: Boolean,
     var canLike: Boolean,
     var canPublish: Boolean
 )


 object WallService {
     private var posts = emptyArray<Post>()
     private var lastId = 0
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
     fun clear() {
         posts = emptyArray()
         lastId = 0
     }
 }
fun main() {
    val post1 = Post(2, 1, 5, 6, "т", true, false, true, false, Likes(5,true,false,true))
    val post2 = Post(5, 7, 8, 6, "г",true,true,false,true,Likes(5,true,false,true))
    WallService.add(post1)
    WallService.add(post2)
    WallService.printAll()
}