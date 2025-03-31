 package com.example.lumos

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lumos.ui.screens.auth.Login
import com.example.lumos.ui.screens.auth.Signup
import com.example.lumos.ui.screens.auth.Welcome
import com.example.lumos.ui.screens.assignments.AssignmentScreen
import com.example.lumos.ui.screens.student.Dashboard
import com.example.lumos.ui.screens.referenceMaterials.FileList
import com.example.lumos.ui.screens.noticeBoard.NoticeBoardScreen
import com.example.lumos.ui.screens.referenceMaterials.RefMaterial
import com.example.lumos.ui.screens.referenceMaterials.SubjectDetail
import com.example.lumos.ui.screens.assignments.ViewAssignmentScreen
import com.example.lumos.ui.screens.assignments.AddAssignmentScreen
import com.example.lumos.ui.screens.auth.SelectClassScreen
import com.example.lumos.ui.screens.auth.SelectRoleScreen
import com.example.lumos.ui.screens.auth.VerifyEmailScreen
import com.example.lumos.ui.screens.noticeBoard.NewNoticeScreen
import com.example.lumos.viewmodel.LoginViewModel


 @Composable
fun LumosNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.welcome) {
        composable(Routes.welcome) { Welcome(navController) }
        composable(Routes.signup) { Signup(navController) }
        composable(Routes.login) {
            val viewModel: LoginViewModel = viewModel()
            Login(viewModel,navController) }
        composable(Routes.selectRole) { SelectRoleScreen(navController) }
        composable(Routes.selectClass) { SelectClassScreen(
            navController,
            onSubmit = {year, course, division -> },  //ADD STUFF
        ) }
        composable(Routes.verifyEmail) { VerifyEmailScreen(navController, onVerify = {}, onResendCode = {}) }
        
        
        composable(Routes.st_dashboard) { Dashboard(navController) }
        composable(Routes.refMaterial) { RefMaterial(navController) }
        composable(Routes.noticeBoard) { NoticeBoardScreen(navController) }
        composable(Routes.assignment) { AssignmentScreen(navController) }
        //composable(Routes.profile) {  }

        
        
        composable(Routes.newAssignment) { AddAssignmentScreen(navController) }
        composable(Routes.viewAssignment) { ViewAssignmentScreen(
            navController,
            assignment = TODO(),
            students = TODO(),
        ) }
        composable(Routes.newNotice) { NewNoticeScreen(navController) }


        // Subject detail screen
        composable(
            "subjectDetail/{subject}",
            arguments = listOf(navArgument("subject") { type = NavType.StringType })
        ) { backStackEntry ->
            val subject = backStackEntry.arguments?.getString("subject") ?: ""
            SubjectDetail(navController, subject)
        }

        // File List screen (requires subject & category)
        composable(
            "fileList/{subject}/{category}",
            arguments = listOf(
                navArgument("subject") { type = NavType.StringType },
                navArgument("category") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val subject = backStackEntry.arguments?.getString("subject") ?: ""
            val category = backStackEntry.arguments?.getString("category") ?: ""
            FileList(navController, subject, category)
        }
    }
}
