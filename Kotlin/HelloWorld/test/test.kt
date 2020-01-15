import kotlin.test.*
import kotlin.Annotation.*
import org.junit.jupiter.api.TestInstance
import org.junit.Test

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MongoDAOTestJUnit5 {
    private val mongoDAO = 2

    @Test
    fun foo() {
        assertEquals(mongoDAO, 3)
    }
}