package ajvanegasv.dev.kronoflow.ui.spaces

import ajvanegasv.dev.kronoflow.presentation.SpaceViewModel
import ajvanegasv.dev.kronoflow.ui.common.components.BasicButton
import ajvanegasv.dev.kronoflow.ui.common.theme.extendedColors
import ajvanegasv.dev.kronoflow.ui.spaces.components.SpaceCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 15.dp)
    ) {
        LazyVerticalGrid (
            columns = GridCells.Adaptive(minSize = 300.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 150.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
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
                        )
                    }
                    Column (
                        modifier = Modifier.weight(0.5f).padding(end = 30.dp, top = 20.dp),
                        horizontalAlignment = Alignment.End,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        BasicButton(onClick = { vm.create() }) {
                            Text(text = "Create Space")
                        }
                    }
                }
            }
            items(spaceState.size) { index ->
                val space = spaceState[index]
                SpaceCard(
                    data = space,
                    onSaveButton = { id, name -> vm.rename(id, name) },
                    onDeleteButton = { id -> vm.delete(id) },
                )
            }
        }
    }
}