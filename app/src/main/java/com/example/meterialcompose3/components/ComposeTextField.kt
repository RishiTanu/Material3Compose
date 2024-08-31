package com.example.meterialcompose3.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.math.sin

@Composable
fun ComposeTextField(modifier: Modifier = Modifier) {

    Box(modifier = modifier) {

        //basicTextField, TextField, OutlinedTextField
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var filledText by remember {
                mutableStateOf("")
            }
            TextField(
                value = filledText,
                onValueChange = {
                    filledText = it
                },
                enabled = true,
                readOnly = false,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Right
                ),
                label = {
                    Text(text = "Enter a weight")
                },
                placeholder = {
                    Text(text = "weight")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.MailOutline, contentDescription = "Add")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Outlined.Done, contentDescription = "Add")
                },
                prefix = {
                    Text(text = "Rs")
                },
                suffix = {
                    Text(text = "Kg")
                },
                supportingText = {
                    Text(text = "*required field")
                },
                isError = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        println("Hello World!")
                    }
                ),
                singleLine = true,
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(16.dp))
            var outlinedText by remember {
                mutableStateOf("")
            }

            OutlinedTextField(
                value = outlinedText,
                onValueChange = {
                    outlinedText = it
                },
                enabled = true,
                readOnly = false,
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Right
                ),
                label = {
                    Text(text = "Enter a weight")
                },
                placeholder = {
                    Text(text = "weight")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.MailOutline, contentDescription = "Add")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Outlined.Done, contentDescription = "Add")
                },
                prefix = {
                    Text(text = "Rs")
                },
                suffix = {
                    Text(text = "Kg")
                },
                supportingText = {
                    Text(text = "*required field")
                },
                isError = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        println("Hello World!")
                    }
                ),
                singleLine = true,
                maxLines = 2,
            )
        }
    }
}