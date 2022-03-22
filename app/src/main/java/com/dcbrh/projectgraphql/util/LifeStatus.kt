package com.dcbrh.projectgraphql.util

import androidx.compose.ui.graphics.Color
import com.dcbrh.projectgraphql.ui.theme.AliveColor
import com.dcbrh.projectgraphql.ui.theme.DeadColor

enum class LifeStatus(var color: Color) {
    Alive(AliveColor),
    Dead(DeadColor)
}