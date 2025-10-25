package ajvanegasv.dev.kronoflow.ui.spaces.components

import ajvanegasv.dev.kronoflow.ui.common.components.BasicCard
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Dialog

@Composable
fun CreateSpaceDialog(
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        var visible by remember { mutableStateOf(false) }
        LaunchedEffect(Unit) { visible = true }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(animationSpec = tween(180)) + scaleIn(initialScale = 0.95f, animationSpec = tween(200)),
            exit = fadeOut(animationSpec = tween(140)) + scaleOut(targetScale = 0.95f, animationSpec = tween(140)),
            label = "dialog_anim"
        ) {
            BasicCard {
                Column {

                }
            }
        }
    }
}