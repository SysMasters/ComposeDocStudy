package cn.sysmaster.composedemo.ui

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        val (button, text) = createRefs()
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }
        Text(
            text = "Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
                centerHorizontallyTo(parent)
            }
        )
    }
}

@Composable
fun ConstraintLayoutContent2() {
    ConstraintLayout {
        val (button1, button2, text) = createRefs()
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button1")
        }
        Text(
            text = "Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button1.bottom, margin = 16.dp)
                centerAround(button1.end)
            }
        )
        val barrier = createEndBarrier(button1, text)
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button2) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(barrier, margin = 16.dp)
            }
        ) {
            Text("Button2")
        }

    }

}


@Composable
fun LargeLayoutContent() {
    ConstraintLayout {
        val text = createRef()
        val quideline = createGuidelineFromStart(fraction = 0.5f)
        Text(
            text = "Text费点劲了康师傅惊呆了说会计分录的时间里解放军的流口水加了控件反倒是",
            modifier = Modifier.constrainAs(text) {
                linkTo(start = quideline, end = parent.end)
                width = Dimension.preferredWrapContent
            }
        )
    }

}


@Composable
fun DecoupledContent() {
    val margin = 16.dp
    ConstraintLayout {
        val (button, text) = createRefs()
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = margin)
            }
        ) {
            Text("Button")
        }
        Text(
            text = "Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = margin)
            }
        )
    }
}


@Composable
fun DecoupledContent2() {
    BoxWithConstraints {
        val contraints = if (maxWidth < maxHeight) {
            decoupledConstraints(16.dp)// 竖屏
        } else {
            decoupledConstraints(160.dp)// 横屏
        }
        ConstraintLayout(contraints) {
            Button(
                onClick = { },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }
            Text(
                text = "Text",
                modifier = Modifier.layoutId("text")
            )
        }
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")
        constrain(button) {
            top.linkTo(parent.top, margin)
        }
        constrain(text) {
            top.linkTo(button.bottom, margin)
        }
    }
}
