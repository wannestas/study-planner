package exam

import TimeWindow
import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours

class Exam(moment: LocalDateTime,
           val courseName: String,
           duration: Duration = 3.hours, ){

    val timeWindow = TimeWindow(moment, duration)
    override fun toString(): String {
        return "exam.Exam(courseName='$courseName')"
    }


}