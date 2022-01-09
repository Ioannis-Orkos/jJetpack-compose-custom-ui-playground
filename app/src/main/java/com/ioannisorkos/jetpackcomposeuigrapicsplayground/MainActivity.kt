package com.ioannisorkos.jetpackcomposeuigrapicsplayground

import android.os.Bundle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.ioannisorkos.jetpackcomposeuigrapicsplayground.ui.theme.JetpackComposeUIGrapicsPlayGroundTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeUIGrapicsPlayGroundTheme {

                val navController = rememberNavController()
                Navigation(navController = navController)

            }
        }
    }
}



@ExperimentalComposeUiApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.NavigationScreen.route
    ) {
        composable(Screen.NavigationScreen.route) {
            NavigationScreen(navController)
        }
        composable(Screen.BasicShapeScreen.route) {
            BasicShapes(navController)
        }
        composable(
            route = Screen.BasicShapeScreen.route +
                    "?id={mesID}&msg={message}",
            arguments = listOf(
                navArgument(
                    name = "mesID"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(
                    name = "message"
                ) {
                    type = NavType.StringType
                    defaultValue = "No Message"
                },
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            BasicShapes(
                navController = navController
            )
        }
    }

}


@Composable
fun NavigationScreen(navController: NavHostController){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        //Basic shape
        Button(onClick = {
            navController.navigate(Screen.BasicShapeScreen.route){
//                                navController.graph.startDestinationRoute?.let { route ->
//                                    popUpTo(route) {
//                                        saveState = true
//                                    }
//                                }
//                                launchSingleTop = true
//                                restoreState = true
            }
        }) {
            Text(text = "Basic Shapes")
        }

        Button(onClick = {
            navController.navigate(
                Screen.BasicShapeScreen.route +
                        "?id=${12}&msg=${"lOVE"}")
                {
            }
        }) {
            Text(text = "Basic Shapes With Args")
        }
    }
}



sealed class Screen(val route: String) {
    object NavigationScreen: Screen("navigation_screen")
    object BasicShapeScreen: Screen("basic_shape_screen")
}



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeUIGrapicsPlayGroundTheme {
        Greeting("Android")
    }
}