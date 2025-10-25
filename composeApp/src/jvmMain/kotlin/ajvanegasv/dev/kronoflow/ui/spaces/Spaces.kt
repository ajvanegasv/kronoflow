package ajvanegasv.dev.kronoflow.ui.spaces

import ajvanegasv.dev.kronoflow.presentation.SpaceViewModel
import ajvanegasv.dev.kronoflow.ui.common.components.BasicButton
import ajvanegasv.dev.kronoflow.ui.common.theme.extendedColors
import ajvanegasv.dev.kronoflow.ui.spaces.components.CreateSpaceDialog
import ajvanegasv.dev.kronoflow.ui.spaces.components.SpaceCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun Spaces() {
    val vm = koinViewModel<SpaceViewModel>()
    val spaceState by vm.spacesState.collectAsState()
    val openSpaceCreateDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
    ) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.weight(1.5f)
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
                    color = MaterialTheme.extendedColors.textSecondary,
                    modifier = Modifier.padding(bottom = 25.dp)
                )
            }
            Column (
                modifier = Modifier.weight(0.5f).padding(end = 30.dp, top = 20.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
            ) {
                BasicButton(onClick = { openSpaceCreateDialog.value = true }) {
                    Text(text = "Create Space")
                }
            }
        }
        FlowRow {
            spaceState.forEach { space ->
                SpaceCard(
                    data = space,
                    onSaveButton = { id, name -> vm.rename(id, name) }
                )
            }
        }

        when {
            openSpaceCreateDialog.value -> {
                CreateSpaceDialog(
                    onDismissRequest = { openSpaceCreateDialog.value = false }
                )
            }
        }
    }
}