package com.example.wecompose.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wecompose.R
import com.example.wecompose.ui.theme.WeComposeTheme
import com.example.wecompose.viewmodel.WeViewModel

@Composable
fun WeBottomBar(selectedPosition: Int, onSelectedChanged: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .background(WeComposeTheme.colors.bottomBar)
    ) {
        TabItem(
            id = if (selectedPosition == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            title = "聊天",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged(0)
                },
            tint = if (selectedPosition == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
        TabItem(
            id = if (selectedPosition == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            title = "通讯录",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged.invoke(1)
                },
            tint = if (selectedPosition == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
        TabItem(
            id = if (selectedPosition == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            title = "发现",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged.invoke(2)
                },
            tint = if (selectedPosition == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
        TabItem(
            id = if (selectedPosition == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            title = "我的",
            modifier = Modifier
                .weight(1f)
                .clickable {
                    onSelectedChanged.invoke(3)
                },
            tint = if (selectedPosition == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
    }
}

@Composable
private fun TabItem(@DrawableRes id: Int, title: String, tint: Color = Color.Black, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.padding(vertical = 8.dp)) {
        Icon(painter = painterResource(id = id), contentDescription = title, modifier = Modifier.size(24.dp), tint = tint)
        Text(text = title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(id = R.drawable.ic_launcher_foreground, title = "launcher", tint = WeComposeTheme.colors.icon)
}

@Composable
@Preview(showBackground = true)
fun WeBottomBarPreview() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        var selectedTab by remember {
            mutableStateOf(0)
        }
        WeBottomBar(selectedPosition = selectedTab) {
            selectedTab=it
        }
    }
}