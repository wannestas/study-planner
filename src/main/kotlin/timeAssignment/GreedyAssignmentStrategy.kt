package timeAssignment

import exam.Exam
import exam.ExamRepository
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import studyRequirement.RequirementRepository
import studyRequirement.StudyRequirement
import kotlin.time.Duration

class GreedyAssignmentStrategy(dayDuration: Duration, requirementRepository: RequirementRepository): TimeAssignmentStrategy(dayDuration, requirementRepository) {


    // TODO: StudyType seems to be selected in reverse order
    override fun selectOptimalRequirement(currentDay: LocalDate) = requirements.filter { it.exam.timeWindow.start.date > currentDay }
            .minWithOrNull(compareBy<StudyRequirement> {currentDay.daysUntil(it.exam.timeWindow.start.date)}
                .thenByDescending {it.type})

}