package timeAssignment

import exam.Exam
import exam.ExamRepository
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import studyRequirement.RequirementRepository
import studyRequirement.StudyRequirement
import kotlin.time.Duration

class GreedyAssignmentStrategy(dayDuration: Duration, requirementRepository: RequirementRepository): TimeAssignmentStrategy(dayDuration, requirementRepository) {


    //    override fun createInitialSlots() {
//        val lastExam = exams.last()
//        var currentDay = lastExam.timeWindow.start.date
//        var dayTimeLeft = dayDuration
//
//
////        moveForExams()
//    }
//
//
//    private fun getBestExam(date: LocalDate): Exam {
//        return exams.filter { it.timeWindow.start.date > date }
//            .minBy { date.daysUntil(it.timeWindow.start.date) }
//    private fun moveForExams() {
//        for (exam in exams.reversed()) {
////            studySlots.map { slot -> if (slot.date <= exam.timeWindow.start.date)  StudySlot(slot.exam, slot.type, slot.date.minus(DateTimeUnit.DAY), slot.duration) else slot}
//            studySlots = studySlots.map { if (it.date <= exam.timeWindow.start.date) StudySlot(it.exam, it.type, it.date.minus(DateTimeUnit.DAY), it.duration)  else it}.toMutableList()
//        }
//    }
//
//    private fun getRequirement(date: LocalDate): studyRequirements.StudyRequirement {
//        return exams.filter { it.timeWindow.start.date > date }
//            .minBy { date.daysUntil(it.timeWindow.start.date) }
//            .requirements
//            .sortedBy { it.type }
//            .reversed()
//            .first()
//    }
//
//    private fun getRequirementsForExam(exam: exam.Exam): List<StudySlot> {
//        val currentStudySlots = mutableListOf<StudySlot>()
//        for (studyRequirement in exam.requirements.sortedBy { it.type }.reversed()) {
//
//        }
//    }
    // TODO: StudyType seems to be selected in reverse order
    override fun selectOptimalRequirement(currentDay: LocalDate) = requirements.filter { it.exam.timeWindow.start.date > currentDay }
            .minWithOrNull(compareBy({currentDay.daysUntil(it.exam.timeWindow.start.date)}, {it.type})) // { currentDay.daysUntil(it.exam.timeWindow.start.date),  }

}