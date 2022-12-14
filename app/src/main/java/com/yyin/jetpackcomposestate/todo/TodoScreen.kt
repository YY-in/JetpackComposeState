package com.yyin.jetpackcomposestate.todo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yyin.jetpackcomposestate.util.generateRandomTodoItem

//整体界面
@Composable
fun TodoScreen(
    items: List<TodoItem>,
    onAddItem: (TodoItem) -> Unit,
    onRemoveItem: (TodoItem) -> Unit
) {
    Column {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            items(items) {
                TodoRow(
                    todo = it,
                    modifier = Modifier.fillMaxWidth(),
                    onItemClicked = {onRemoveItem(it)}
                )
            }
        }

        Button(
            onClick = { onAddItem(generateRandomTodoItem()) },
            modifier = Modifier
                .padding(16.dp)
                //最大宽度
                .fillMaxWidth()
        ) {
            Text(text = "Add random item")
        }
    }

}


//代办事件的行
@Composable
fun TodoRow(
    todo: TodoItem,
    modifier: Modifier = Modifier,
    onItemClicked: (TodoItem) -> Unit,

    ) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onItemClicked(todo) },
        //均匀分布
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = todo.task)

        Icon(
            imageVector = todo.icon.imageVector,
            contentDescription = stringResource(id = todo.icon.contentDescription)
        )
    }
}