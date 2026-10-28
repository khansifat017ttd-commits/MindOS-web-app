package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.StudioScreen
import com.example.ui.theme.ElectricCyan
import com.example.ui.theme.NavyBackground
import com.example.ui.theme.NavyBorder
import com.example.ui.theme.NavySurface
import com.example.ui.theme.NavySurfaceElevated
import com.example.ui.theme.RoyalBluePrimary
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextWhite

@Composable
fun MindOSTopBar(
  currentScreen: StudioScreen,
  savedCount: Int,
  onNavigateScreen: (StudioScreen) -> Unit,
  onOpenLimitations: () -> Unit
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .background(NavySurface)
      .border(
        width = 1.dp,
        color = NavyBorder,
        shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp)
      )
      .statusBarsPadding()
      .padding(horizontal = 16.dp, vertical = 10.dp)
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically
    ) {
      // MindOS Brand Icon
      Box(
        modifier = Modifier
          .size(38.dp)
          .clip(RoundedCornerShape(10.dp))
          .background(NavyBackground)
          .border(1.dp, RoyalBluePrimary, RoundedCornerShape(10.dp))
          .clickable { onNavigateScreen(StudioScreen.GENERATOR) },
        contentAlignment = Alignment.Center
      ) {
        Image(
          painter = painterResource(id = R.drawable.ic_mindos_logo_1793007908798),
          contentDescription = "MindOS Logo",
          contentScale = ContentScale.Crop,
          modifier = Modifier.size(36.dp)
        )
      }

      Spacer(modifier = Modifier.width(12.dp))

      Column(modifier = Modifier.weight(1f)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Text(
            text = "MindOS",
            style = MaterialTheme.typography.titleLarge,
            color = TextWhite,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.5.sp
          )
          Spacer(modifier = Modifier.width(8.dp))
          Box(
            modifier = Modifier
              .background(RoyalBluePrimary.copy(alpha = 0.25f), RoundedCornerShape(4.dp))
              .border(0.5.dp, RoyalBluePrimary, RoundedCornerShape(4.dp))
              .padding(horizontal = 6.dp, vertical = 2.dp)
          ) {
            Text(
              text = "PROTOTYPE",
              fontSize = 9.sp,
              fontWeight = FontWeight.Bold,
              color = ElectricCyan,
              letterSpacing = 0.5.sp
            )
          }
        }
        Text(
          text = "AI Web Architecture Engine",
          style = MaterialTheme.typography.bodySmall,
          color = TextMuted,
          fontSize = 11.sp
        )
      }

      // Actions
      IconButton(
        onClick = onOpenLimitations,
        modifier = Modifier.testTag("top_bar_info_button")
      ) {
        Icon(
          imageVector = Icons.Default.Info,
          contentDescription = "Prototype Scope & Info",
          tint = ElectricCyan
        )
      }

      IconButton(
        onClick = {
          if (currentScreen == StudioScreen.SAVED_GALLERY) {
            onNavigateScreen(StudioScreen.GENERATOR)
          } else {
            onNavigateScreen(StudioScreen.SAVED_GALLERY)
          }
        },
        modifier = Modifier.testTag("top_bar_saved_button")
      ) {
        BadgedBox(
          badge = {
            if (savedCount > 0) {
              Badge(
                containerColor = RoyalBluePrimary,
                contentColor = Color.White
              ) {
                Text(savedCount.toString(), fontSize = 10.sp)
              }
            }
          }
        ) {
          Icon(
            imageVector = Icons.Default.Bookmark,
            contentDescription = "Saved Websites",
            tint = if (currentScreen == StudioScreen.SAVED_GALLERY) ElectricCyan else TextMuted
          )
        }
      }
    }
  }
}
