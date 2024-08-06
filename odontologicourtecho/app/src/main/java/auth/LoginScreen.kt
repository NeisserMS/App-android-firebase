package auth

import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import io.dev.odontologico_urtecho.ui.theme.OdontologicourtechoTheme
import androidx.navigation.compose.rememberNavController
import io.dev.odontologico_urtecho.ui.theme.ColorPrimary
import androidx.compose.ui.res.painterResource
import io.dev.odontologico_urtecho.R

@Composable
fun LoginScreen(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Odontología Urtecho",
                fontSize = 24.sp,
                color = ColorPrimary,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            BasicTextField(
                value = username,
                onValueChange = { username = it },
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_user),
                                contentDescription = "Username Icon",
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp)
                            ) {
                                if (username.isEmpty()) {
                                    Text("Username", color = Color.Gray)
                                }
                                innerTextField()
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Password field with icon
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = PasswordVisualTransformation(),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                            .fillMaxWidth()
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_password),
                                contentDescription = "Password Icon",
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .align(Alignment.CenterVertically)
                            )
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 16.dp)
                            ) {
                                if (password.isEmpty()) {
                                    Text("Password", color = Color.Gray)
                                }
                                innerTextField()
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it }
                )
                Text(text = "Recordar")
            }

            Button(
                onClick = {
                    navController.navigate("moduleA")
                },
                colors = ButtonDefaults.buttonColors(containerColor = ColorPrimary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    OdontologicourtechoTheme {
        val navController = rememberNavController()
        LoginScreen(navController)
    }
}
