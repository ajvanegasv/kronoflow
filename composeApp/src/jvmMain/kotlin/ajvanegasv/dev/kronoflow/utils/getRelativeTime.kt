package ajvanegasv.dev.kronoflow.utils

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun getRelativeTime(dateTime: LocalDateTime): String {
    val nowInstant = Clock.System.now()
    val dateInstant = dateTime.toInstant(TimeZone.UTC)

    val duration = nowInstant - dateInstant

    if (duration.isNegative()) {
        return "in the future"
    }

    return when {
        duration.inWholeSeconds < 60 -> "just now"
        duration.inWholeMinutes < 60 -> "${duration.inWholeMinutes} ${if (duration.inWholeMinutes == 1L) "minute" else "minutes"} ago"
        duration.inWholeHours < 24 -> "${duration.inWholeHours} ${if (duration.inWholeHours == 1L) "hour" else "hours"} ago"
        duration.inWholeDays < 7 -> "${duration.inWholeDays} ${if (duration.inWholeDays == 1L) "day" else "days"} ago"
        duration.inWholeDays < 30 -> "${duration.inWholeDays / 7} ${if (duration.inWholeDays / 7 == 1L) "week" else "weeks"} ago"
        duration.inWholeDays < 365 -> "${duration.inWholeDays / 30} ${if (duration.inWholeDays / 30 == 1L) "month" else "months"} ago"
        else -> "${duration.inWholeDays / 365} ${if (duration.inWholeDays / 365 == 1L) "year" else "years"} ago"
    }
}