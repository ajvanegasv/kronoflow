package ajvanegasv.dev.kronoflow.ui.common.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.ui.graphics.Color

val KronoDarkColors: ColorScheme = darkColorScheme(
    // Azul principal de Kronoflow (botones "Create", "Open")
    primary = Color(0xFF0B6EFD),
    onPrimary = Color.White,
    inversePrimary = Color.Black,
    primaryContainer = Color(0xFF004494),
    onPrimaryContainer = Color(0xFFD4E3FF),

    // Naranja/Coral para tags y elementos destacados
    secondary = Color(0xFFFF8A3D),
    onSecondary = Color(0xFF1A1D21),
    secondaryContainer = Color(0xFF8B4A1F),
    onSecondaryContainer = Color(0xFFFFDCC5),

    // Azul terciario para elementos alternativos
    tertiary = Color(0xFF4FB3BF),
    onTertiary = Color(0xFF1A1D21),
    tertiaryContainer = Color(0xFF2C5F66),
    onTertiaryContainer = Color(0xFFD4F1F4),

    // Fondos - negro/gris muy oscuro del dashboard
    background = Color(0xFF0D1117),
    onBackground = Color(0xFFE6E9EF),

    // Superficie de cards y contenedores
    surface = Color(0xFF161B22),
    onSurface = Color(0xFFE6E9EF),

    // Superficies variantes (sidebar, headers, cards elevadas)
    surfaceVariant = Color(0xFF1F2429),
    onSurfaceVariant = Color(0xFFB4BAC5),
    surfaceContainer = Color(0xFF1A1F26),
    surfaceContainerHigh = Color(0xFF21262D),
    surfaceContainerHighest = Color(0xFF2D333B),

    // Estados y bordes
    outline = Color(0xFF30363D),
    outlineVariant = Color(0xFF21262D),

    // Errores
    error = Color(0xFFFF6B6B),
    onError = Color(0xFF1A1D21),
    errorContainer = Color(0xFF8C1D18),
    onErrorContainer = Color(0xFFFFDAD6),
)

val KronoDarkExtendedColors = KronoThemeExtendedColors(
    textSecondary = Color(0xFF93A3B5)
)