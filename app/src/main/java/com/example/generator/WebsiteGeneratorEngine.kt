package com.example.generator

import com.example.model.ContactSection
import com.example.model.GeneratedWebsite
import com.example.model.ShowcaseItem
import com.example.model.Testimonial
import com.example.model.WebsiteFeature
import java.util.UUID

object WebsiteGeneratorEngine {

  fun generateWebsite(prompt: String, chosenVibe: String = "Royal Cyber"): GeneratedWebsite {
    val cleanPrompt = prompt.trim()
    val lower = cleanPrompt.lowercase()

    // Classify intent / domain based on keywords
    val isBakeryOrFood = lower.contains("bakery") || lower.contains("coffee") || lower.contains("cafe") ||
        lower.contains("restaurant") || lower.contains("pizza") || lower.contains("food") ||
        lower.contains("bistro") || lower.contains("bar") || lower.contains("dessert") || lower.contains("cook")

    val isTechOrSaas = lower.contains("tech") || lower.contains("ai") || lower.contains("saas") ||
        lower.contains("app") || lower.contains("software") || lower.contains("cloud") ||
        lower.contains("crypto") || lower.contains("automation") || lower.contains("startup") ||
        lower.contains("tool") || lower.contains("platform")

    val isPortfolioOrDesign = lower.contains("portfolio") || lower.contains("photo") ||
        lower.contains("design") || lower.contains("art") || lower.contains("artist") ||
        lower.contains("developer") || lower.contains("creative") || lower.contains("agency")

    val isFitnessOrHealth = lower.contains("fitness") || lower.contains("gym") || lower.contains("yoga") ||
        lower.contains("health") || lower.contains("wellness") || lower.contains("workout") ||
        lower.contains("meditation") || lower.contains("coach")

    val isPetOrAnimal = lower.contains("pet") || lower.contains("dog") || lower.contains("cat") ||
        lower.contains("animal") || lower.contains("vet") || lower.contains("rescue")

    val isStoreOrShop = lower.contains("shop") || lower.contains("store") || lower.contains("fashion") ||
        lower.contains("clothing") || lower.contains("shoes") || lower.contains("jewelry") ||
        lower.contains("boutique") || lower.contains("ecommerce")

    val accentHex = when (chosenVibe) {
      "Royal Cyber" -> "#2563EB"
      "Electric Blue" -> "#0284C7"
      "Futuristic Glass" -> "#38BDF8"
      "Deep Navy Minimal" -> "#1D4ED8"
      else -> "#2563EB"
    }

    // Extract or infer a snappy brand name
    val brandName = extractBrandName(cleanPrompt, isBakeryOrFood, isTechOrSaas, isPortfolioOrDesign, isFitnessOrHealth, isPetOrAnimal, isStoreOrShop)

    val category: String
    val heroHeadline: String
    val heroSubhead: String
    val ctaPrimary: String
    val ctaSecondary: String
    val featuresHeadline: String
    val features: List<WebsiteFeature>
    val showcaseHeadline: String
    val showcaseItems: List<ShowcaseItem>
    val testimonials: List<Testimonial>
    val contact: ContactSection

    when {
      isBakeryOrFood -> {
        category = "Culinary & Cafe"
        heroHeadline = "Artisanal Flavors Crafted with Heart"
        heroSubhead = if (cleanPrompt.length > 20) {
          "Welcome to $brandName. $cleanPrompt"
        } else {
          "Hand-tossed sourdough, organic specialty brews, and oven-fresh pastries made fresh every sunrise."
        }
        ctaPrimary = "Explore Our Menu"
        ctaSecondary = "Order for Pickup"
        featuresHeadline = "Why Guests Love Our Kitchen"
        features = listOf(
          WebsiteFeature("local_fire_department", "Heritage Hearth Baking", "Slow fermented doughs baked stone-deck style for golden crusts and airy crumb."),
          WebsiteFeature("local_cafe", "Specialty Direct Roast", "Single-origin coffees sourced directly from ethical farming cooperatives."),
          WebsiteFeature("eco", "100% Organic & Local", "Every ingredient is sourced within 50 miles from community organic producers.")
        )
        showcaseHeadline = "Featured Specials of the Day"
        showcaseItems = listOf(
          ShowcaseItem("Wild Sourdough Boule", "Naturally fermented 36 hours", "$8.50", "Best Seller"),
          ShowcaseItem("Honey Cardamom Latte", "Espresso, oat milk, raw forest honey", "$5.75", "Staff Pick"),
          ShowcaseItem("Flaky Pistachio Croissant", "Laminated French butter pastry", "$4.95", "Fresh Baked")
        )
        testimonials = listOf(
          Testimonial("Elena Rostova", "Regular Guest", "The aroma as you walk in is pure bliss. The sourdough loaf is unmatched in the city!"),
          Testimonial("Marcus Vance", "Food Enthusiast", "Mind-blowing coffee and the kindest baristas. My go-to morning sanctuary.")
        )
        contact = ContactSection(
          heading = "Visit Us or Get in Touch",
          subtext = "Open Daily 7:00 AM – 6:00 PM • Outdoor patio seating available",
          email = "hello@${brandName.lowercase().replace(" ", "")}.com",
          location = "442 Artisan Way, Market District",
          ctaLabel = "Reserve a Table"
        )
      }

      isTechOrSaas -> {
        category = "Cloud & SaaS Platform"
        heroHeadline = "Empower Your Workflow with Autonomous Intelligence"
        heroSubhead = if (cleanPrompt.length > 20) {
          "$brandName brings your vision to reality: $cleanPrompt"
        } else {
          "The unified operating system for high-velocity teams. Automate repetitive tasks, analyze complex data, and ship faster."
        }
        ctaPrimary = "Start Free Trial"
        ctaSecondary = "Book Live Demo"
        featuresHeadline = "Engineered for Extreme Speed & Scale"
        features = listOf(
          WebsiteFeature("bolt", "Real-Time Synthesis", "Execute complex workflows in milliseconds with our distributed neural backbone."),
          WebsiteFeature("security", "Zero-Trust Encryption", "Enterprise-grade SOC-2 compliance with end-to-end cryptographic isolation."),
          WebsiteFeature("auto_awesome", "Intelligent Copilot", "Context-aware AI modules that adapt to your exact business schemas.")
        )
        showcaseHeadline = "Platform Capabilities"
        showcaseItems = listOf(
          ShowcaseItem("Neural Pipeline Hub", "Sync 100+ data sources seamlessly", "99.99% Uptime", "Core"),
          ShowcaseItem("Predictive Analytics", "Machine-learned anomaly detection", "10x Faster", "Popular"),
          ShowcaseItem("Enterprise Federation", "Granular RBAC, audit trails & SSO", "SOC-2 Type II", "Security")
        )
        testimonials = listOf(
          Testimonial("Sarah Chen", "VP of Engineering at HyperScale", "We cut our deployment turnaround by 65% in the first week. Phenomenal architecture."),
          Testimonial("Devon Lee", "Founder & CTO", "Clean, lightning-quick, and rock-solid reliability. Highly recommended.")
        )
        contact = ContactSection(
          heading = "Ready to elevate your tech stack?",
          subtext = "Deploy in under 5 minutes with our instant cloud sandbox.",
          email = "support@${brandName.lowercase().replace(" ", "")}.io",
          location = "San Francisco, CA & Distributed Worldwide",
          ctaLabel = "Get API Access"
        )
      }

      isPortfolioOrDesign -> {
        category = "Creative Studio & Portfolio"
        heroHeadline = "Designing Meaningful Visual Experiences"
        heroSubhead = if (cleanPrompt.length > 20) {
          "Personal studio of $brandName. $cleanPrompt"
        } else {
          "Specializing in futuristic brand identities, high-fidelity digital interfaces, and spatial art direction."
        }
        ctaPrimary = "View Case Studies"
        ctaSecondary = "Inquire About Projects"
        featuresHeadline = "Disciplines & Creative Practice"
        features = listOf(
          WebsiteFeature("palette", "Visual Identity & Systems", "Crafting memorable logos, typographic hierarchies, and brand guideline systems."),
          WebsiteFeature("devices", "Interactive Digital Product", "Building pixel-perfect web and mobile experiences designed for emotional resonance."),
          WebsiteFeature("motion_photos_on", "3D Motion & Direction", "Creating cinematic spatial animations that bring brand narratives to life.")
        )
        showcaseHeadline = "Selected Projects (2025–2026)"
        showcaseItems = listOf(
          ShowcaseItem("Aether Spatial OS", "Interface architecture & design system", "Featured in Awwwards", "Product Design"),
          ShowcaseItem("Luminary Labs Identity", "Complete rebrand and digital portal", "2M+ Impressions", "Branding"),
          ShowcaseItem("Nexus Kinetic Typography", "Experimental generative 3D type", "Art Exhibition", "Motion")
        )
        testimonials = listOf(
          Testimonial("Julian Voss", "Creative Director", "An extraordinary eye for polish and typography. Delivered beyond all expectations!"),
          Testimonial("Clara Thorne", "Head of Product", "Transformed our rough concepts into an iconic product interface.")
        )
        contact = ContactSection(
          heading = "Let's build something unforgettable",
          subtext = "Currently accepting select freelance inquiries & design partnerships.",
          email = "studio@${brandName.lowercase().replace(" ", "")}.design",
          location = "Brooklyn, NY / Remote",
          ctaLabel = "Start a Project"
        )
      }

      isFitnessOrHealth -> {
        category = "Health & Human Movement"
        heroHeadline = "Transform Your Mind, Body, and Vitality"
        heroSubhead = if (cleanPrompt.length > 20) {
          "$brandName: $cleanPrompt"
        } else {
          "Holistic movement coaching, state-of-the-art recovery labs, and an empowering community built to help you flourish."
        }
        ctaPrimary = "Claim First Class Free"
        ctaSecondary = "View Schedule"
        featuresHeadline = "The Wellness Philosophy"
        features = listOf(
          WebsiteFeature("fitness_center", "Custom Performance Tracks", "Tailored strength, mobility, and endurance sessions led by certified coaches."),
          WebsiteFeature("spa", "Cold Plunge & Contrast Therapy", "Accelerate recovery with infrared saunas, cryo tubs, and restorative breathwork."),
          WebsiteFeature("favorite", "Mindful Nutrition Guidance", "Data-backed nutritional protocols tailored to your unique metabolic profile.")
        )
        showcaseHeadline = "Popular Membership Tiers"
        showcaseItems = listOf(
          ShowcaseItem("Foundations Pass", "Unlimited group sessions & open gym access", "$129/mo", "Popular"),
          ShowcaseItem("Total Recovery Lab", "Daily contrast sauna & private coaching", "$210/mo", "All-Inclusive"),
          ShowcaseItem("Weekend Reset Retreat", "Full 2-day immersive breath & movement workshop", "$180", "Workshop")
        )
        testimonials = listOf(
          Testimonial("Maya Lin", "Member since 2024", "Lost 25 lbs and gained incredible mental clarity. The community here feels like family."),
          Testimonial("David O'Connor", "Marathon Runner", "The recovery facility kept me injury-free all season. Truly top tier.")
        )
        contact = ContactSection(
          heading = "Take your first step toward vitality",
          subtext = "Lockers, showers, and complimentary electrolyte bar included with all visits.",
          email = "team@${brandName.lowercase().replace(" ", "")}.com",
          location = "780 Meridian Ave, West End",
          ctaLabel = "Book an Induction"
        )
      }

      isPetOrAnimal -> {
        category = "Pet Care & Sanctuary"
        heroHeadline = "Compassionate Care for Every Beloved Companion"
        heroSubhead = if (cleanPrompt.length > 20) {
          "Welcome to $brandName. $cleanPrompt"
        } else {
          "Premier pet wellness, loving adoption matching, and gentle grooming designed for your furry family members."
        }
        ctaPrimary = "Meet Pets for Adoption"
        ctaSecondary = "Book Grooming Session"
        featuresHeadline = "Our Paws-First Promise"
        features = listOf(
          WebsiteFeature("pets", "Low-Stress Handling", "Certified fear-free groomers and handlers who treat your companions like royalty."),
          WebsiteFeature("health_and_safety", "Holistic Wellness Checks", "Gentle preventative checkups, vaccination clinics, and nutrition advice."),
          WebsiteFeature("volunteer_activism", "Ethical Adoption Network", "100% no-kill shelter partnership connecting loving humans with rescued animals.")
        )
        showcaseHeadline = "Community Services"
        showcaseItems = listOf(
          ShowcaseItem("Deluxe Spa Grooming", "Warm bubble bath, nail trim & coat blowout", "$55", "Top Rated"),
          ShowcaseItem("Pawsitive Day Camp", "Structured outdoor play in supervised turf yards", "$35/day", "Active"),
          ShowcaseItem("Puppy Socialization", "Weekly manners & positive reinforcement classes", "$120/mo", "Classes")
        )
        testimonials = listOf(
          Testimonial("Samantha Green", "Dog Parent", "My golden retriever gets so excited when we pull up! The gentlest, kindest team."),
          Testimonial("Kenji Takahashi", "Cat Adopter", "Adopted our sweet tuxedo cat through them. The adoption process was smooth and so caring.")
        )
        contact = ContactSection(
          heading = "Stop by with your four-legged best friend",
          subtext = "Open 7 days a week with plenty of pet-friendly parking.",
          email = "hello@${brandName.lowercase().replace(" ", "")}.org",
          location = "310 Meadow Lane, Parkside",
          ctaLabel = "Schedule a Visit"
        )
      }

      isStoreOrShop -> {
        category = "Modern Commerce & Goods"
        heroHeadline = "Curated Essentials Designed for Conscious Living"
        heroSubhead = if (cleanPrompt.length > 20) {
          "Discover $brandName. $cleanPrompt"
        } else {
          "Thoughtfully crafted apparel, durable home goods, and sustainable everyday accessories built to last generations."
        }
        ctaPrimary = "Shop New Arrivals"
        ctaSecondary = "Explore Lookbook"
        featuresHeadline = "Craftsmanship Without Compromise"
        features = listOf(
          WebsiteFeature("verified", "Guaranteed Durability", "Built with certified sustainable materials backed by our 5-year replacement pledge."),
          WebsiteFeature("local_shipping", "Carbon-Neutral Delivery", "Zero-plastic biodegradable packaging with 100% offset transit."),
          WebsiteFeature("published_with_changes", "Ethical Fair-Trade", "Direct partnerships with artisan makers receiving living wages and equity.")
        )
        showcaseHeadline = "Seasonal Curations"
        showcaseItems = listOf(
          ShowcaseItem("Heavyweight Organic Tee", "100% GOTS organic cotton in slate blue", "$42", "Essential"),
          ShowcaseItem("Canvas Daypack 24L", "Waxed waterproof cotton with brass accents", "$118", "Trending"),
          ShowcaseItem("Ceramic Pour-Over Dripper", "Handcrafted stoneware with matte glaze", "$36", "Handmade")
        )
        testimonials = listOf(
          Testimonial("Liam Sterling", "Verified Buyer", "The build quality of the daypack is astonishing. Premium feel without the ridiculous markup."),
          Testimonial("Zoe Miller", "Conscious Consumer", "Love supporting ethical brands. The organic tee fits like a dream.")
        )
        contact = ContactSection(
          heading = "Join the mindful movement",
          subtext = "Sign up for secret vault releases and 10% off your first purchase.",
          email = "orders@${brandName.lowercase().replace(" ", "")}.store",
          location = "Flagship Store: 104 Mercer St, SoHo",
          ctaLabel = "Subscribe for 10% Off"
        )
      }

      else -> {
        // Universal Custom Generator that weaves user's input directly into the site
        category = "Modern Digital Concept"
        heroHeadline = generateHeadlineFromPrompt(cleanPrompt)
        heroSubhead = if (cleanPrompt.isNotEmpty()) {
          "Bringing your idea to life: \"$cleanPrompt\". Thoughtfully designed for clarity, impact, and seamless user delight."
        } else {
          "A stunning modern platform synthesized instantly from your idea with clean design and responsive architecture."
        }
        ctaPrimary = "Get Started Today"
        ctaSecondary = "Learn More"
        featuresHeadline = "Core Highlights & Features"
        features = listOf(
          WebsiteFeature("star", "Intuitively Designed", "Engineered specifically to fulfill the core vision of $brandName with effortless clarity."),
          WebsiteFeature("speed", "Blazing Fast Performance", "Lightweight, responsive layout optimized for mobile smartphones and desktop displays alike."),
          WebsiteFeature("thumb_up", "Built for Real Users", "Delightful touch targets, accessible typography, and inviting royal blue aesthetics.")
        )
        showcaseHeadline = "Featured Highlights"
        showcaseItems = listOf(
          ShowcaseItem("Core Experience", "Tailored to your specific request", "Active", "Version 1.0"),
          ShowcaseItem("Mobile Optimized", "Smooth scrolling and touch responsive", "100%", "Mobile-Ready"),
          ShowcaseItem("Clean HTML & CSS", "Ready for deployment to any web host", "Instant", "Code Included")
        )
        testimonials = listOf(
          Testimonial("Jordan Taylor", "Early Tester", "MindOS took my concept and turned it into a tangible, elegant website layout in seconds."),
          Testimonial("Avery Reed", "Community Member", "The layout and colors look like a professionally designed agency site!")
        )
        contact = ContactSection(
          heading = "Ready to connect with us?",
          subtext = "Feel free to reach out anytime. We would love to hear your thoughts and feedback.",
          email = "contact@${brandName.lowercase().replace(" ", "")}.com",
          location = "Global Online Presence",
          ctaLabel = "Send a Message"
        )
      }
    }

    val htmlCode = generateCleanHtmlDocument(
      brandName = brandName,
      category = category,
      heroHeadline = heroHeadline,
      heroSubhead = heroSubhead,
      ctaPrimary = ctaPrimary,
      ctaSecondary = ctaSecondary,
      featuresHeadline = featuresHeadline,
      features = features,
      showcaseHeadline = showcaseHeadline,
      showcaseItems = showcaseItems,
      testimonials = testimonials,
      contact = contact,
      accentHex = accentHex
    )

    return GeneratedWebsite(
      id = UUID.randomUUID().toString(),
      originalPrompt = cleanPrompt,
      brandName = brandName,
      category = category,
      styleTheme = chosenVibe,
      accentHex = accentHex,
      heroHeadline = heroHeadline,
      heroSubhead = heroSubhead,
      ctaPrimary = ctaPrimary,
      ctaSecondary = ctaSecondary,
      featuresHeadline = featuresHeadline,
      features = features,
      showcaseHeadline = showcaseHeadline,
      showcaseItems = showcaseItems,
      testimonials = testimonials,
      contact = contact,
      htmlCode = htmlCode
    )
  }

  private fun extractBrandName(
    prompt: String,
    isBakery: Boolean,
    isTech: Boolean,
    isPortfolio: Boolean,
    isFitness: Boolean,
    isPet: Boolean,
    isStore: Boolean
  ): String {
    // Check if user quoted a name like "Golden Crust" or called 'Something'
    val quotedMatch = Regex("[\"']([^\"']+)[\"']").find(prompt)
    if (quotedMatch != null) {
      val candidate = quotedMatch.groupValues[1].trim()
      if (candidate.length in 2..30) return candidate
    }

    val calledMatch = Regex("(?:called|named)\\s+([A-Z][a-zA-Z0-9\\s]{1,24})").find(prompt)
    if (calledMatch != null) {
      val candidate = calledMatch.groupValues[1].trim()
      if (candidate.isNotEmpty()) return candidate
    }

    return when {
      isBakery -> "Golden Crust Bakery"
      isTech -> "Nexus AI Cloud"
      isPortfolio -> "MindOS Design Portfolio"
      isFitness -> "Pulse Movement Lab"
      isPet -> "Paws & Whiskers Sanctuary"
      isStore -> "Haven Goods Co."
      prompt.isNotBlank() -> {
        val firstWords = prompt.split(" ").filter { it.isNotBlank() }.take(2).joinToString(" ")
        if (firstWords.length in 3..25) {
          firstWords.replaceFirstChar { it.uppercase() } + " Studio"
        } else {
          "MindOS Concept"
        }
      }
      else -> "MindOS Portal"
    }
  }

  private fun generateHeadlineFromPrompt(prompt: String): String {
    if (prompt.isBlank()) return "Turn Your Vision into a Digital Reality"
    val words = prompt.split(" ").take(7).joinToString(" ")
    return if (words.length > 40) {
      words.take(38) + "..."
    } else {
      words.replaceFirstChar { it.uppercase() }
    }
  }

  private fun generateCleanHtmlDocument(
    brandName: String,
    category: String,
    heroHeadline: String,
    heroSubhead: String,
    ctaPrimary: String,
    ctaSecondary: String,
    featuresHeadline: String,
    features: List<WebsiteFeature>,
    showcaseHeadline: String,
    showcaseItems: List<ShowcaseItem>,
    testimonials: List<Testimonial>,
    contact: ContactSection,
    accentHex: String
  ): String {
    val featureCards = features.joinToString("\n") { f ->
      """
        <div class="card">
          <div class="badge-icon">✦</div>
          <h3>${f.title}</h3>
          <p>${f.description}</p>
        </div>
      """.trimIndent()
    }

    val showcaseCards = showcaseItems.joinToString("\n") { s ->
      """
        <div class="item-card">
          <div class="item-header">
            <h4>${s.title}</h4>
            <span class="badge">${s.badge}</span>
          </div>
          <p class="sub">${s.subtitle}</p>
          <div class="item-footer">
            <span class="price">${s.detail}</span>
            <button class="btn-sm">Select</button>
          </div>
        </div>
      """.trimIndent()
    }

    val testimonialQuotes = testimonials.joinToString("\n") { t ->
      """
        <div class="testimonial">
          <p class="quote">“${t.quote}”</p>
          <div class="author">
            <strong>${t.author}</strong> — <span>${t.role}</span>
          </div>
        </div>
      """.trimIndent()
    }

    return """
      <!DOCTYPE html>
      <html lang="en">
      <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>$brandName — $category</title>
        <style>
          :root {
            --bg-color: #0A0F1D;
            --surface-color: #111827;
            --surface-elevated: #1F2937;
            --accent: $accentHex;
            --accent-glow: ${accentHex}33;
            --text-main: #FFFFFF;
            --text-muted: #9CA3AF;
            --border: #374151;
          }
          * { box-sizing: border-box; margin: 0; padding: 0; }
          body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
            background: var(--bg-color);
            color: var(--text-main);
            line-height: 1.6;
            padding: 0;
          }
          nav {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 1.25rem 2rem;
            background: rgba(17, 24, 39, 0.9);
            backdrop-filter: blur(10px);
            border-bottom: 1px solid var(--border);
            position: sticky;
            top: 0;
            z-index: 50;
          }
          .brand { font-size: 1.3rem; font-weight: 700; color: var(--text-main); }
          .brand span { color: var(--accent); }
          .hero {
            padding: 4rem 2rem;
            text-align: center;
            max-width: 800px;
            margin: 0 auto;
          }
          .tag {
            display: inline-block;
            background: var(--accent-glow);
            color: var(--accent);
            padding: 0.35rem 1rem;
            border-radius: 999px;
            font-size: 0.85rem;
            font-weight: 600;
            margin-bottom: 1.25rem;
            border: 1px solid var(--accent);
          }
          h1 {
            font-size: clamp(2rem, 5vw, 3.25rem);
            font-weight: 800;
            letter-spacing: -0.02em;
            margin-bottom: 1.25rem;
            line-height: 1.2;
          }
          p.lead {
            font-size: 1.15rem;
            color: var(--text-muted);
            margin-bottom: 2rem;
          }
          .cta-group {
            display: flex;
            gap: 1rem;
            justify-content: center;
            flex-wrap: wrap;
          }
          .btn-primary {
            background: var(--accent);
            color: #fff;
            padding: 0.85rem 1.75rem;
            border-radius: 8px;
            font-weight: 600;
            text-decoration: none;
            border: none;
            cursor: pointer;
            box-shadow: 0 4px 14px var(--accent-glow);
          }
          .btn-secondary {
            background: var(--surface-elevated);
            color: var(--text-main);
            padding: 0.85rem 1.75rem;
            border-radius: 8px;
            font-weight: 600;
            text-decoration: none;
            border: 1px solid var(--border);
            cursor: pointer;
          }
          .section {
            padding: 4rem 2rem;
            max-width: 1000px;
            margin: 0 auto;
          }
          h2 {
            font-size: 1.85rem;
            margin-bottom: 2rem;
            text-align: center;
          }
          .grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 1.5rem;
          }
          .card, .item-card, .testimonial {
            background: var(--surface-color);
            padding: 1.75rem;
            border-radius: 12px;
            border: 1px solid var(--border);
          }
          .badge-icon {
            font-size: 1.5rem;
            color: var(--accent);
            margin-bottom: 0.75rem;
          }
          .card h3 { margin-bottom: 0.5rem; }
          .card p { color: var(--text-muted); font-size: 0.95rem; }
          .badge {
            background: var(--accent-glow);
            color: var(--accent);
            padding: 0.25rem 0.6rem;
            border-radius: 4px;
            font-size: 0.75rem;
            font-weight: bold;
          }
          .item-header { display: flex; justify-content: space-between; margin-bottom: 0.5rem; }
          .sub { color: var(--text-muted); font-size: 0.9rem; margin-bottom: 1rem; }
          .item-footer { display: flex; justify-content: space-between; align-items: center; }
          .price { font-weight: 700; color: var(--text-main); }
          .btn-sm {
            background: var(--accent);
            border: none;
            color: white;
            padding: 0.35rem 0.8rem;
            border-radius: 6px;
            font-weight: 600;
            cursor: pointer;
          }
          .quote { font-style: italic; margin-bottom: 1rem; color: #E5E7EB; }
          .author { font-size: 0.9rem; color: var(--text-muted); }
          .contact-box {
            background: var(--surface-color);
            border: 1px solid var(--border);
            border-radius: 12px;
            padding: 2.5rem;
            text-align: center;
          }
          footer {
            text-align: center;
            padding: 3rem 1rem;
            color: var(--text-muted);
            border-top: 1px solid var(--border);
            font-size: 0.85rem;
          }
        </style>
      </head>
      <body>
        <nav>
          <div class="brand">$brandName <span>✦</span></div>
          <button class="btn-primary" style="padding: 0.5rem 1rem; font-size: 0.85rem;">$ctaPrimary</button>
        </nav>

        <header class="hero">
          <div class="tag">$category</div>
          <h1>$heroHeadline</h1>
          <p class="lead">$heroSubhead</p>
          <div class="cta-group">
            <button class="btn-primary">$ctaPrimary</button>
            <button class="btn-secondary">$ctaSecondary</button>
          </div>
        </header>

        <section class="section">
          <h2>$featuresHeadline</h2>
          <div class="grid">
            $featureCards
          </div>
        </section>

        <section class="section" style="background: rgba(17, 24, 39, 0.4); border-radius: 16px;">
          <h2>$showcaseHeadline</h2>
          <div class="grid">
            $showcaseCards
          </div>
        </section>

        <section class="section">
          <h2>What People Say</h2>
          <div class="grid">
            $testimonialQuotes
          </div>
        </section>

        <section class="section">
          <div class="contact-box">
            <h2>${contact.heading}</h2>
            <p style="color: var(--text-muted); margin-bottom: 1.5rem;">${contact.subtext}</p>
            <p><strong>Email:</strong> ${contact.email} &nbsp;|&nbsp; <strong>Location:</strong> ${contact.location}</p>
            <br>
            <button class="btn-primary">${contact.ctaLabel}</button>
          </div>
        </section>

        <footer>
          <p>© 2026 $brandName. All rights reserved.</p>
          <p style="margin-top: 0.5rem; font-size: 0.75rem; color: #6B7280;">Synthesized with MindOS Prototype</p>
        </footer>
      </body>
      </html>
    """.trimIndent()
  }
}
