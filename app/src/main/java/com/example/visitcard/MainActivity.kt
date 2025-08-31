package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Presentation(fullName: String, function: String, modifier: Modifier = Modifier) {
   val picture = painterResource(R.drawable.android_logo)
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = picture,
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .background(Color.Black)
                .shadow(8.dp, shape = CircleShape)
                .alpha(0.8f)
        )
        Text(
            text = fullName,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)

        )
        Text(
            text = function,
            modifier = Modifier
        )
    }
}

@Composable
fun coordonnees(number: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Row (modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(R.drawable.call_24dp_1f1f1f),
                contentDescription = "numéro de teléphone"
            )
            Text(
                text = number,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(R.drawable.social),
                contentDescription = "reseau social",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = social,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(R.drawable.email_24dp_1f1f1f),
                contentDescription = "email"
            )
            Text(
                text = email,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun VisitCard() {
    Box {
        val picture = painterResource(R.drawable.ai_generated_abstract_blurred_background_of_modern_office_with_glass_walls_shows_desks_and_chairs_with_computer_free_photo)
        Image(
            painter = picture,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                //            .background(
                //                brush = Brush.verticalGradient(
                //                    colors = listOf(
                //                        Color(0xFF90CAF9),
                //                        Color(0xFFCFD8DC)
                //                    )
                //                )
                //            )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Presentation(
                fullName = "N'da desir arnold vianney",
                function = "Développeur Android",
                modifier = Modifier.weight(2f)
            )
            coordonnees(
                number = "+225 0502182091",
                social = "@Arnoldnda",
                email = "ndadesirarnold@gmail.com",
                modifier = Modifier.weight(1f)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitCardTheme {
        VisitCard()
    }
}