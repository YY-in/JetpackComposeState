package com.yyin.jetpackcomposestate.util

import com.yyin.jetpackcomposestate.todo.TodoIcon
import com.yyin.jetpackcomposestate.todo.TodoItem

fun generateRandomTodoItem(): TodoItem {
    val message = listOf(
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L"
    ).random()

    val icon =TodoIcon.values().random()
    return TodoItem(message,icon)
}
