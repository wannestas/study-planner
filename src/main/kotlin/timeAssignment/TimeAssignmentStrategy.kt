package timeAssignment

import StudySlot
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus
import studyRequirement.RequirementRepository
import studyRequirement.StudyRequirement
import kotlin.time.Duration

abstract class TimeAssignmentStrategy(val dayDuration: Duration, requirementRepository: RequirementRepository) {

    protected var studySlots = mutableListOf<StudySlot>()
    protected var requirements = requirementRepository.requirements.map { it.copy() }.toMutableList()
    fun allotTime(): List<StudySlot> {
        var currentDay = requirements.map {it.exam}
            .maxBy { it.timeWindow.start }
            .timeWindow
            .start
            .date
        var dayTimeLeft = dayDuration
        while (requirements.isNotEmpty()) {
            while (dayTimeLeft > Duration.ZERO) {
                if (requirements.map { it.exam }.any { it.timeWindow.start.date == currentDay }) break

                val requirement = selectOptimalRequirement(currentDay) ?: break
                val allottedDuration = minOf(requirement.duration, dayTimeLeft)
                dayTimeLeft -= allottedDuration
                requirement.duration -= allottedDuration
                if (requirement.duration == Duration.ZERO) requirements.remove(requirement)
                studySlots.add(0, StudySlot(requirement.exam, requirement.type, currentDay, allottedDuration))
            }
            dayTimeLeft = dayDuration
            currentDay = currentDay.minus(DateTimeUnit.DAY)
        }
        return studySlots
    }

    abstract fun selectOptimalRequirement(currentDay: LocalDate): StudyRequirement?

//    abstract fun sortExams()
//    abstract fun createInitialSlots()
}