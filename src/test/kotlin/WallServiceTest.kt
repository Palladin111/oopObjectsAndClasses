import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val like1 = Likes(5, false, true, true)
        val post = Post(0, 11, 1700133307, "Всем привет!", true, false, true, 10, true, like1)
        val postAdd = WallService.add(post)

        assertNotEquals(post.id, postAdd.id)
    }
}