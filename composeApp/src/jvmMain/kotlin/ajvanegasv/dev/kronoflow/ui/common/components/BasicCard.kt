package ajvanegasv.dev.kronoflow.ui.common.components

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BasicCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier
            .defaultMinSize(minWidth = 300.dp, minHeight = 200.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        content()
    }
}