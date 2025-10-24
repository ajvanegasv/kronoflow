package ajvanegasv.dev.kronoflow.ui.common.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val arrowForward: ImageVector
    get() {
        if (imageVector != null) return imageVector!!

        imageVector = ImageVector.Builder(
            name = "arrowForward",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF1f1f1f))
            ) {
                moveTo(647f, 520f)
                horizontalLineTo(160f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(487f)
                lineTo(423f, 216f)
                lineToRelative(57f, -56f)
                lineToRelative(320f, 320f)
                lineToRelative(-320f, 320f)
                lineToRelative(-57f, -56f)
                lineToRelative(224f, -224f)
                close()
            }
        }.build()

        return imageVector!!
    }

private var imageVector: ImageVector? = null

