package ajvanegasv.dev.kronoflow.ui.common.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val KronoLightColors: ColorScheme = lightColorScheme(
    // Azul principal de Kronoflow (botones "Create", "Open")
    primary = Color(0xFF0B6EFD),
    onPrimary = Color.Black,
    inversePrimary = Color.White,

    // Naranja/Coral para tags y elementos destacados
    secondary = Color(0xFFFF8A3D),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFFFE5D3),
    onSecondaryContainer = Color(0xFFB35A00),
    primaryContainer = Color.White,

    // Azul terciario para elementos alternativos
    tertiary = Color(0xFF4FB3BF),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFD4F1F4),
    onTertiaryContainer = Color(0xFF003940),

    // Fondos - gris muy claro del dashboard
    background = Color.White,
    onBackground = Color(0xFF111418),

    // Superficie de cards y contenedores
    surface = Color.White,
    onSurface = Color.Black,

    // Superficies variantes (sidebar, headers)
    surfaceVariant = Color(0xFFE6E9EF),
    onSurfaceVariant = Color.White,
    surfaceContainer = Color.White,
    surfaceContainerHigh = Color.White,
    surfaceContainerHighest = Color.White,

    // Estados y bordes
    outline = Color(0xFFDCE0E6),
    outlineVariant = Color(0xFFE6E9EF),

    // Errores
    error = Color(0xFFDC3545),
    onError = Color.White,
    errorContainer = Color(0xFFFFEDEA),
    onErrorContainer = Color(0xFF8C1D18),
)

val KronoLightExtendedColors = KronoThemeExtendedColors(
    textSecondary = Color(0xFF6B7280)
)