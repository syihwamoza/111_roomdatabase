package com.example.pertemuan9.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pertemuan9.view.EditSiswaScreen
import com.example.pertemuan9.route.DestinasiEntry
import com.example.pertemuan9.view.DetailSiswaScreen
import com.example.pertemuan9.view.EntrySiswaScreen
import com.example.pertemuan9.view.HomeScreen
import com.example.pertemuan9.view.route.DestinasiDetailSiswa
import com.example.pertemuan9.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.pertemuan9.view.route.DestinasiEditSiswa
import com.example.pertemuan9.view.route.DestinasiHome


@Composable
fun SiswaApp(navController: NavHostController= rememberNavController(), modifier: Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry =  {navController.navigate(DestinasiEntry.route)},
                navigateToItemUpdate = {
                    navController.navigate("${DestinasiDetailSiswa.route}/${it}")}
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = {navController.popBackStack()})
        }

        composable(
            route=DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetailSiswa.itemIdArg) {
                type = NavType.IntType
            }))
        {
            DetailSiswaScreen(
                navigateToEditItem ={
                    navController.navigate("${DestinasiEditSiswa.route}/$it")
                },
                navigateBack = {navController.navigateUp()}
            )
        }

        // --- TAMBAHKAN BAGIAN INI YANG TADI HILANG ---
        composable(
            route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            // Pastikan EditSiswaScreen sudah di-import di atas
            EditSiswaScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }
        // ---------------------------------------------
    }
}