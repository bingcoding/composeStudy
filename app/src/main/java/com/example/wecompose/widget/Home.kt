package com.example.wecompose.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wecompose.viewmodel.WeViewModel

@Composable
@OptIn(ExperimentalFoundationApi::class)
 fun Home(viewModel: WeViewModel) {
    Column {
        HorizontalPager(pageCount = 4) { pageIndex ->
            when (pageIndex) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(modifier = Modifier.fillMaxSize())
                2 -> Box(modifier = Modifier.fillMaxSize())
                3 -> Box(modifier = Modifier.fillMaxSize())
            }
        }
        WeBottomBar(selectedPosition = viewModel.selectedTab) {
            viewModel.selectedTab = it
        }
    }
}