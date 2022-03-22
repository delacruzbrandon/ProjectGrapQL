package com.dcbrh.projectgraphql.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)

val AliveColor = Color(0xFF55CC44)
val DeadColor = Color(0xFFFF4747)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val Dark700 = Color(0xFF1B1B1B)
val Dark500 = Color(0xFF292929)
val Dark200 = Color(0xFF353535)

val DarkGray = Color(0xFF424242)
val MediumGray = Color(0xFF9E9E9E)
val LightGray = Color(0xFFCCCCCC)


val Colors.CharacterCardTextColor: Color
    @Composable
    get() = if (isLight) DarkGray else LightGray

val Colors.CharacterCardTextCaptionColor: Color
    @Composable
    get() = if (isLight) LightGray else MediumGray

val Colors.TopAppBarBackgroundColor: Color
    @Composable
    get() = if (isLight) Purple500 else DarkGray
