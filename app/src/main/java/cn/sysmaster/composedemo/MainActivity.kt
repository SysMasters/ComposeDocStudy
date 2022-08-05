package cn.sysmaster.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cn.sysmaster.composedemo.ui.*
import cn.sysmaster.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Foo()
                }
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
    fun Foo() {
        //        PhotographerCard()
//        LayoutStudy()
//        SimpleColumn()
//        LazyList()
//        ScrollingList()
//        TextWithPaddingToBaseline()
//        MyOwnColumn()
//        StaggeredGridBodyContent()
//        ConstraintLayoutContent()
//        ConstraintLayoutContent2()
//        LargeLayoutContent()
//        DecoupledContent2()
        TwoTexts()
    }


}
