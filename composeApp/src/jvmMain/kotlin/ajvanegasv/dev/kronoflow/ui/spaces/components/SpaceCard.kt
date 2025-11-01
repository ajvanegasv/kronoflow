package ajvanegasv.dev.kronoflow.ui.spaces.components

import ajvanegasv.dev.kronoflow.domain.model.Space
import ajvanegasv.dev.kronoflow.ui.common.components.AccessButton
import ajvanegasv.dev.kronoflow.ui.common.components.BasicButton
import ajvanegasv.dev.kronoflow.ui.common.components.BasicCard
import ajvanegasv.dev.kronoflow.ui.common.icons.Icons
import ajvanegasv.dev.kronoflow.ui.common.theme.extendedColors
import ajvanegasv.dev.kronoflow.utils.getRelativeTime
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.exposed.v1.core.dao.id.EntityID

private enum class State { Edit, Delete, Wait }

@Composable
private fun StatusCard(title: String, value: String) {
    val borderShape = RoundedCornerShape(10.dp)
    Box(
        modifier = Modifier
            .padding(top = 7.dp)
    ) {
        Box(
            modifier = Modifier
                .height(56.dp)
                .width(110.dp)
                .border(0.5.dp, MaterialTheme.extendedColors.textSecondary, shape = borderShape)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = value,
                    color = MaterialTheme.extendedColors.textSecondary,
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = 10.dp, y = (-13).dp)
                .background(MaterialTheme.colorScheme.surfaceContainerHighest)
        ) {
            Text(
                text = title,
                fontSize = 13.sp,
                color = MaterialTheme.extendedColors.textSecondary,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 1.dp)
            )
        }
    }
}

@Composable
private fun DeleteButtons(
    state: MutableState<State>,
    modifier: Modifier = Modifier,
    onDeleteButton: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        BasicButton(
            onClick = {
                onDeleteButton()
                state.value = State.Wait
            } ,
        ) {
            Text(text = "Delete")
        }
        AccessButton(
            onClick = {
                state.value = State.Wait
            } ,
        ) {
            Text(text = "Cancel")
        }
    }
}

@Composable
private fun PrincipalButtons(state: MutableState<State>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = Modifier.padding(top = 10.dp)
    ) {
        BasicButton(
            onClick = { state.value = State.Edit },
        ) {
            Icon(
                imageVector = Icons.Edit,
                contentDescription = "Edit",
                modifier = Modifier.size(18.dp)
            )
            Text(text = "Rename")
        }
        BasicButton(
            onClick = { state.value = State.Delete },
        ) {
            Icon(
                imageVector = Icons.Delete,
                contentDescription = "Delete",
                modifier = Modifier.size(18.dp)
            )
            Text(text = "Delete")
        }
        AccessButton(
            onClick = { /* no-op */ },
        ) {
            Icon(
                imageVector = Icons.ArrowForward,
                contentDescription = "Arrow Forward",
                modifier = Modifier.size(18.dp)
            )
            Text(text = "Open")
        }
    }
}

@Composable
private fun RenameButtons(
    state: MutableState<State>,
    modifier: Modifier = Modifier,
    onSaveButton: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        modifier = modifier
    ) {
        AccessButton(
            onClick = {
                onSaveButton()
                state.value = State.Wait
            } ,
        ) {
            Text(text = "Save")
        }
        BasicButton(
            onClick = { state.value = State.Wait },
        ) {
            Text(text = "Cancel")
        }
    }
}

@Composable
private fun TitleSpace(
    title: String,
    state: MutableState<State>,
    onValueChange: (String) -> Unit = {},
) {
    when (state.value) {
        State.Edit -> {
            val focusRequester = remember { FocusRequester() }
            val textFieldValue by remember(title) {
                mutableStateOf(
                    TextFieldValue(
                        text = title,
                        selection = TextRange(title.length)
                    )
                )
            }

            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
            }

            BasicTextField(
                value = textFieldValue,
                onValueChange = { onValueChange(it.text) },
                textStyle = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                ),
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .padding(start = 5.dp)
            )
        }
        State.Wait, State.Delete -> {
            Text(
                text = title,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.padding(start = 5.dp)
            )
        }
    }
}

@Composable
fun SpaceCard(
    data: Space,
    onSaveButton: (id: EntityID<Int>, name: String) -> Unit,
    onDeleteButton: (id: EntityID<Int>) -> Unit,
) {
    val state = remember{ mutableStateOf(State.Wait) }
    val space = remember { mutableStateOf(data) }

    LaunchedEffect(state.value) {
        if (state.value == State.Wait) {
            space.value = data
        }
    }

    BasicCard {
        Column (
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)
        ) {
            TitleSpace(
                title = space.value.name,
                state = state,
                onValueChange = { space.value = space.value.copy(name = it) }
            )
            Text(
                text = "Viewed " + getRelativeTime(space.value.lastViewed),
                fontSize = 14.sp,
                color = MaterialTheme.extendedColors.textSecondary,
                fontWeight = FontWeight.W500,
                modifier = Modifier.padding(
                    top = 5.dp,
                    bottom = 8.dp,
                    start = 5.dp,
                ),
            )
            Row (
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                StatusCard("Tasks:", "0")
                StatusCard("Done:", "0")
                StatusCard("Overdue:", "0")
            }
            when (state.value) {
                State.Edit -> {
                    RenameButtons(
                        state,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 10.dp),
                        onSaveButton = { onSaveButton(space.value.id, space.value.name) },
                    )
                }
                State.Delete -> {
                    DeleteButtons(
                        state,
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 10.dp),
                        onDeleteButton = { onDeleteButton(space.value.id) },
                    )
                }
                State.Wait -> {
                    PrincipalButtons(state)
                }
            }
        }
    }
}