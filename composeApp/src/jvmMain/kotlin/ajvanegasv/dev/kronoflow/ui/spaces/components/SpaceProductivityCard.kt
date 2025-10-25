package ajvanegasv.dev.kronoflow.ui.spaces.components

import ajvanegasv.dev.kronoflow.ui.common.components.BasicCard
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpaceProductivityCard(
    modifier: Modifier = Modifier,
) {
    BasicCard (
        modifier = modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 130.dp),
        elevation = 8.dp,
    ) {
        Text(
            text = "Space Productivity",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier.padding(15.dp)
        )
    }
}