package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.generator.WebsiteGeneratorEngine
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("MindOS", appName)
  }

  @Test
  fun `website generator produces complete website with features and code`() {
    val result = WebsiteGeneratorEngine.generateWebsite(
      prompt = "A modern tech platform called MindOS that turns ideas into websites",
      chosenVibe = "Royal Cyber"
    )
    assertNotNull(result)
    assertTrue(result.brandName.isNotBlank())
    assertTrue(result.features.isNotEmpty())
    assertTrue(result.showcaseItems.isNotEmpty())
    assertTrue(result.htmlCode.contains("<!DOCTYPE html>"))
  }

  @Test
  fun `verify web assets are bundled for live browser preview`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val inputStream = context.assets.open("web/index.html")
    assertNotNull(inputStream)
    val content = inputStream.bufferedReader().use { it.readText() }
    assertTrue(content.contains("MindOS") || content.contains("<div id=\"root\">"))
  }
}
