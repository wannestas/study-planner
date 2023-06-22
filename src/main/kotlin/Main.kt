import exam.Exam
import exam.ExamRepositoryImpl
import kotlinx.datetime.LocalDateTime
import studyRequirement.RequirementRepositoryImpl
import timeAssignment.GreedyAssignmentStrategy
import kotlin.time.Duration.Companion.hours

public val Int.gaming: String
    get() = "gaming"

fun main(args: Array<String>) {
    val examRepository = ExamRepositoryImpl()
    val meetkunde = Exam(LocalDateTime(2023, 6, 29, 12, 0), "Meetkunde")
    val requirementRepository = RequirementRepositoryImpl()
    requirementRepository.createRequirement(meetkunde, StudyType.THEORY, 18.hours)
    requirementRepository.createRequirement(meetkunde, StudyType.EXERCISES, 18.hours)
    requirementRepository.createRequirement(meetkunde, StudyType.PROOFS, 9.hours)
    requirementRepository.createRequirement(meetkunde, StudyType.EXAMS, 9.hours)

    val strategy = GreedyAssignmentStrategy(6.hours, requirementRepository)
    println(strategy.allotTime())
}