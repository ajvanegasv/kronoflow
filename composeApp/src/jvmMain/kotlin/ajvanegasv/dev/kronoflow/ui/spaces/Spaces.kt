package ajvanegasv.dev.kronoflow.ui.spaces

import ajvanegasv.dev.kronoflow.ui.spaces.components.SpaceCard
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Spaces() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Text(
            text = "Manage Spaces",
            fontSize = 30.0.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Create, rename, delete and open Spaces. Each Space is an independent task dashboard.",
            fontSize = 18.0.sp,
            fontWeight = FontWeight.W500,
            color = Color(0xFF777777),
            modifier = Modifier.padding(bottom = 25.dp)
        )
        FlowRow {
            SpaceCard("My Space", "18 tasks * Updated 2h ago")
        }
    }
}