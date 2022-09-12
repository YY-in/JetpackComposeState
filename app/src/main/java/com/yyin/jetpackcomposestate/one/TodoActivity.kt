package com.yyin.jetpackcomposestate.one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.yyin.jetpackcomposestate.todo.TodoItem
import com.yyin.jetpackcomposestate.todo.TodoScreen
import com.yyin.jetpackcomposestate.ui.theme.JetpackComposeStatusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeStatusTheme {
                TodoActivityScreen()
            }
        }
    }

    //将属性的get、set操作交给另一个对象生成
    private val todoViewModel by viewModels<TodoViewModel>()

    @Composable
    private fun TodoActivityScreen() {

        //todoItems 是一个LiveData 即原先定义的_todoItems
        //observeAsState 把它转成一个State对象
        //对于 LiveData的任何改变State都能知道，只要集合发生变，就会触发委托类的get、set方法
        val items: List<TodoItem> by todoViewModel.todoItems.observeAsState(listOf())

        TodoScreen(
            items = items,                                   //状态向下流动
            onAddItem = { todoViewModel.addItem(it) },       //事件向上流动
            onRemoveItem = {todoViewModel.removeItem(it)}
        )
    }


}

