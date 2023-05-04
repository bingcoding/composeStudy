package com.example.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wecompose.ui.theme.WeComposeTheme
import com.example.wecompose.viewmodel.WeViewModel
import com.example.wecompose.widget.ChatList
import com.example.wecompose.widget.ChatPage
import com.example.wecompose.widget.Home
import com.example.wecompose.widget.WeBottomBar

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: WeViewModel = viewModel()
            WeComposeTheme(viewModel.theme) {
                Home(viewModel)
                ChatPage()
            }
        }
    }


}

