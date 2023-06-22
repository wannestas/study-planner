import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration

data class TimeWindow(val start: LocalDateTime, val duration: Duration) {
}