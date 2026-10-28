export function generateWebsite(prompt, chosenVibe = 'Royal Cyber') {
  const cleanPrompt = (prompt || '').trim();
  const lower = cleanPrompt.toLowerCase();

  const isBakeryOrFood = lower.includes('bakery') || lower.includes('coffee') || lower.includes('cafe') ||
    lower.includes('restaurant') || lower.includes('pizza') || lower.includes('food') ||
    lower.includes('bistro') || lower.includes('dessert') || lower.includes('bar');

  const isTechOrSaas = lower.includes('tech') || lower.includes('ai') || lower.includes('saas') ||
    lower.includes('app') || lower.includes('software') || lower.includes('cloud') ||
    lower.includes('startup') || lower.includes('automation') || lower.includes('platform');

  const isPortfolioOrDesign = lower.includes('portfolio') || lower.includes('design') ||
    lower.includes('photo') || lower.includes('art') || lower.includes('artist') ||
    lower.includes('developer') || lower.includes('creative') || lower.includes('agency');

  const isFitnessOrHealth = lower.includes('fitness') || lower.includes('gym') || lower.includes('yoga') ||
    lower.includes('health') || lower.includes('wellness') || lower.includes('workout') ||
    lower.includes('meditation');

  const isPetOrAnimal = lower.includes('pet') || lower.includes('dog') || lower.includes('cat') ||
    lower.includes('animal') || lower.includes('rescue') || lower.includes('vet');

  const isStoreOrShop = lower.includes('shop') || lower.includes('store') || lower.includes('fashion') ||
    lower.includes('clothing') || lower.includes('boutique') || lower.includes('ecommerce');

  const accentHex = {
    'Royal Cyber': '#2563EB',
    'Electric Blue': '#0284C7',
    'Futuristic Glass': '#38BDF8',
    'Deep Navy Minimal': '#1D4ED8',
    'Emerald Tech': '#10B981',
    'Cyber Purple': '#8B5CF6'
  }[chosenVibe] || '#2563EB';

  const brandName = extractBrandName(cleanPrompt, isBakeryOrFood, isTechOrSaas, isPortfolioOrDesign, isFitnessOrHealth, isPetOrAnimal, isStoreOrShop);

  let category = '';
  let heroHeadline = '';
  let heroSubhead = '';
  let ctaPrimary = '';
  let ctaSecondary = '';
  let featuresHeadline = '';
  let features = [];
  let showcaseHeadline = '';
  let showcaseItems = [];
  let testimonials = [];
  let contact = {};

  if (isBakeryOrFood) {
    category = 'Culinary & Artisan Cafe';
    heroHeadline = 'Handcrafted Flavors Baked with Soul';
    heroSubhead = cleanPrompt.length > 20
      ? `Welcome to ${brandName}. ${cleanPrompt}`
      : 'Naturally fermented sourdoughs, organic single-origin coffees, and oven-fresh croissants baked daily at dawn.';
    ctaPrimary = 'Explore Menu';
    ctaSecondary = 'Order for Pickup';
    featuresHeadline = 'Why Guests Return Every Morning';
    features = [
      { title: 'Stone-Deck Baking', description: 'Long-fermented artisan loaves with crisp golden crusts and airy crumb.' },
      { title: 'Single-Origin Roasts', description: 'Ethically sourced high-altitude beans roasted in small weekly batches.' },
      { title: '100% Organic Flours', description: 'Ancient grains sourced directly from local regenerative farms.' }
    ];
    showcaseHeadline = 'Daily Oven Specials';
    showcaseItems = [
      { title: 'Wild Sourdough Boule', subtitle: 'Fermented 36 hours with sea salt', detail: '$8.50', badge: 'Best Seller' },
      { title: 'Honey Cardamom Latte', subtitle: 'Single-origin espresso & oat milk', detail: '$5.75', badge: 'Staff Favorite' },
      { title: 'Pistachio Butter Croissant', subtitle: 'Flaky 72-layer laminated French pastry', detail: '$4.95', badge: 'Fresh Baked' }
    ];
    testimonials = [
      { author: 'Elena Rostova', role: 'Local Foodie', quote: 'The sourdough is legendary. The moment you walk in, the aroma is pure warmth!' },
      { author: 'Marcus Vance', role: 'Coffee Connoisseur', quote: 'Top tier single-origin espresso pulled to perfection. My daily creative haven.' }
    ];
    contact = {
      heading: 'Stop by for a Warm Bite or Sip',
      subtext: 'Open Daily 7:00 AM – 5:00 PM • Outdoor terrace seating available',
      email: `hello@${brandName.toLowerCase().replace(/[^a-z0-9]/g, '')}.com`,
      location: '442 Artisan Way, Market District',
      ctaLabel: 'Reserve Table'
    };
  } else if (isTechOrSaas) {
    category = 'Cloud Intelligence & SaaS';
    heroHeadline = 'Accelerate Engineering with Intelligent Automation';
    heroSubhead = cleanPrompt.length > 20
      ? `${brandName} brings your idea to life: ${cleanPrompt}`
      : 'The unified operating platform for high-velocity teams. Connect your data, automate workflows, and deploy resilient systems in seconds.';
    ctaPrimary = 'Start Free Trial';
    ctaSecondary = 'Book 15-Min Demo';
    featuresHeadline = 'Engineered for Unmatched Velocity';
    features = [
      { title: 'Real-Time Neural Engine', description: 'Synthesize data streams and trigger autonomous actions in sub-50ms.' },
      { title: 'Zero-Trust Isolation', description: 'Enterprise-grade SOC-2 compliance with end-to-end cryptographic safeguards.' },
      { title: 'Adaptive Copilots', description: 'Context-aware modules tailored to your specific organizational pipelines.' }
    ];
    showcaseHeadline = 'Core Capabilities';
    showcaseItems = [
      { title: 'Workflow Mesh', subtitle: 'Instant integration across 120+ APIs', detail: '99.99% SLA', badge: 'Core' },
      { title: 'Predictive Insights', subtitle: 'Automated anomaly detection and alerts', detail: '10x Faster', badge: 'Popular' },
      { title: 'Enterprise SSO & RBAC', subtitle: 'Granular access controls and audit logs', detail: 'Included', badge: 'Security' }
    ];
    testimonials = [
      { author: 'Sarah Chen', role: 'VP Engineering at ScaleSync', quote: 'MindOS helped us articulate and launch our developer portal in record time.' },
      { author: 'Devon Lee', role: 'Founding Engineer', quote: 'Lightning-quick interface, crystal clear copy, and rock-solid architecture.' }
    ];
    contact = {
      heading: 'Ready to modernize your infrastructure?',
      subtext: 'Deploy to cloud sandboxes in under 3 minutes.',
      email: `team@${brandName.toLowerCase().replace(/[^a-z0-9]/g, '')}.io`,
      location: 'San Francisco, CA & Distributed Globally',
      ctaLabel: 'Request API Access'
    };
  } else if (isPortfolioOrDesign) {
    category = 'Design Practice & Portfolio';
    heroHeadline = 'Crafting Memorable Digital Realities';
    heroSubhead = cleanPrompt.length > 20
      ? `Selected works by ${brandName}. ${cleanPrompt}`
      : 'Specializing in futuristic brand identities, high-fidelity user experiences, and immersive spatial design.';
    ctaPrimary = 'Explore Case Studies';
    ctaSecondary = 'Inquire About Projects';
    featuresHeadline = 'Areas of Expertise';
    features = [
      { title: 'Visual Systems & Identity', description: 'Iconic logomarks, typography hierarchies, and scalable brand guidelines.' },
      { title: 'Interactive Product Design', description: 'Web and mobile interfaces built with emotional resonance and spatial depth.' },
      { title: '3D Motion Direction', description: 'Cinematic visual narratives and generative kinetic graphics.' }
    ];
    showcaseHeadline = 'Selected Works';
    showcaseItems = [
      { title: 'Aether Spatial OS', subtitle: 'Brand identity & design system', detail: 'Awwwards Site of Day', badge: 'UI/UX' },
      { title: 'Luminary Labs Portal', subtitle: 'Interactive platform & guidelines', detail: '2.5M Views', badge: 'Identity' },
      { title: 'Kinetic Type Lab', subtitle: 'Experimental 3D typography', detail: 'Exhibition', badge: 'Motion' }
    ];
    testimonials = [
      { author: 'Julian Voss', role: 'Creative Director', quote: 'Uncanny attention to craft and typography. Transformed our rough vision into art.' },
      { author: 'Clara Thorne', role: 'Head of Brand', quote: 'A visionary designer who creates experiences people talk about.' }
    ];
    contact = {
      heading: 'Let us build something remarkable together',
      subtext: 'Currently reviewing Q1 design collaborations and select commissions.',
      email: `studio@${brandName.toLowerCase().replace(/[^a-z0-9]/g, '')}.design`,
      location: 'New York, NY / Remote',
      ctaLabel: 'Send Project Brief'
    };
  } else if (isFitnessOrHealth) {
    category = 'Holistic Wellness & Movement';
    heroHeadline = 'Awaken Your Vitality, Strength, and Balance';
    heroSubhead = cleanPrompt.length > 20
      ? `${brandName}: ${cleanPrompt}`
      : 'Mindful athletic coaching, contrast therapy baths, and a supportive community built to help you flourish.';
    ctaPrimary = 'Claim Free First Session';
    ctaSecondary = 'View Schedule';
    featuresHeadline = 'The MindOS Movement Philosophy';
    features = [
      { title: 'Functional Strength', description: 'Biomechanically sound training designed for longevity and resilience.' },
      { title: 'Thermal Contrast Labs', description: 'Infrared saunas and cold plunge tubs for optimal systemic recovery.' },
      { title: 'Breath & Mindfulness', description: 'Scientifically calibrated breathwork routines for nervous system regulation.' }
    ];
    showcaseHeadline = 'Membership Options';
    showcaseItems = [
      { title: 'Foundations Pass', subtitle: 'Unlimited studio classes & open gym access', detail: '$139/mo', badge: 'Popular' },
      { title: 'Total Reset Pass', subtitle: 'Includes daily cold plunge & infrared sauna', detail: '$220/mo', badge: 'All-Access' },
      { title: 'Weekend Workshop', subtitle: 'Intensive breathwork & movement mastery', detail: '$95', badge: 'Workshop' }
    ];
    testimonials = [
      { author: 'Maya Lin', role: 'Member', quote: 'Life-changing atmosphere. The trainers and contrast tubs helped me feel renewed.' },
      { author: 'David O’Connor', role: 'Endurance Athlete', quote: 'The recovery protocols kept me completely injury-free this year.' }
    ];
    contact = {
      heading: 'Begin your journey to conscious vitality',
      subtext: 'Showers, lockers, and herbal tea bar included with all visits.',
      email: `care@${brandName.toLowerCase().replace(/[^a-z0-9]/g, '')}.com`,
      location: '780 Meridian Ave, West District',
      ctaLabel: 'Book Intro Session'
    };
  } else if (isPetOrAnimal) {
    category = 'Pet Care & Sanctuary';
    heroHeadline = 'Loving Care for Every Beloved Companion';
    heroSubhead = cleanPrompt.length > 20
      ? `Welcome to ${brandName}. ${cleanPrompt}`
      : 'Fear-free grooming, compassionate rescue matching, and loving day camp for your four-legged family members.';
    ctaPrimary = 'Meet Pets for Adoption';
    ctaSecondary = 'Book Spa Session';
    featuresHeadline = 'Our Gentle Paws Promise';
    features = [
      { title: 'Certified Gentle Grooming', description: 'Quiet suites and positive reinforcement handling for zero stress.' },
      { title: 'Ethical Rescue Network', description: '100% no-kill mission connecting rescued animals with lifelong homes.' },
      { title: 'Supervised Play Yards', description: 'Outdoor turf parks divided by size, temperament, and play style.' }
    ];
    showcaseHeadline = 'Pet Services';
    showcaseItems = [
      { title: 'Signature Bubble Bath', subtitle: 'Organic oatmeal shampoo & paw balm massage', detail: '$48', badge: 'Top Rated' },
      { title: 'Paws Day Camp', subtitle: 'Full day of guided turf play and naps', detail: '$36/day', badge: 'Active' },
      { title: 'Puppy Socialization', subtitle: 'Weekly positive manners training', detail: '$110/mo', badge: 'Class' }
    ];
    testimonials = [
      { author: 'Samantha Green', role: 'Pet Parent', quote: 'My golden retriever wags his entire body when we pull up! The kindest team.' },
      { author: 'Kenji Takahashi', role: 'Adopter', quote: 'Adopted our sweet cat through them. Such a gentle, caring experience.' }
    ];
    contact = {
      heading: 'Visit us with your four-legged best friend',
      subtext: 'Open 7 days a week with free visitor parking.',
      email: `hello@${brandName.toLowerCase().replace(/[^a-z0-9]/g, '')}.org`,
      location: '310 Meadow Lane, Parkside',
      ctaLabel: 'Schedule Visit'
    };
  } else {
    category = 'Modern Digital Concept';
    heroHeadline = generateHeadlineFromPrompt(cleanPrompt);
    heroSubhead = cleanPrompt.length > 0
      ? `Bringing your idea to life: "${cleanPrompt}". Thoughtfully structured for clarity, elegance, and audience delight.`
      : 'A modern, responsive digital presence synthesized instantly from your idea with clean design and responsive architecture.';
    ctaPrimary = 'Get Started';
    ctaSecondary = 'Learn More';
    featuresHeadline = 'Core Highlights & Features';
    features = [
      { title: 'Tailored Architecture', description: `Purpose-built to represent the vision of ${brandName} with effortless modern clarity.` },
      { title: 'Responsive Experience', description: 'Looks stunning on mobile phones, tablets, and high-resolution desktop screens.' },
      { title: 'Export-Ready Standards', description: 'Clean HTML5, modern CSS, and component structure ready to deploy anywhere.' }
    ];
    showcaseHeadline = 'Featured Elements';
    showcaseItems = [
      { title: 'Interactive Interface', subtitle: 'Synthesized from your custom description', detail: 'Ready', badge: 'v1.0' },
      { title: 'Mobile First', subtitle: 'Optimized touch targets and fluid layouts', detail: '100%', badge: 'Responsive' },
      { title: 'Zero Dependencies', subtitle: 'Deployable to any free web hosting platform', detail: 'Free', badge: 'Exportable' }
    ];
    testimonials = [
      { author: 'Jordan Taylor', role: 'Early Tester', quote: 'MindOS took my concept and turned it into an elegant website in seconds.' },
      { author: 'Avery Reed', role: 'Creative Builder', quote: 'The styling looks like an agency-designed landing page. Super intuitive.' }
    ];
    contact = {
      heading: 'Ready to connect with us?',
      subtext: 'We would love to hear from you. Drop your email below to get started.',
      email: `contact@${brandName.toLowerCase().replace(/[^a-z0-9]/g, '')}.com`,
      location: 'Worldwide Online Presence',
      ctaLabel: 'Send Inquiry'
    };
  }

  const htmlCode = generateCleanHtmlDocument({
    brandName,
    category,
    heroHeadline,
    heroSubhead,
    ctaPrimary,
    ctaSecondary,
    featuresHeadline,
    features,
    showcaseHeadline,
    showcaseItems,
    testimonials,
    contact,
    accentHex
  });

  return {
    id: 'site-' + Date.now(),
    originalPrompt: cleanPrompt,
    brandName,
    category,
    styleTheme: chosenVibe,
    accentHex,
    heroHeadline,
    heroSubhead,
    ctaPrimary,
    ctaSecondary,
    featuresHeadline,
    features,
    showcaseHeadline,
    showcaseItems,
    testimonials,
    contact,
    htmlCode,
    createdAt: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' })
  };
}

function extractBrandName(prompt, isBakery, isTech, isPortfolio, isFitness, isPet, isStore) {
  const quotedMatch = prompt.match(/["']([^"']+)["']/);
  if (quotedMatch && quotedMatch[1].trim().length >= 2) {
    return quotedMatch[1].trim();
  }

  const calledMatch = prompt.match(/(?:called|named)\s+([A-Z][a-zA-Z0-9\s]{1,24})/i);
  if (calledMatch && calledMatch[1].trim().length > 0) {
    return calledMatch[1].trim();
  }

  if (isBakery) return 'Golden Crust Bakery';
  if (isTech) return 'Nexus AI Cloud';
  if (isPortfolio) return 'MindOS Creative Studio';
  if (isFitness) return 'Pulse Movement Lab';
  if (isPet) return 'Paws & Whiskers Sanctuary';
  if (isStore) return 'Haven Goods Co.';

  if (prompt && prompt.trim().length > 0) {
    const words = prompt.trim().split(/\s+/).slice(0, 2).join(' ');
    if (words.length >= 3 && words.length <= 25) {
      return words.charAt(0).toUpperCase() + words.slice(1) + ' Portal';
    }
  }

  return 'MindOS Concept';
}

function generateHeadlineFromPrompt(prompt) {
  if (!prompt || prompt.trim().length === 0) return 'Turn Your Vision into a Digital Reality';
  const words = prompt.trim().split(/\s+/).slice(0, 7).join(' ');
  const formatted = words.charAt(0).toUpperCase() + words.slice(1);
  return formatted.length > 40 ? formatted.slice(0, 38) + '...' : formatted;
}

function generateCleanHtmlDocument(data) {
  const {
    brandName,
    category,
    heroHeadline,
    heroSubhead,
    ctaPrimary,
    ctaSecondary,
    featuresHeadline,
    features,
    showcaseHeadline,
    showcaseItems,
    testimonials,
    contact,
    accentHex
  } = data;

  const featureCards = features.map(f => `
    <div class="card">
      <div class="icon">✦</div>
      <h3>${f.title}</h3>
      <p>${f.description}</p>
    </div>
  `).join('\n');

  const showcaseCards = showcaseItems.map(s => `
    <div class="card">
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
  `).join('\n');

  const testimonialCards = testimonials.map(t => `
    <div class="card">
      <p class="quote">“${t.quote}”</p>
      <div class="author">
        <strong>${t.author}</strong> — <span>${t.role}</span>
      </div>
    </div>
  `).join('\n');

  return `<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${brandName} — ${category}</title>
  <style>
    :root {
      --bg: #090D1A;
      --surface: #0F172A;
      --surface-elevated: #162038;
      --accent: ${accentHex};
      --accent-glow: ${accentHex}33;
      --text: #FFFFFF;
      --muted: #94A3B8;
      --border: #23355D;
    }
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, sans-serif;
      background: var(--bg);
      color: var(--text);
      line-height: 1.6;
    }
    nav {
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding: 1.25rem 2rem;
      background: rgba(15, 23, 42, 0.9);
      backdrop-filter: blur(10px);
      border-bottom: 1px solid var(--border);
      position: sticky;
      top: 0;
      z-index: 50;
    }
    .brand { font-size: 1.3rem; font-weight: 800; }
    .brand span { color: var(--accent); }
    .hero {
      padding: 4rem 1.5rem;
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
      line-height: 1.2;
      margin-bottom: 1.25rem;
      letter-spacing: -0.02em;
    }
    p.lead {
      font-size: 1.15rem;
      color: var(--muted);
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
      border: none;
      cursor: pointer;
      box-shadow: 0 4px 14px var(--accent-glow);
    }
    .btn-secondary {
      background: var(--surface-elevated);
      color: var(--text);
      padding: 0.85rem 1.75rem;
      border-radius: 8px;
      font-weight: 600;
      border: 1px solid var(--border);
      cursor: pointer;
    }
    .section {
      padding: 4rem 1.5rem;
      max-width: 1000px;
      margin: 0 auto;
    }
    h2 { font-size: 1.85rem; margin-bottom: 2rem; text-align: center; }
    .grid {
      display: grid;
      grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
      gap: 1.5rem;
    }
    .card {
      background: var(--surface);
      padding: 1.75rem;
      border-radius: 12px;
      border: 1px solid var(--border);
    }
    .icon { font-size: 1.5rem; color: var(--accent); margin-bottom: 0.75rem; }
    .card h3 { margin-bottom: 0.5rem; }
    .card p { color: var(--muted); font-size: 0.95rem; }
    .badge {
      background: var(--accent-glow);
      color: var(--accent);
      padding: 0.25rem 0.6rem;
      border-radius: 4px;
      font-size: 0.75rem;
      font-weight: bold;
    }
    .item-header { display: flex; justify-content: space-between; margin-bottom: 0.5rem; }
    .sub { color: var(--muted); font-size: 0.9rem; margin-bottom: 1rem; }
    .item-footer { display: flex; justify-content: space-between; align-items: center; }
    .price { font-weight: 700; }
    .btn-sm {
      background: var(--accent);
      border: none;
      color: white;
      padding: 0.35rem 0.8rem;
      border-radius: 6px;
      font-weight: 600;
      cursor: pointer;
    }
    .quote { font-style: italic; margin-bottom: 1rem; color: #E2E8F0; }
    .author { font-size: 0.9rem; color: var(--muted); }
    .contact-box {
      background: var(--surface);
      border: 1px solid var(--border);
      border-radius: 12px;
      padding: 2.5rem;
      text-align: center;
    }
    footer {
      text-align: center;
      padding: 3rem 1rem;
      color: var(--muted);
      border-top: 1px solid var(--border);
      font-size: 0.85rem;
    }
  </style>
</head>
<body>
  <nav>
    <div class="brand">${brandName} <span>✦</span></div>
    <button class="btn-primary" style="padding: 0.5rem 1rem; font-size: 0.85rem;">${ctaPrimary}</button>
  </nav>

  <header class="hero">
    <div class="tag">${category}</div>
    <h1>${heroHeadline}</h1>
    <p class="lead">${heroSubhead}</p>
    <div class="cta-group">
      <button class="btn-primary">${ctaPrimary}</button>
      <button class="btn-secondary">${ctaSecondary}</button>
    </div>
  </header>

  <section class="section">
    <h2>${featuresHeadline}</h2>
    <div class="grid">
      ${featureCards}
    </div>
  </section>

  <section class="section" style="background: rgba(15, 23, 42, 0.5); border-radius: 16px;">
    <h2>${showcaseHeadline}</h2>
    <div class="grid">
      ${showcaseCards}
    </div>
  </section>

  <section class="section">
    <h2>Community Feedback</h2>
    <div class="grid">
      ${testimonialCards}
    </div>
  </section>

  <section class="section">
    <div class="contact-box">
      <h2>${contact.heading}</h2>
      <p style="color: var(--muted); margin-bottom: 1.5rem;">${contact.subtext}</p>
      <p><strong>Email:</strong> ${contact.email} &nbsp;|&nbsp; <strong>Location:</strong> ${contact.location}</p>
      <br>
      <button class="btn-primary">${contact.ctaLabel}</button>
    </div>
  </section>

  <footer>
    <p>© 2026 ${brandName}. All rights reserved.</p>
    <p style="margin-top: 0.5rem; font-size: 0.75rem; color: #64748B;">Synthesized with MindOS Prototype</p>
  </footer>
</body>
</html>`;
}
