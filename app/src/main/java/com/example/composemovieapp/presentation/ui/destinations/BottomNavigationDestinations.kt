import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composemovieapp.R

sealed class BottomNavigationDestinations(
    val route: String,
    val title: Int,
    val icon: ImageVector,
) {

    data object Main : BottomNavigationDestinations(
        route = "main",
        title = R.string.bottom_home_title,
        icon = Icons.Default.Home
    )

    data object Saved : BottomNavigationDestinations(
        route = "saved",
        title = R.string.bottom_favorites_title,
        icon = Icons.Default.Star
    )

    data object Actors : BottomNavigationDestinations(
        route = "actors",
        title = R.string.bottom_actors_title,
        icon = Icons.Default.AccountCircle
    )

}
