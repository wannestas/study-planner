import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StudyTypeTest {
    @Test
    fun order() {
        assertTrue(StudyType.PROOFS > StudyType.EXAMS)

    }
}