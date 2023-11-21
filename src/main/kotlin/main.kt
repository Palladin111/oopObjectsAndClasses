data class Post(
    val id: Int,             // Идентификатор записи
    val createdBy: Int,      // Идентификатор администратора, который опубликовал запись
    val date: Long,           // Время публикации записи в формате unixtime
    val text: String,        // Текст записи
    val canPin: Boolean,     // Информация о том, может ли текущий пользователь закрепить запись
    val isFavorite: Boolean, // true, если объект добавлен в закладки у текущего пользователя
    val friendsOnly: Boolean,    // true, если запись была создана с опцией «Только для друзей».
    val fromId: Int,         // Идентификатор автора записи (от чьего имени опубликована запись)
    val canDelete: Boolean,  // Информация о том, может ли текущий пользователь удалить запись
    val likes: Likes         // Информация о лайках к записи
)

data class Likes(
    val count: Int,          // число пользователей, которым понравилась запись
    val userLikes: Boolean,  // наличие отметки «Мне нравится» от текущего пользователя
    val canLike: Boolean,    // информация о том, может ли текущий пользователь поставить отметку «Мне нравится»
    val vanPublish: Boolean  // информация о том, может ли текущий пользователь сделать репост записи
)

object WallService {

    private var posts = emptyArray<Post>()
    private var uniqId: Int = 0

    fun add(post: Post): Post {

        posts += post.copy(id = ++uniqId)

        return posts.last()
    }

    fun update(postUpp: Post): Boolean {

        for ((index, post) in posts.withIndex()) {
            if (post.id == postUpp.id) {
                posts[index] = postUpp.copy()
                return true
            }
        }

        return false
    }

    fun clear() {
        posts = emptyArray()
        uniqId = 0
    }
}

fun main() {

    val like1 = Likes(5, false, true, true)
    val post = Post(0, 11, 1700133307, "Всем привет!", true, false, true, 10, true, like1)

    WallService.add(post)

    val post1 = Post(1, 11, 1700133307, "Ураааааа!!!", true, false, true, 10, true, like1)

    println(WallService.update(post1))


}