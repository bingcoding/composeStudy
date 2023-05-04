package com.example.wecompose.widget

import androidx.annotation.ColorLong
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.drawText
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wecompose.data.Chat
import com.example.wecompose.ui.theme.WeComposeTheme

@Composable
fun ChatList(chats: List<Chat>) {
    Column(modifier = Modifier
        .background(WeComposeTheme.colors.background)
        .fillMaxSize()) {
        WeTopBar(title = "Compose")
        LazyColumn(modifier = Modifier.background(WeComposeTheme.colors.listItem)) {
            itemsIndexed(chats) { index, chat ->
                ChatListItem(chat)
                if (index < chats.lastIndex) {
                    Divider(
                        modifier = Modifier.padding(start = 68.dp),
                        color = WeComposeTheme.colors.chatListDivider,
                        thickness = 0.8f.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(chat: Chat) {
    Row(
        Modifier
            .fillMaxWidth()
    ) {
        Image(
            painterResource(chat.friend.avatar), chat.friend.name,
            Modifier
                .padding(8.dp)
                .size(48.dp)
                .unRead(!chat.msgs.last().read, WeComposeTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(chat.friend.name, fontSize = 17.sp, color = WeComposeTheme.colors.textPrimary)
            Text(chat.msgs.last().text, fontSize = 14.sp, color = WeComposeTheme.colors.textSecondary)
        }
        Text(
            chat.msgs.last().time,
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeComposeTheme.colors.textSecondary
        )
    }
}

fun Modifier.unRead(show: Boolean, color: Color): Modifier {
    return this.drawWithContent {
        drawContent()
        if (show) {
            drawCircle(color, 5.dp.toPx(), center = Offset(size.width - 1.dp.toPx(), 1.dp.toPx()))
        }
    }
}
