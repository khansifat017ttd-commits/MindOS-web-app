package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ui.theme.ElectricCyan
import com.example.ui.theme.NavyBackground
import com.example.ui.theme.NavyBorder
import com.example.ui.theme.NavySurface
import com.example.ui.theme.NavySurfaceElevated
import com.example.ui.theme.RoyalBluePrimary
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextWhite

@Composable
fun LimitationsDialog(
  onDismiss: () -> Unit
) {
  Dialog(onDismissRequest = onDismiss) {
    Surface(
      shape = RoundedCornerShape(20.dp),
      color = NavySurface,
      border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
      modifier = Modifier
        .fillMaxWidth()
        .testTag("limitations_dialog")
    ) {
      Column(
        modifier = Modifier
          .padding(20.dp)
          .verticalScroll(rememberScrollState())
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier.fillMaxWidth()
        ) {
          Icon(
            imageVector = Icons.Default.Info,
            contentDescription = null,
            tint = ElectricCyan,
            modifier = Modifier.size(24.dp)
          )
          Spacer(modifier = Modifier.width(10.dp))
          Text(
            text = "MindOS Prototype Scope",
            style = MaterialTheme.typography.titleLarge,
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
          )
          IconButton(
            onClick = onDismiss,
            modifier = Modifier.testTag("close_limitations_button")
          ) {
            Icon(Icons.Default.Close, contentDescription = "Close", tint = TextMuted)
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = "Welcome to the first working prototype of MindOS. Here is everything you need to know about its vision, capabilities, and current prototype boundaries:",
          style = MaterialTheme.typography.bodyMedium,
          color = TextMuted
        )

        Spacer(modifier = Modifier.height(14.dp))

        ScopeItem(
          title = "100% Free & No Sign-In Required",
          description = "This prototype operates completely client-side. You do not need an account, credit card, or external paid API keys to generate and preview websites."
        )

        ScopeItem(
          title = "Instant Semantic Synthesis",
          description = "MindOS parses your prompt's intent, category, and keywords to construct customized headlines, features, pricing or showcase cards, testimonials, and contact points."
        )

        ScopeItem(
          title = "Production-Ready HTML5 & CSS",
          description = "Every generation produces clean, standards-compliant HTML5 and responsive modern CSS. Tap the Code Inspector to copy and publish it to any web hosting provider."
        )

        ScopeItem(
          title = "Current Prototype Limitations",
          description = "As a v1.0 prototype, backend database connectivity and custom domain publishing are simulated in the interactive preview. All data remains safe and private on your device."
        )

        Spacer(modifier = Modifier.height(18.dp))

        Button(
          onClick = onDismiss,
          colors = ButtonDefaults.buttonColors(containerColor = RoyalBluePrimary),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("dismiss_limitations_button")
        ) {
          Text("Got It, Let's Build!", color = Color.White, fontWeight = FontWeight.SemiBold)
        }
      }
    }
  }
}

@Composable
private fun ScopeItem(title: String, description: String) {
  Card(
    colors = CardDefaults.cardColors(containerColor = NavySurfaceElevated),
    shape = RoundedCornerShape(12.dp),
    border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 4.dp)
  ) {
    Row(
      modifier = Modifier.padding(12.dp),
      verticalAlignment = Alignment.Top
    ) {
      Icon(
        imageVector = Icons.Default.CheckCircle,
        contentDescription = null,
        tint = ElectricCyan,
        modifier = Modifier
          .size(18.dp)
          .padding(top = 2.dp)
      )
      Spacer(modifier = Modifier.width(10.dp))
      Column {
        Text(
          text = title,
          style = MaterialTheme.typography.titleMedium,
          color = TextWhite,
          fontSize = 14.sp,
          fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
          text = description,
          style = MaterialTheme.typography.bodyMedium,
          color = TextMuted,
          fontSize = 12.sp,
          lineHeight = 17.sp
        )
      }
    }
  }
}
