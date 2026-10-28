package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MindOSColorScheme = darkColorScheme(
  primary = RoyalBlueLight,
  onPrimary = Color.White,
  primaryContainer = RoyalBlueDark,
  onPrimaryContainer = Color.White,
  secondary = ElectricCyan,
  onSecondary = NavyBackground,
  secondaryContainer = NavySurfaceHighlight,
  onSecondaryContainer = ElectricCyan,
  tertiary = AccentPurple,
  onTertiary = Color.White,
  background = NavyBackground,
  onBackground = TextWhite,
  surface = NavySurface,
  onSurface = TextWhite,
  surfaceVariant = NavySurfaceElevated,
  onSurfaceVariant = TextMuted,
  outline = NavyBorder,
  outlineVariant = NavySurfaceHighlight,
)

@Composable
fun MindOSTheme(
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colorScheme = MindOSColorScheme,
    typography = Typography,
    content = content
  )
}
