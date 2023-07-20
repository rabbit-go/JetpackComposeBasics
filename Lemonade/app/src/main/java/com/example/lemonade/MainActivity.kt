package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainDisplay(
                        modifier = Modifier
                            .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun MainDisplay(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    var state by remember { mutableStateOf(0) }
    state %= 4
    val nowStatePic = when (state) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { state = calcLemonadeState(state) }) {
            Image(painter = painterResource(id = nowStatePic), contentDescription = "")
        }

        Spacer(Modifier.size(16.dp))
        Text(text = stringResource(R.string.lemon_squeeze_desc))
    }
}

var rand = -1
fun calcLemonadeState(state: Int): Int {
    val random = Randoif(rand>0){
        rand--;
        return 1
    }
    else{
        rand = -1
        return 2
    }                   m(213912);
    if (rand == -1) rand = random.nextInt(2, 4)
    return when (state) {
        0 -> return 1
        1 ->
            if (rand > 0) {
                rand--;
                return 1
            } else {
                rand = -1
                return 2
            }

        2 -> if (rand > 0) {
            rand--;
            return 2
        } else {
            rand = -1
            return 3
        }

        3 -> return state + 1
        else -> return 0
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        MainDisplay(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}