package studyRequirement

import StudyType
import exam.Exam
import kotlin.time.Duration

class RequirementRepositoryImpl: RequirementRepository {
    private val _requirements = mutableListOf<StudyRequirement>()
    override val requirements: List<StudyRequirement>
        get() = _requirements.toList()

    override fun getRequirementsForExam(exam: Exam): List<StudyRequirement>? {
        return _requirements.filter { it.exam == exam }
    }

    override fun createRequirement(exam: Exam, type: StudyType, duration: Duration) {
        _requirements.add(StudyRequirement(exam, type, duration))
    }
}