package com.example.meterialcompose3.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun CheckboxesRadioButtonSwitch(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CheckBoxes()
            Spacer(modifier = Modifier.height(32.dp))
            MySwitch()
            Spacer(modifier = Modifier.height(32.dp))
            RadioButtons()
        }
    }
}

data class ToggelableInfo(
    val isChecked: Boolean,
    val text: String
)

@Composable
fun CheckBoxes() {
    val checkBoxes = remember {
        mutableStateListOf(
            ToggelableInfo(
                isChecked = false,
                text = "Photo"
            ),
            ToggelableInfo(
                isChecked = false,
                text = "Videos"
            ),
            ToggelableInfo(
                isChecked = false,
                text = "Audio"
            )
        )
    }

    var triState by remember {
        mutableStateOf(ToggleableState.Indeterminate)
    }
    val toggleTriState = {
        triState = when (triState) {
            ToggleableState.Indeterminate -> ToggleableState.On
            ToggleableState.On -> ToggleableState.Off
            else -> ToggleableState.On
        }
        checkBoxes.indices.forEach { index ->
            checkBoxes[index] = checkBoxes[index].copy(
                isChecked = triState == ToggleableState.On
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable {
                toggleTriState()
            }
            .padding(end = 16.dp)
    ) {
        TriStateCheckbox(state = triState, onClick = {
            toggleTriState
        })
    }
    Text(text = "File types")

    checkBoxes.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    checkBoxes[index] = info.copy(
                        isChecked = !info.isChecked
                    )
                }
                .padding(end = 16.dp)
        ) {
            Checkbox(
                checked = info.isChecked,
                onCheckedChange = { isChecked ->
                    checkBoxes[index] = info.copy(
                        isChecked = isChecked
                    )
                }
            )
            Text(text = info.text)
        }
    }
}


@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switch by remember {
        mutableStateOf(
            ToggelableInfo(
                isChecked = false,
                text = "Dark Mode"
            )
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = switch.text)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = switch.isChecked,
            onCheckedChange = { isChecked ->
                switch = switch.copy(
                    isChecked = isChecked
                )
            },
            thumbContent = {
                Icon(
                    imageVector = if (switch.isChecked) {
                        Icons.Default.Check
                    } else {
                        Icons.Default.Close
                    }, contentDescription = null
                )
            }
        )
    }
}


@Composable
fun RadioButtons() {
    val radioButton = remember {
        mutableStateListOf(
            ToggelableInfo(
                isChecked = true,
                text = "Photo"
            ),
            ToggelableInfo(
                isChecked = false,
                text = "Videos"
            ),
            ToggelableInfo(
                isChecked = false,
                text = "Audio"
            )
        )
    }

    radioButton.forEachIndexed { index, info ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(start = 32.dp)
                .clickable {
                    radioButton.replaceAll {
                        it.copy(
                            isChecked = it.text == info.text
                        )
                    }
                }
                .padding(end = 16.dp)
        ) {
            RadioButton(
                selected = info.isChecked,
                onClick = {
                    radioButton.replaceAll {
                        it.copy(
                            isChecked = it.text == info.text
                        )
                    }
                }
            )
            Text(text = info.text)
        }
    }
}