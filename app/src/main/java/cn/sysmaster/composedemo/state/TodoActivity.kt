package cn.sysmaster.composedemo.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import cn.sysmaster.composedemo.state.todo.TodoScreen
import cn.sysmaster.composedemo.state.todo.TodoViewModel
import cn.sysmaster.composedemo.ui.theme.ComposeDemoTheme

class TodoActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val viewModel: TodoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                Foo()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposeDemoTheme {
            Foo()
        }
    }

    @Composable
    private fun Foo() {
        TodoScreen(
            items = viewModel.todoItems,
            currentlyEditing = viewModel.currentEditItem,
            onAddItem = viewModel::addItem,
            onRemoveItem = viewModel::removeItem,
            onStartEdit = viewModel::onEditItemSelected,
            onEditItemChange = viewModel::onEditItemChange,
            onEditDone = viewModel::onEditDone
        )
    }
}