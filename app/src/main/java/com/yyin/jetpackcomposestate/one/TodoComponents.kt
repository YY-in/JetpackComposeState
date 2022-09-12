package com.yyin.jetpackcomposestate.one

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yyin.jetpackcomposestate.todo.TodoItem
import androidx.compose.material.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment

@Composable
fun TodoItemInput(onItemComplete: (TodoItem) -> Unit) {
    //创建一个状态对象，只要这个值发生变化，界面就会重组
    val (text, setText) = remember { mutableStateOf("") }

    Column {
        Row(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)

        ) {
            TodoInputText(
                text = text,
                onTextChange = setText,
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            )
            TodoInputButton(
                onClick = {  },
                text = "Add",
                modifier = Modifier.align(Alignment.CenterVertically),
                enabled = text.isNotBlank()
            )
        }
    }
}

@Composable
fun TodoInputText(text: String, onTextChange: (String) -> Unit, modifier: Modifier = Modifier) {
    TextField(
        value = text,
        onValueChange = onTextChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
        maxLines = 1,
        modifier = modifier
    )
}

@Composable
fun TodoInputButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    TextButton(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(),
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text)
    }
}


