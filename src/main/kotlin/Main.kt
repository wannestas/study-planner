import exam.Exam
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import studyRequirement.RequirementRepositoryImpl
import timeAssignment.GreedyAssignmentStrategy
import kotlin.time.Duration.Companion.hours

public val Int.gaming: String
    get() = "gaming"

fun main(args: Array<String>) {
//    val examRepository = ExamRepositoryImpl()
    val meetkunde = Exam(LocalDateTime(2023, 6, 29, 12, 0), "Meetkunde")
    val analyse = Exam(LocalDateTime(2023, 6, 27, 8, 0), "Analyse")
    val requirementRepository = RequirementRepositoryImpl()
    requirementRepository.createRequirement(meetkunde, StudyType.THEORY, 18.hours)
    requirementRepository.createRequirement(meetkunde, StudyType.EXERCISES, 18.hours)
    requirementRepository.createRequirement(meetkunde, StudyType.PROOFS, 9.hours)
    requirementRepository.createRequirement(meetkunde, StudyType.EXAMS, 9.hours)

    requirementRepository.createRequirement(analyse, StudyType.EXAMS, 6.hours)
    requirementRepository.createRequirement(analyse, StudyType.PROOFS, 6.hours)
    val strategy = GreedyAssignmentStrategy( 7.hours, requirementRepository)
    strategy.allotTime().forEach(::println)

//    TODO: CURSED, I just need the LocalDateTime of the current time!!!!!
//    println(LocalDateTime(Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())))
}