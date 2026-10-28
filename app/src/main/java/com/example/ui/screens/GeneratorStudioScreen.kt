package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Casino
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.InspirationChip
import com.example.MainUiState
import com.example.R
import com.example.ui.theme.ElectricCyan
import com.example.ui.theme.NavyBackground
import com.example.ui.theme.NavyBorder
import com.example.ui.theme.NavySurface
import com.example.ui.theme.NavySurfaceElevated
import com.example.ui.theme.RoyalBlueDark
import com.example.ui.theme.RoyalBlueLight
import com.example.ui.theme.RoyalBluePrimary
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextWhite

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GeneratorStudioScreen(
  state: MainUiState,
  inspirationChips: List<InspirationChip>,
  onPromptChange: (String) -> Unit,
  onSelectVibe: (String) -> Unit,
  onSelectInspiration: (InspirationChip) -> Unit,
  onRandomizeIdea: () -> Unit,
  onGenerateClick: () -> Unit,
  onOpenPreview: () -> Unit,
  onOpenLimitations: () -> Unit,
  modifier: Modifier = Modifier
) {
  val vibes = listOf("Royal Cyber", "Deep Navy Minimal", "Futuristic Glass", "Electric Blue")
  val keyboardController = LocalSoftwareKeyboardController.current
  val focusManager = LocalFocusManager.current

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(NavyBackground)
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .imePadding()
        .verticalScroll(rememberScrollState())
        .padding(16.dp)
    ) {
      // Top Tag Badge
      Box(
        modifier = Modifier
          .clip(CircleShape)
          .background(RoyalBluePrimary.copy(alpha = 0.2f))
          .border(1.dp, RoyalBlueLight.copy(alpha = 0.5f), CircleShape)
          .padding(horizontal = 12.dp, vertical = 5.dp)
      ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
          Icon(
            imageVector = Icons.Default.AutoAwesome,
            contentDescription = null,
            tint = ElectricCyan,
            modifier = Modifier.size(14.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "NEXT-GEN AI WEB CONCEPT",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricCyan,
            letterSpacing = 0.5.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Mandatory Exact Heading: "Your Mind. Your Ideas. Your Digital World."
      Text(
        text = "Your Mind. Your Ideas. Your Digital World.",
        style = MaterialTheme.typography.headlineLarge,
        color = TextWhite,
        fontWeight = FontWeight.ExtraBold,
        lineHeight = 34.sp,
        modifier = Modifier.testTag("mindos_main_heading")
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Vision Description
      Text(
        text = "MindOS is a futuristic concept where people describe their ideas and AI turns those dreams into fully realized, responsive websites. No coding required, no paid API keys—just pure imagination translated into digital reality.",
        style = MaterialTheme.typography.bodyLarge,
        color = TextMuted,
        lineHeight = 22.sp,
        modifier = Modifier.testTag("mindos_vision_description")
      )

      Spacer(modifier = Modifier.height(18.dp))

      // Hero Canvas Card with Generated Illustration
      Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = NavySurface),
        border = androidx.compose.foundation.BorderStroke(1.dp, NavyBorder),
        modifier = Modifier
          .fillMaxWidth()
          .height(160.dp)
          .testTag("hero_banner_card")
      ) {
        Box(modifier = Modifier.fillMaxSize()) {
          Image(
            painter = painterResource(id = R.drawable.hero_mindos_canvas_1793007922942),
            contentDescription = "MindOS Futuristic Interface",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
          )

          // Subtle gradient overlay for readability
          Box(
            modifier = Modifier
              .fillMaxSize()
              .background(
                Brush.verticalGradient(
                  colors = listOf(
                    Color.Transparent,
                    NavyBackground.copy(alpha = 0.88f)
                  )
                )
              )
          )

          Column(
            modifier = Modifier
              .align(Alignment.BottomStart)
              .padding(14.dp)
          ) {
            Text(
              text = "Neural Web Architecture Studio",
              style = MaterialTheme.typography.titleMedium,
              color = TextWhite,
              fontWeight = FontWeight.Bold
            )
            Text(
              text = "Describe your website idea below and synthesize it live",
              style = MaterialTheme.typography.bodySmall,
              color = ElectricCyan,
              fontSize = 11.sp
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(18.dp))

      // Prompt Box Card
      Card(
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = NavySurface),
        border = androidx.compose.foundation.BorderStroke(1.dp, RoyalBlueDark),
        modifier = Modifier
          .fillMaxWidth()
          .testTag("prompt_input_card")
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(
              imageVector = Icons.Default.Lightbulb,
              contentDescription = null,
              tint = ElectricCyan,
              modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Describe the website you imagine",
              style = MaterialTheme.typography.titleMedium,
              color = TextWhite,
              fontWeight = FontWeight.SemiBold,
              modifier = Modifier.weight(1f)
            )

            // Random Idea Generator Button
            IconButton(
              onClick = {
                onRandomizeIdea()
              },
              modifier = Modifier
                .size(32.dp)
                .testTag("randomize_idea_button")
            ) {
              Icon(
                imageVector = Icons.Default.Casino,
                contentDescription = "Randomize Idea",
                tint = ElectricCyan,
                modifier = Modifier.size(18.dp)
              )
            }

            if (state.prompt.isNotEmpty()) {
              IconButton(
                onClick = { onPromptChange("") },
                modifier = Modifier
                  .size(32.dp)
                  .testTag("clear_prompt_button")
              ) {
                Icon(
                  imageVector = Icons.Default.Clear,
                  contentDescription = "Clear Prompt",
                  tint = TextMuted,
                  modifier = Modifier.size(18.dp)
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(10.dp))

          // Fully interactive multi-line text box
          OutlinedTextField(
            value = state.prompt,
            onValueChange = onPromptChange,
            placeholder = {
              Text(
                text = "e.g., A cozy neighborhood bakery called 'Golden Crust' with artisanal sourdough specials, coffee brews, daily hours, and customer reviews...",
                color = TextMuted.copy(alpha = 0.7f),
                fontSize = 14.sp,
                lineHeight = 20.sp
              )
            },
            minLines = 3,
            maxLines = 6,
            singleLine = false,
            keyboardOptions = KeyboardOptions(
              capitalization = KeyboardCapitalization.Sentences,
              imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
              onDone = {
                keyboardController?.hide()
                focusManager.clearFocus()
              }
            ),
            colors = OutlinedTextFieldDefaults.colors(
              focusedTextColor = TextWhite,
              unfocusedTextColor = TextWhite,
              focusedContainerColor = NavyBackground,
              unfocusedContainerColor = NavyBackground,
              focusedBorderColor = RoyalBlueLight,
              unfocusedBorderColor = NavyBorder,
              cursorColor = ElectricCyan
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("website_description_input")
          )

          Spacer(modifier = Modifier.height(14.dp))

          // Quick Inspiration Chips Row
          Text(
            text = "Tap a preset idea to explore instantly:",
            style = MaterialTheme.typography.labelSmall,
            color = TextMuted,
            fontSize = 12.sp
          )

          Spacer(modifier = Modifier.height(8.dp))

          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
          ) {
            inspirationChips.forEach { chip ->
              Box(
                modifier = Modifier
                  .clip(RoundedCornerShape(8.dp))
                  .background(NavySurfaceElevated)
                  .border(1.dp, NavyBorder, RoundedCornerShape(8.dp))
                  .clickable {
                    onSelectInspiration(chip)
                    keyboardController?.hide()
                  }
                  .padding(horizontal = 10.dp, vertical = 6.dp)
                  .testTag("inspiration_chip_${chip.title.lowercase().replace(" ", "_").replace("☕_", "").replace("🚀_", "").replace("🎨_", "").replace("🧘_", "").replace("🍕_", "").replace("🐾_", "")}")
              ) {
                Text(
                  text = chip.title,
                  fontSize = 12.sp,
                  color = ElectricCyan,
                  fontWeight = FontWeight.Medium
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

          // Style Theme Selector
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
          ) {
            Icon(
              imageVector = Icons.Default.Palette,
              contentDescription = null,
              tint = TextMuted,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
              text = "Visual Aesthetic:",
              style = MaterialTheme.typography.labelSmall,
              color = TextMuted,
              fontSize = 12.sp
            )
          }

          Spacer(modifier = Modifier.height(8.dp))

          Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
              .fillMaxWidth()
              .horizontalScroll(rememberScrollState())
          ) {
            vibes.forEach { vibe ->
              val isSelected = state.selectedVibe == vibe
              Box(
                modifier = Modifier
                  .clip(RoundedCornerShape(8.dp))
                  .background(if (isSelected) RoyalBluePrimary else NavySurfaceElevated)
                  .border(
                    width = 1.dp,
                    color = if (isSelected) ElectricCyan else NavyBorder,
                    shape = RoundedCornerShape(8.dp)
                  )
                  .clickable { onSelectVibe(vibe) }
                  .padding(horizontal = 12.dp, vertical = 8.dp)
              ) {
                Text(
                  text = vibe,
                  fontSize = 12.sp,
                  fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                  color = if (isSelected) Color.White else TextMuted
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(18.dp))

          // Inline Synthesis Feedback during generation
          AnimatedVisibility(
            visible = state.isGenerating,
            enter = fadeIn(),
            exit = fadeOut()
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
                .background(RoyalBlueDark.copy(alpha = 0.3f), RoundedCornerShape(10.dp))
                .border(1.dp, RoyalBlueLight.copy(alpha = 0.4f), RoundedCornerShape(10.dp))
                .padding(12.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator(
                  color = ElectricCyan,
                  strokeWidth = 2.dp,
                  modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                  text = state.generationStepText,
                  style = MaterialTheme.typography.bodySmall,
                  color = ElectricCyan,
                  fontWeight = FontWeight.SemiBold
                )
              }
              Spacer(modifier = Modifier.height(8.dp))
              LinearProgressIndicator(
                progress = { state.generationProgress },
                color = RoyalBlueLight,
                trackColor = NavySurfaceElevated,
                modifier = Modifier
                  .fillMaxWidth()
                  .height(4.dp)
                  .clip(RoundedCornerShape(2.dp))
              )
            }
          }

          // Mandatory Button Labeled: "Generate My Website"
          Button(
            onClick = {
              keyboardController?.hide()
              focusManager.clearFocus()
              onGenerateClick()
            },
            enabled = !state.isGenerating,
            colors = ButtonDefaults.buttonColors(
              containerColor = RoyalBluePrimary,
              disabledContainerColor = RoyalBluePrimary.copy(alpha = 0.6f)
            ),
            shape = RoundedCornerShape(12.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp),
            modifier = Modifier
              .fillMaxWidth()
              .height(54.dp)
              .testTag("generate_my_website_button")
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.Center
            ) {
              if (state.isGenerating) {
                CircularProgressIndicator(
                  color = Color.White,
                  strokeWidth = 2.5.dp,
                  modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                  text = "Synthesizing Website...",
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White
                )
              } else {
                Icon(
                  imageVector = Icons.Default.AutoAwesome,
                  contentDescription = null,
                  tint = Color.White,
                  modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                  text = "Generate My Website",
                  fontSize = 16.sp,
                  fontWeight = FontWeight.Bold,
                  color = Color.White,
                  letterSpacing = 0.3.sp
                )
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Direct Access to Active Sample Website
      if (state.currentWebsite != null) {
        Card(
          shape = RoundedCornerShape(14.dp),
          colors = CardDefaults.cardColors(containerColor = NavySurface),
          border = androidx.compose.foundation.BorderStroke(1.dp, RoyalBlueLight.copy(alpha = 0.6f)),
          modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpenPreview() }
            .testTag("quick_preview_banner_card")
        ) {
          Row(
            modifier = Modifier.padding(14.dp),
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
                text = "Live Website: ${state.currentWebsite.brandName}",
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
              )
              Text(
                text = "${state.currentWebsite.category} • Tap to view live in simulator",
                style = MaterialTheme.typography.bodySmall,
                color = ElectricCyan,
                fontSize = 12.sp
              )
            }
            Icon(
              imageVector = Icons.Default.ArrowForward,
              contentDescription = "View Website",
              tint = ElectricCyan,
              modifier = Modifier.size(22.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Non-technical Prototype Guidance Bar
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = NavySurfaceElevated.copy(alpha = 0.6f)),
        modifier = Modifier
          .fillMaxWidth()
          .clickable { onOpenLimitations() }
      ) {
        Row(
          modifier = Modifier.padding(12.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(
            imageVector = Icons.Default.HelpOutline,
            contentDescription = null,
            tint = TextMuted,
            modifier = Modifier.size(18.dp)
          )
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Curious how MindOS works? View prototype details & scope",
            style = MaterialTheme.typography.bodySmall,
            color = TextMuted,
            fontSize = 12.sp,
            modifier = Modifier.weight(1f)
          )
        }
      }

      Spacer(modifier = Modifier.height(24.dp))
    }
  }
}
