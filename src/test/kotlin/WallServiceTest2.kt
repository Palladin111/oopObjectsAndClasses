import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest2 {

    @Before
    fun cleareBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update() {
        val like1 = Likes(5, false, true, true)
        val post = Post(0, 11, 1700133307, "Всем привет!", true, false, true, 10, true, like1)
        val post2 = Post(1, 11, 1700133307, "Урааа!!!", true, false, true, 10, true, like1)

        WallService.add(post)

        val postUpdate = WallService.update(post2)

        assertEquals(postUpdate, true)
    }

    @Test
    fun update2() {
        val like1 = Likes(5, false, true, true)
        val post = Post(0, 11, 1700133307, "Всем привет!", true, false, true, 10, true, like1)
        val post2 = Post(2, 11, 1700133307, "Урааа!!!", true, false, true, 10, true, like1)

        WallService.add(post)

        val postUpdate = WallService.update(post2)

        assertEquals(postUpdate, false)
    }
}