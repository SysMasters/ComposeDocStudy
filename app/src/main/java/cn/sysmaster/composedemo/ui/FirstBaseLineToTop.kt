package cn.sysmaster.composedemo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cn.sysmaster.composedemo.ui.theme.ComposeDemoTheme

fun Modifier.firstBaselineToTop(firstBaselineToTop: Dp) =
    this.then(layout { measurable, constraints ->
        // 测量元素
        val placeable = measurable.measure(constraints)
        // 测量之后，获取元素的基线值
        val firstBaseline = placeable[FirstBaseline]
        // 元素新的Y坐标 = 新基线值 - 旧基线值
        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY
        layout(placeable.width, height) {
            // 设置元素位置
            placeable.placeRelative(0, placeableY)
        }
    })

@Composable
fun TextWithPaddingToBaseline() {
    ComposeDemoTheme {
        Text(
            "Hi there!",
            Modifier
                .firstBaselineToTop(24.dp)
                .background(Color.Red)
        )
    }
}