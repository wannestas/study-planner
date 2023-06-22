package studyRequirement

import StudyType
import exam.Exam
import kotlin.time.Duration

data class StudyRequirement(val exam: Exam, val type: StudyType, var duration: Duration) {


}