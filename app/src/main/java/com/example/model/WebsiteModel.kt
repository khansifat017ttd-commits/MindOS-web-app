package com.example.model

data class WebsiteFeature(
  val iconName: String,
  val title: String,
  val description: String
)

data class ShowcaseItem(
  val title: String,
  val subtitle: String,
  val detail: String,
  val badge: String
)

data class Testimonial(
  val author: String,
  val role: String,
  val quote: String,
  val ratingStars: Int = 5
)

data class ContactSection(
  val heading: String,
  val subtext: String,
  val email: String,
  val location: String,
  val ctaLabel: String
)

data class GeneratedWebsite(
  val id: String,
  val originalPrompt: String,
  val brandName: String,
  val category: String,
  val styleTheme: String,
  val accentHex: String,
  val heroHeadline: String,
  val heroSubhead: String,
  val ctaPrimary: String,
  val ctaSecondary: String,
  val featuresHeadline: String,
  val features: List<WebsiteFeature>,
  val showcaseHeadline: String,
  val showcaseItems: List<ShowcaseItem>,
  val testimonials: List<Testimonial>,
  val contact: ContactSection,
  val htmlCode: String,
  val createdAtMillis: Long = System.currentTimeMillis()
)
