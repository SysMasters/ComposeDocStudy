package cn.sysmaster.composedemo.state.todo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.sysmaster.composedemo.state.TodoItem

/**
 * 状态容器
 */
class TodoViewModel : ViewModel() {

    // TodoItem集合只读
    var todoItems = mutableStateListOf<TodoItem>()
        private set

    // 当前正在编辑的TodoItem索引位置
    private var currentEditPosition by mutableStateOf(-1)

    // 当前正在编辑的TodoItem对象
    val currentEditItem: TodoItem?
        get() = todoItems[currentEditPosition]

    fun addItem(item: TodoItem) {
        todoItems.add(item)
    }

    fun removeItem(item: TodoItem) {
        todoItems.remove(item)
        onEditDone()
    }

    fun onEditDone() {
        currentEditPosition = -1
    }

}