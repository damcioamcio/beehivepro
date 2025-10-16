package com.example.beehivepro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.beehivepro.ui.theme.BeehiveProTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BeehiveProTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column {
                        Row {
                            Greeting(
                                name = "Android",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        Row(horizontalArrangement = Arrangement.Center) {
                            SimpleForm(
                                modifier = Modifier.padding(
                                    innerPadding
                                )
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                    }

                }
            }
        }
    }
}


@Composable
fun SimpleForm(modifier: Modifier = Modifier) {
    val text = remember { mutableStateOf("") }
    val isFormValid by remember { derivedStateOf { text.value.isNotBlank() } }
    Column {
        TextField(

            modifier = modifier.fillMaxWidth(),
            value = text.value,
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = ""
                )
            },
            textStyle = TextStyle(textAlign = TextAlign.Center),
            onValueChange = { text.value = it },
            label = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource( id = R.string.formular_add_beehive_text_field_placeholder),
                    textAlign = TextAlign.Center
                )
            })
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = { println("Text eingegeben: ${text.value}") },
            modifier = Modifier.align(Alignment.End),
            enabled = isFormValid
        ) { Text(text = "Absenden") }
    }

}

@Preview
@Composable
fun SimpleFormPreview() {
    SimpleForm()
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BeehiveProTheme {
        Greeting("Android")
    }
}