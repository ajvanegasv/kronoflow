package ajvanegasv.dev.kronoflow.ui.spaces

import ajvanegasv.dev.kronoflow.ui.common.components.StackCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Space() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.7f)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        StackCard("Backlog", Modifier.weight(1f))
        StackCard("This Week", Modifier.weight(1f))
        StackCard("Today", Modifier.weight(1f))
        StackCard("Done", Modifier.weight(1f))
        StackCard("Overdue", Modifier.weight(1f))
    }
}