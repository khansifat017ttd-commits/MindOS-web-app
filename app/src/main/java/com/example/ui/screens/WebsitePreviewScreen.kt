package com.example.ui.screens

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Devices
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Http
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.PreviewRenderMode
import com.example.ViewportMode
import com.example.model.GeneratedWebsite
import com.example.ui.theme.ElectricCyan
import com.example.ui.theme.NavyBackground
import com.example.ui.theme.NavyBorder
import com.example.ui.theme.NavySurface
import com.example.ui.theme.NavySurfaceElevated
import com.example.ui.theme.RoyalBluePrimary
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextWhite

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WebsitePreviewScreen(
  website: GeneratedWebsite,
  viewportMode: ViewportMode,
  previewRenderMode: PreviewRenderMode,
  onBackToStudio: () -> Unit,
  onToggleViewport: () -> Unit,
  onToggleRenderMode: () -> Unit,
  onOpenCodeInspector: () -> Unit,
  onShowMessage: (String) -> Unit,
  modifier: Modifier = Modifier
) {
  var selectedAccentHex by remember(website.id) { mutableStateOf(website.accentHex) }
  val accentColor = remember(selectedAccentHex) {
    try {
      Color(android.graphics.Color.parseColor(selectedAccentHex))
    } catch (_: Exception) {
      RoyalBluePrimary
    }
  }

  // Interactive visitor contact input state
  var visitorEmail by remember { mutableStateOf("") }
  var isSubmitted by remember { mutableStateOf(false) }

  Column(
    modifier = modifier
      .fillMaxSize()
      .background(NavyBackground)
  ) {
    // Top Preview Controls Toolbar
    Surface(
      color = NavySurface,
      border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 8.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Button(
          onClick = onBackToStudio,
          colors = ButtonDefaults.buttonColors(containerColor = RoyalBluePrimary),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier
            .height(38.dp)
            .testTag("back_to_studio_button")
        ) {
          Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(16.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "Studio",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
          )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = website.brandName,
            style = MaterialTheme.typography.titleMedium,
            color = TextWhite,
            fontWeight = FontWeight.Bold,
            maxLines = 1
          )
          Text(
            text = "${website.category} • MindOS Simulator",
            style = MaterialTheme.typography.bodySmall,
            color = ElectricCyan,
            fontSize = 11.sp
          )
        }

        // Toggle Web Engine vs Native View
        IconButton(
          onClick = onToggleRenderMode,
          modifier = Modifier.testTag("toggle_render_mode_button")
        ) {
          Icon(
            imageVector = if (previewRenderMode == PreviewRenderMode.WEB_ENGINE) Icons.Default.Devices else Icons.Default.Http,
            contentDescription = "Toggle Web Engine / Native View",
            tint = ElectricCyan
          )
        }

        // Viewport Switcher (Phone vs Desktop)
        IconButton(
          onClick = onToggleViewport,
          modifier = Modifier.testTag("toggle_viewport_button")
        ) {
          Icon(
            imageVector = if (viewportMode == ViewportMode.MOBILE) Icons.Default.Tv else Icons.Default.PhoneAndroid,
            contentDescription = "Toggle Viewport Mode",
            tint = ElectricCyan
          )
        }

        // View Code Button
        IconButton(
          onClick = onOpenCodeInspector,
          modifier = Modifier.testTag("open_code_button")
        ) {
          Icon(
            imageVector = Icons.Default.Code,
            contentDescription = "View Clean HTML/CSS",
            tint = TextWhite
          )
        }
      }
    }

    // Secondary Accent Palette Bar
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(NavySurfaceElevated)
        .padding(horizontal = 12.dp, vertical = 6.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Text(
        text = "Accent:",
        style = MaterialTheme.typography.labelSmall,
        color = TextMuted,
        fontSize = 11.sp
      )
      Spacer(modifier = Modifier.width(6.dp))

      val palette = listOf("#2563EB", "#0284C7", "#10B981", "#8B5CF6", "#F59E0B")
      palette.forEach { hex ->
        val colorObj = try {
          Color(android.graphics.Color.parseColor(hex))
        } catch (_: Exception) {
          RoyalBluePrimary
        }
        val isChosen = selectedAccentHex.equals(hex, ignoreCase = true)
        Box(
          modifier = Modifier
            .padding(horizontal = 4.dp)
            .size(20.dp)
            .clip(CircleShape)
            .background(colorObj)
            .border(
              width = if (isChosen) 2.dp else 1.dp,
              color = if (isChosen) Color.White else NavyBorder,
              shape = CircleShape
            )
            .clickable {
              selectedAccentHex = hex
              onShowMessage("Theme accent updated!")
            }
        )
      }

      Spacer(modifier = Modifier.weight(1f))

      // Mode indicator chip
      Box(
        modifier = Modifier
          .clip(RoundedCornerShape(6.dp))
          .background(NavyBackground)
          .clickable { onToggleRenderMode() }
          .padding(horizontal = 8.dp, vertical = 3.dp)
      ) {
        Text(
          text = if (previewRenderMode == PreviewRenderMode.WEB_ENGINE) "🌐 Real HTML5 Web" else "📱 Native Layout",
          fontSize = 11.sp,
          color = ElectricCyan,
          fontWeight = FontWeight.Medium
        )
      }
    }

    // Scrollable Preview Container or Real Web View
    Box(
      modifier = Modifier
        .weight(1f)
        .fillMaxWidth()
        .background(if (viewportMode == ViewportMode.MOBILE) Color(0xFF030712) else NavyBackground),
      contentAlignment = Alignment.TopCenter
    ) {
      if (previewRenderMode == PreviewRenderMode.WEB_ENGINE) {
        // Authentically renders the synthesized HTML5 & CSS live in real-time
        val webContainerModifier = if (viewportMode == ViewportMode.MOBILE) {
          Modifier
            .widthIn(max = 420.dp)
            .fillMaxSize()
            .padding(8.dp)
            .clip(RoundedCornerShape(14.dp))
            .border(1.dp, NavyBorder, RoundedCornerShape(14.dp))
        } else {
          Modifier.fillMaxSize()
        }

        Box(modifier = webContainerModifier) {
          AndroidView(
            factory = { ctx ->
              WebView(ctx).apply {
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                webViewClient = WebViewClient()
                loadDataWithBaseURL(null, website.htmlCode, "text/html", "UTF-8", null)
              }
            },
            update = { webView ->
              webView.loadDataWithBaseURL(null, website.htmlCode, "text/html", "UTF-8", null)
            },
            modifier = Modifier.fillMaxSize().testTag("web_engine_view")
          )
        }
      } else {
        // Native interactive Compose components
        val contentModifier = if (viewportMode == ViewportMode.MOBILE) {
          Modifier
            .widthIn(max = 420.dp)
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(NavyBackground)
            .border(1.dp, NavyBorder, RoundedCornerShape(16.dp))
        } else {
          Modifier
            .fillMaxWidth()
            .background(NavyBackground)
        }

        Column(
          modifier = contentModifier
            .verticalScroll(rememberScrollState())
            .testTag("website_preview_scroll_container")
        ) {
          // --- 1. WEBSITE NAV HEADER ---
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(NavySurface)
              .border(1.dp, NavyBorder)
              .padding(horizontal = 16.dp, vertical = 12.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = website.brandName,
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
              )

              Button(
                onClick = { onShowMessage("Action: ${website.ctaPrimary}") },
                colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.height(36.dp)
              ) {
                Text(
                  text = website.ctaPrimary,
                  fontSize = 12.sp,
                  fontWeight = FontWeight.SemiBold,
                  color = Color.White
                )
              }
            }
          }

          // --- 2. WEBSITE HERO SECTION ---
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .background(NavyBackground)
              .padding(horizontal = 20.dp, vertical = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            // Category tag
            Box(
              modifier = Modifier
                .clip(CircleShape)
                .background(accentColor.copy(alpha = 0.15f))
                .border(1.dp, accentColor, CircleShape)
                .padding(horizontal = 12.dp, vertical = 4.dp)
            ) {
              Text(
                text = website.category,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                color = accentColor
              )
            }

            Spacer(modifier = Modifier.height(14.dp))

            Text(
              text = website.heroHeadline,
              style = MaterialTheme.typography.headlineMedium,
              color = TextWhite,
              fontWeight = FontWeight.ExtraBold,
              textAlign = TextAlign.Center,
              lineHeight = 28.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = website.heroSubhead,
              style = MaterialTheme.typography.bodyMedium,
              color = TextMuted,
              textAlign = TextAlign.Center,
              lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
              horizontalArrangement = Arrangement.spacedBy(10.dp),
              modifier = Modifier.fillMaxWidth()
            ) {
              Button(
                onClick = { onShowMessage("Confirmed: ${website.ctaPrimary}") },
                colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                  .weight(1f)
                  .height(46.dp)
              ) {
                Text(
                  text = website.ctaPrimary,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              }

              OutlinedButton(
                onClick = { onShowMessage("Opened: ${website.ctaSecondary}") },
                colors = ButtonDefaults.outlinedButtonColors(contentColor = TextWhite),
                border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                  .weight(1f)
                  .height(46.dp)
              ) {
                Text(
                  text = website.ctaSecondary,
                  fontSize = 13.sp,
                  fontWeight = FontWeight.SemiBold
                )
              }
            }
          }

          HorizontalDivider(color = NavyBorder, thickness = 1.dp)

          // --- 3. FEATURES SECTION ---
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(20.dp)
          ) {
            Text(
              text = website.featuresHeadline,
              style = MaterialTheme.typography.titleLarge,
              color = TextWhite,
              fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(14.dp))

            website.features.forEach { feature ->
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = NavySurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 5.dp)
              ) {
                Row(
                  modifier = Modifier.padding(14.dp),
                  verticalAlignment = Alignment.Top
                ) {
                  Box(
                    modifier = Modifier
                      .size(36.dp)
                      .clip(CircleShape)
                      .background(accentColor.copy(alpha = 0.2f)),
                    contentAlignment = Alignment.Center
                  ) {
                    Text(text = "✦", color = accentColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                  }

                  Spacer(modifier = Modifier.width(12.dp))

                  Column {
                    Text(
                      text = feature.title,
                      style = MaterialTheme.typography.titleMedium,
                      color = TextWhite,
                      fontWeight = FontWeight.SemiBold,
                      fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                      text = feature.description,
                      style = MaterialTheme.typography.bodySmall,
                      color = TextMuted,
                      lineHeight = 17.sp
                    )
                  }
                }
              }
            }
          }

          HorizontalDivider(color = NavyBorder, thickness = 1.dp)

          // --- 4. SHOWCASE / MENU / PRODUCT SECTION ---
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .background(NavySurfaceElevated.copy(alpha = 0.5f))
              .padding(20.dp)
          ) {
            Text(
              text = website.showcaseHeadline,
              style = MaterialTheme.typography.titleLarge,
              color = TextWhite,
              fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(14.dp))

            website.showcaseItems.forEach { item ->
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = NavySurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 5.dp)
              ) {
                Column(modifier = Modifier.padding(14.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = item.title,
                      style = MaterialTheme.typography.titleMedium,
                      color = TextWhite,
                      fontWeight = FontWeight.SemiBold,
                      fontSize = 14.sp,
                      modifier = Modifier.weight(1f)
                    )
                    Box(
                      modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(accentColor.copy(alpha = 0.2f))
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                      Text(
                        text = item.badge,
                        color = accentColor,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                      )
                    }
                  }

                  Spacer(modifier = Modifier.height(4.dp))

                  Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextMuted,
                    fontSize = 12.sp
                  )

                  Spacer(modifier = Modifier.height(10.dp))

                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = item.detail,
                      style = MaterialTheme.typography.bodyLarge,
                      color = TextWhite,
                      fontWeight = FontWeight.Bold
                    )

                    Button(
                      onClick = { onShowMessage("Selected: ${item.title}") },
                      colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                      shape = RoundedCornerShape(8.dp),
                      modifier = Modifier.height(34.dp)
                    ) {
                      Text(
                        text = "Select",
                        fontSize = 12.sp,
                        color = Color.White
                      )
                    }
                  }
                }
              }
            }
          }

          HorizontalDivider(color = NavyBorder, thickness = 1.dp)

          // --- 5. TESTIMONIALS SECTION ---
          Column(
            modifier = Modifier
              .fillMaxWidth()
              .padding(20.dp)
          ) {
            Text(
              text = "Community & Reviews",
              style = MaterialTheme.typography.titleLarge,
              color = TextWhite,
              fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(14.dp))

            website.testimonials.forEach { t ->
              Card(
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = NavySurface),
                border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(vertical = 5.dp)
              ) {
                Column(modifier = Modifier.padding(14.dp)) {
                  Row {
                    repeat(t.ratingStars) {
                      Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFBBF24),
                        modifier = Modifier.size(16.dp)
                      )
                    }
                  }
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(
                    text = "“${t.quote}”",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFFE2E8F0),
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                    lineHeight = 19.sp
                  )
                  Spacer(modifier = Modifier.height(6.dp))
                  Text(
                    text = "${t.author} • ${t.role}",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextMuted,
                    fontSize = 11.sp
                  )
                }
              }
            }
          }

          HorizontalDivider(color = NavyBorder, thickness = 1.dp)

          // --- 6. INTERACTIVE CONTACT / NEWSLETTER SECTION ---
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = NavySurface),
            border = androidx.compose.foundation.BorderStroke(1.dp, accentColor.copy(alpha = 0.5f)),
            modifier = Modifier
              .fillMaxWidth()
              .padding(16.dp)
          ) {
            Column(
              modifier = Modifier.padding(18.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(
                text = website.contact.heading,
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
              )

              Spacer(modifier = Modifier.height(6.dp))

              Text(
                text = website.contact.subtext,
                style = MaterialTheme.typography.bodySmall,
                color = TextMuted,
                textAlign = TextAlign.Center
              )

              Spacer(modifier = Modifier.height(12.dp))

              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Email, contentDescription = null, tint = accentColor, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(website.contact.email, color = TextWhite, fontSize = 12.sp)
              }

              Spacer(modifier = Modifier.height(4.dp))

              Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.LocationOn, contentDescription = null, tint = accentColor, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(website.contact.location, color = TextMuted, fontSize = 12.sp)
              }

              Spacer(modifier = Modifier.height(16.dp))

              if (!isSubmitted) {
                OutlinedTextField(
                  value = visitorEmail,
                  onValueChange = { visitorEmail = it },
                  placeholder = { Text("Enter your email address...", color = TextMuted, fontSize = 13.sp) },
                  singleLine = true,
                  colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = TextWhite,
                    unfocusedTextColor = TextWhite,
                    focusedContainerColor = NavyBackground,
                    unfocusedContainerColor = NavyBackground,
                    focusedBorderColor = accentColor,
                    unfocusedBorderColor = NavyBorder,
                    cursorColor = accentColor
                  ),
                  shape = RoundedCornerShape(10.dp),
                  modifier = Modifier.fillMaxWidth().testTag("preview_contact_email_input")
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                  onClick = {
                    if (visitorEmail.contains("@")) {
                      isSubmitted = true
                      onShowMessage("Message sent! You're connected.")
                    } else {
                      onShowMessage("Please enter a valid email.")
                    }
                  },
                  colors = ButtonDefaults.buttonColors(containerColor = accentColor),
                  shape = RoundedCornerShape(10.dp),
                  modifier = Modifier
                    .fillMaxWidth()
                    .height(46.dp)
                    .testTag("preview_contact_submit_button")
                ) {
                  Icon(Icons.Default.Send, contentDescription = null, modifier = Modifier.size(16.dp))
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(website.contact.ctaLabel, fontWeight = FontWeight.SemiBold, color = Color.White)
                }
              } else {
                Box(
                  modifier = Modifier
                    .fillMaxWidth()
                    .background(accentColor.copy(alpha = 0.15f), RoundedCornerShape(10.dp))
                    .border(1.dp, accentColor, RoundedCornerShape(10.dp))
                    .padding(12.dp),
                  contentAlignment = Alignment.Center
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = accentColor, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = "Thank you! We received your request.",
                      color = TextWhite,
                      fontWeight = FontWeight.SemiBold,
                      fontSize = 13.sp
                    )
                  }
                }
              }
            }
          }

          // --- 7. WEBSITE FOOTER ---
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .background(NavySurface)
              .border(1.dp, NavyBorder)
              .padding(vertical = 24.dp, horizontal = 16.dp)
          ) {
            Column(
              modifier = Modifier.fillMaxWidth(),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text(
                text = "© 2026 ${website.brandName}. All rights reserved.",
                style = MaterialTheme.typography.bodySmall,
                color = TextMuted,
                fontSize = 11.sp
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "Synthesized with MindOS Prototype",
                style = MaterialTheme.typography.bodySmall,
                color = ElectricCyan,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium
              )
            }
          }

          Spacer(modifier = Modifier.height(30.dp))
        }
      }
    }
  }
}
