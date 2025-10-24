package ajvanegasv.dev.kronoflow.ui.spaces.components

import ajvanegasv.dev.kronoflow.ui.common.components.AccessButton
import ajvanegasv.dev.kronoflow.ui.common.components.BasicCard
import ajvanegasv.dev.kronoflow.ui.common.icons.Icons
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun StatusCard(title: String, value: String) {
    Row (
        modifier = Modifier
            .height(50.dp)
            .width(90.dp)
            .border(0.5.dp, Color.LightGray, shape = RoundedCornerShape(10.dp)),
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = Color(0xFF777777)
        )
        Text(
            text = value,
            color = Color(0xFF777777)
        )
    }
}

@Composable
fun SpaceCard(
    title: String,
    description: String = ""
) {
    BasicCard {
        Column (
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 5.dp)
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp
            )
            Text(
                text = description,
                fontSize = 14.sp,
                color = Color(0xFF777777),
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(
                    top = 5.dp,
                    bottom = 8.dp,
                )
            )
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
                modifier = Modifier.fillMaxWidth()
            ) {
                StatusCard("Tasks:", "0")
                StatusCard("Done:", "0")
                StatusCard("Overdue:", "0")
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.End),
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            ) {
                IconButton(
                    onClick = {},
                ) {
                    Icon(
                        imageVector = Icons.Edit,
                        contentDescription = "Edit"
                    )
                }
                FilledIconButton(
                    onClick = { },
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = Color.Red,
                    )
                ) {
                    Icon(
                        imageVector = Icons.Delete,
                        contentDescription = "Delete"
                    )
                }
                AccessButton(
                    onClick = { /* no-op */ },
                ) {
                    Icon(
                        imageVector = Icons.ArrowForward,
                        contentDescription = "Arrow Forward"
                    )
                    Text(text = "Open")
                }
            }
        }
    }
}