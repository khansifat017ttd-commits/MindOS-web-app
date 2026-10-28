package com.example.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.GeneratedWebsite
import com.example.ui.theme.ElectricCyan
import com.example.ui.theme.NavyBackground
import com.example.ui.theme.NavyBorder
import com.example.ui.theme.NavySurface
import com.example.ui.theme.NavySurfaceElevated
import com.example.ui.theme.RoyalBlueDark
import com.example.ui.theme.RoyalBluePrimary
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextWhite

@Composable
fun SavedWebsitesScreen(
  savedList: List<GeneratedWebsite>,
  onSelectWebsite: (GeneratedWebsite) -> Unit,
  onBackToStudio: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxSize()
      .background(NavyBackground)
  ) {
    Surface(
      color = NavySurface,
      border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(
          onClick = onBackToStudio,
          modifier = Modifier.testTag("back_to_studio_from_saved_button")
        ) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = TextWhite
          )
        }
        Text(
          text = "Generated Websites (${savedList.size})",
          style = MaterialTheme.typography.titleMedium,
          color = TextWhite,
          fontWeight = FontWeight.Bold
        )
      }
    }

    if (savedList.isEmpty()) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(32.dp),
        contentAlignment = Alignment.Center
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Icon(
            imageVector = Icons.Default.BookmarkBorder,
            contentDescription = null,
            tint = TextMuted,
            modifier = Modifier.size(48.dp)
          )
          Spacer(modifier = Modifier.height(16.dp))
          Text(
            text = "No saved websites yet",
            style = MaterialTheme.typography.titleMedium,
            color = TextWhite
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "Describe an idea in the studio and hit 'Generate My Website' to start creating!",
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted,
            fontSize = 12.sp
          )
          Spacer(modifier = Modifier.height(20.dp))
          Button(
            onClick = onBackToStudio,
            colors = ButtonDefaults.buttonColors(containerColor = RoyalBluePrimary),
            shape = RoundedCornerShape(10.dp)
          ) {
            Text("Go to Studio", color = Color.White)
          }
        }
      }
    } else {
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .padding(16.dp)
      ) {
        items(savedList, key = { it.id }) { website ->
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = NavySurface),
            border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 6.dp)
              .clickable { onSelectWebsite(website) }
              .testTag("saved_item_${website.id}")
          ) {
            Row(
              modifier = Modifier.padding(16.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Box(
                modifier = Modifier
                  .size(44.dp)
                  .clip(RoundedCornerShape(10.dp))
                  .background(RoyalBlueDark),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  imageVector = Icons.Default.Language,
                  contentDescription = null,
                  tint = ElectricCyan,
                  modifier = Modifier.size(24.dp)
                )
              }

              Spacer(modifier = Modifier.width(12.dp))

              Column(modifier = Modifier.weight(1f)) {
                Text(
                  text = website.brandName,
                  style = MaterialTheme.typography.titleMedium,
                  color = TextWhite,
                  fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                  text = "${website.category} • ${website.styleTheme}",
                  style = MaterialTheme.typography.bodySmall,
                  color = ElectricCyan,
                  fontSize = 11.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                  text = website.originalPrompt,
                  style = MaterialTheme.typography.bodySmall,
                  color = TextMuted,
                  fontSize = 11.sp,
                  maxLines = 2
                )
              }

              Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = "Open",
                tint = TextMuted,
                modifier = Modifier.size(20.dp)
              )
            }
          }
        }
      }
    }
  }
}
