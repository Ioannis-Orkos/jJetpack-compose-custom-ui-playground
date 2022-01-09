package com.ioannisorkos.jetpackcomposeuigrapicsplayground

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@Composable
fun BasicShapes(navController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue))
    {

    }

    Button(onClick = {
        navController.navigateUp()
    }) {
        Text(text = "Back")
    }

    val mes:String? = navController.currentBackStackEntry?.arguments?.getString("message")
    mes?.let { Text(text = it) }


}