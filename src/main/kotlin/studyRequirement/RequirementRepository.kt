package studyRequirement

import StudyType
import exam.Exam
import kotlin.time.Duration

interface RequirementRepository {
    val requirements: List<StudyRequirement>

    fun getRequirementsForExam(exam: Exam): List<StudyRequirement>?

    fun createRequirement(exam: Exam, type: StudyType, duration: Duration)
}