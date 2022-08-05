package cn.sysmaster.composedemo.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun StaggeredGridBodyContent(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier
            .background(color = Color.LightGray)
            .padding(16.dp)
            .horizontalScroll(rememberScrollState()),
        content = {
            StaggeredGrid(modifier = modifier) {
                for (i in 0..10) {
                    Chip(
                        modifier = Modifier.padding(8.dp),
                        text = "Chip $i",
                    )
                }
            }
        }
    )
}

@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rows: Int = 3,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, contraints ->
        // 用于保存每行宽度值
        val rowWidths = IntArray(rows) { 0 }
        // 用于保存每行高度值
        val rowHeights = IntArray(rows) { 0 }

        val placeables = measurables.mapIndexed { index, measurable ->
            // 测量每一个元素
            val placeable = measurable.measure(contraints)
            val row = index % rows
            // 一行的宽度等于元素之和
            rowWidths[row] += placeable.width
            // 一行的高度，等于最高的那个元素高度
            rowHeights[row] = max(rowHeights[row], placeable.height)
            placeable
        }
        // 计算表格宽度，最宽的那行宽度
        val width = rowWidths.maxOrNull() ?: contraints.minWidth
        // 高度是所有行高之和
        val height = rowHeights.sumOf { it }
        // 设置每一行的Y坐标
        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
        }
        layout(width, height) {
            val rowX = IntArray(rows) { 0 }

            // 设置每一个元素的坐标
            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(rowX[row], rowY[row])
                rowX[row] += placeable.width
            }
        }
    }
}


@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String
) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(16.dp, 16.dp)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = text)
        }
    }
}