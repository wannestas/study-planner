import exam.Exam
import kotlinx.datetime.LocalDate
import studyRequirement.StudyRequirement
import kotlin.time.Duration

data class StudySlot(val exam: Exam, val studyType: StudyType, val date: LocalDate, val duration: Duration) {

}