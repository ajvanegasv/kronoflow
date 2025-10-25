package ajvanegasv.dev.kronoflow.ui.common.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BasicCard(
    modifier: Modifier = Modifier,
    elevation: Dp = 6.dp,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
            .defaultMinSize(minWidth = 300.dp, minHeight = 200.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
        ),
    ) {
        content()
    }
}