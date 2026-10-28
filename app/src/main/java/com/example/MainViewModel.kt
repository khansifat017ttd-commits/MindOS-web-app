package com.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.generator.WebsiteGeneratorEngine
import com.example.model.GeneratedWebsite
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

enum class ViewportMode {
  MOBILE,
  FULL_DESKTOP
}

enum class PreviewRenderMode {
  NATIVE_UI,
  WEB_ENGINE
}

enum class StudioScreen {
  GENERATOR,
  PREVIEW,
  SAVED_GALLERY
}

data class InspirationChip(
  val title: String,
  val category: String,
  val promptText: String
)

data class MainUiState(
  val prompt: String = "",
  val selectedVibe: String = "Royal Cyber",
  val isGenerating: Boolean = false,
  val generationStepText: String = "",
  val generationProgress: Float = 0f,
  val currentWebsite: GeneratedWebsite? = null,
  val savedWebsites: List<GeneratedWebsite> = emptyList(),
  val activeScreen: StudioScreen = StudioScreen.GENERATOR,
  val viewportMode: ViewportMode = ViewportMode.MOBILE,
  val previewRenderMode: PreviewRenderMode = PreviewRenderMode.NATIVE_UI,
  val showLimitationsDialog: Boolean = false,
  val showCodeInspectorDialog: Boolean = false,
  val toastMessage: String? = null
)

class MainViewModel : ViewModel() {

  private val _uiState = MutableStateFlow(MainUiState())
  val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

  val inspirationChips = listOf(
    InspirationChip(
      title = "☕ Artisan Bakery",
      category = "Bakery & Cafe",
      promptText = "A cozy neighborhood artisanal bakery called \"Golden Crust\" featuring slow-fermented sourdough, fresh morning pastries, ethical coffee, daily specials, and opening hours."
    ),
    InspirationChip(
      title = "🚀 AI SaaS Platform",
      category = "Tech / SaaS",
      promptText = "A modern SaaS product landing page for \"NeuralFlow AI\" that automates data workflows with speed metrics, enterprise security features, and a free trial button."
    ),
    InspirationChip(
      title = "🎨 Design Studio",
      category = "Portfolio",
      promptText = "A sleek digital portfolio for \"MindOS Creative Studio\" showcasing 3D visual identities, brand case studies, interactive products, and an inquiry contact form."
    ),
    InspirationChip(
      title = "🧘 Yoga & Wellness",
      category = "Fitness",
      promptText = "A peaceful holistic wellness studio called \"Prana Sanctuary\" offering mindful yoga sessions, breathwork workshops, recovery plunge baths, and class schedules."
    ),
    InspirationChip(
      title = "🍕 Wood-Fired Pizza",
      category = "Restaurant",
      promptText = "An authentic Neapolitan pizzeria named \"Via Roma\" with crispy wood-fired crusts, secret tomato sauce recipe, table reservation booking, and delivery specials."
    ),
    InspirationChip(
      title = "🐾 Animal Rescue",
      category = "Community",
      promptText = "A compassionate non-profit pet rescue called \"Paws Haven\" with profiles of dogs & cats up for adoption, volunteer signup, and a donation link."
    )
  )

  init {
    // Generate a starter website ready for instant preview
    val defaultSample = WebsiteGeneratorEngine.generateWebsite(
      prompt = "A cozy neighborhood artisanal bakery called \"Golden Crust\" featuring slow-fermented sourdough, fresh morning pastries, ethical coffee, and daily specials.",
      chosenVibe = "Royal Cyber"
    )
    _uiState.update {
      it.copy(
        currentWebsite = defaultSample,
        savedWebsites = listOf(defaultSample)
      )
    }
  }

  fun updatePrompt(newPrompt: String) {
    _uiState.update { it.copy(prompt = newPrompt) }
  }

  fun selectVibe(vibe: String) {
    _uiState.update { it.copy(selectedVibe = vibe) }
  }

  fun selectInspiration(chip: InspirationChip) {
    _uiState.update { it.copy(prompt = chip.promptText) }
  }

  fun randomizeIdea() {
    val randomChip = inspirationChips.random()
    _uiState.update {
      it.copy(
        prompt = randomChip.promptText,
        toastMessage = "Loaded ${randomChip.category} idea!"
      )
    }
  }

  fun generateWebsite() {
    val currentPrompt = _uiState.value.prompt.ifBlank {
      "A cozy neighborhood artisanal bakery called \"Golden Crust\" featuring slow-fermented sourdough, fresh morning pastries, and ethical coffee."
    }

    // Keep the text box synced with prompt if it was blank
    _uiState.update { it.copy(prompt = currentPrompt) }

    viewModelScope.launch {
      _uiState.update {
        it.copy(
          isGenerating = true,
          generationProgress = 0.25f,
          generationStepText = "Parsing vision & intent..."
        )
      }
      delay(120)

      _uiState.update {
        it.copy(
          generationProgress = 0.55f,
          generationStepText = "Composing royal palette & typography..."
        )
      }
      delay(120)

      _uiState.update {
        it.copy(
          generationProgress = 0.85f,
          generationStepText = "Architecting responsive layout & components..."
        )
      }
      delay(120)

      val website = WebsiteGeneratorEngine.generateWebsite(
        prompt = currentPrompt,
        chosenVibe = _uiState.value.selectedVibe
      )

      _uiState.update {
        it.copy(
          isGenerating = false,
          generationProgress = 1.0f,
          generationStepText = "Ready!",
          currentWebsite = website,
          savedWebsites = (listOf(website) + it.savedWebsites).distinctBy { w -> w.id },
          activeScreen = StudioScreen.PREVIEW,
          toastMessage = "Website generated successfully!"
        )
      }
    }
  }

  fun toggleViewportMode() {
    _uiState.update {
      it.copy(
        viewportMode = if (it.viewportMode == ViewportMode.MOBILE) ViewportMode.FULL_DESKTOP else ViewportMode.MOBILE
      )
    }
  }

  fun togglePreviewRenderMode() {
    _uiState.update {
      it.copy(
        previewRenderMode = if (it.previewRenderMode == PreviewRenderMode.NATIVE_UI) PreviewRenderMode.WEB_ENGINE else PreviewRenderMode.NATIVE_UI
      )
    }
  }

  fun navigateTo(screen: StudioScreen) {
    _uiState.update { it.copy(activeScreen = screen) }
  }

  fun loadSavedWebsite(website: GeneratedWebsite) {
    _uiState.update {
      it.copy(
        currentWebsite = website,
        activeScreen = StudioScreen.PREVIEW,
        toastMessage = "Loaded ${website.brandName}"
      )
    }
  }

  fun setLimitationsDialogVisible(visible: Boolean) {
    _uiState.update { it.copy(showLimitationsDialog = visible) }
  }

  fun setCodeInspectorVisible(visible: Boolean) {
    _uiState.update { it.copy(showCodeInspectorDialog = visible) }
  }

  fun clearToast() {
    _uiState.update { it.copy(toastMessage = null) }
  }

  fun showToast(msg: String) {
    _uiState.update { it.copy(toastMessage = msg) }
  }
}
