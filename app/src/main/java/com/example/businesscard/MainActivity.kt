package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    BusinessCard(
                        name = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f)
        )
        Column (
            modifier = modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Icon(
                painter = painterResource(R.drawable.mode_standby_24dp_e8eaed),
                contentDescription = null,
                modifier = modifier
                    .size(192.dp)
            )
            Text(
                text = stringResource(R.string.full_name),
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.job_title),
                modifier = modifier
            )
        }
        Spacer(
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f)
        )
        Column (
            modifier = modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactRow(stringResource(R.string.phone_number), painterResource(R.drawable.phone_iphone_24dp_e8eaed))
            ContactRow(stringResource(R.string.social_media), painterResource(R.drawable.tag_24dp_e8eaed))
            ContactRow(stringResource(R.string.email), painterResource(R.drawable.alternate_email_24dp_e8eaed))
        }
    }
}

@Composable
fun ContactRow (contactInfo: String, contactIcon: Painter, modifier: Modifier = Modifier) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(bottom = 16.dp)
    ){
        Icon(
            painter = contactIcon,
            contentDescription = null
        )
        Text(
            text = contactInfo,
            modifier = modifier
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard("Android")
    }
}