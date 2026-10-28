import React, { useState } from 'react';
import { 
  ArrowLeft, Smartphone, Monitor, Code2, Check, Send, 
  Star, Mail, MapPin, ExternalLink, Sparkles, Layers 
} from 'lucide-react';

export default function WebsitePreview({
  website,
  onBackToStudio,
  onOpenCodeInspector,
  onShowToast
}) {
  const [viewportMode, setViewportMode] = useState('mobile'); // 'mobile' | 'desktop'
  const [renderMode, setRenderMode] = useState('interactive'); // 'interactive' | 'html'
  const [selectedAccent, setSelectedAccent] = useState(website?.accentHex || '#2563EB');
  const [visitorEmail, setVisitorEmail] = useState('');
  const [formSubmitted, setFormSubmitted] = useState(false);

  if (!website) {
    return (
      <div className="max-w-4xl mx-auto px-4 py-16 text-center">
        <p className="text-slate-400 mb-4">No website has been generated yet.</p>
        <button
          onClick={onBackToStudio}
          className="px-5 py-2.5 rounded-xl bg-royal text-white font-semibold"
        >
          Go to Studio
        </button>
      </div>
    );
  }

  const palette = ['#2563EB', '#0284C7', '#10B981', '#8B5CF6', '#F59E0B'];

  const handleContactSubmit = (e) => {
    e.preventDefault();
    if (!visitorEmail || !visitorEmail.includes('@')) {
      onShowToast('Please enter a valid email address.');
      return;
    }
    setFormSubmitted(true);
    onShowToast(`Inquiry submitted from ${visitorEmail}!`);
  };

  return (
    <div className="flex flex-col min-h-screen bg-navy-950">
      {/* Top Controls Toolbar */}
      <div className="sticky top-14 z-30 bg-navy-850 border-b border-navy-600 px-4 py-2.5 shadow-md">
        <div className="max-w-7xl mx-auto flex flex-wrap items-center justify-between gap-3">
          {/* Left: Back & Title */}
          <div className="flex items-center gap-3">
            <button
              onClick={onBackToStudio}
              className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg bg-royal hover:bg-royal-light text-white text-xs font-bold transition-all shadow-sm shadow-royal/20 cursor-pointer"
            >
              <ArrowLeft className="w-3.5 h-3.5" />
              <span>Studio</span>
            </button>

            <div>
              <div className="flex items-center gap-2">
                <span className="text-sm font-bold text-white max-w-[180px] sm:max-w-xs truncate">
                  {website.brandName}
                </span>
                <span className="text-[10px] font-semibold px-2 py-0.5 rounded-full bg-navy-700 text-electric border border-navy-600">
                  {website.category}
                </span>
              </div>
              <p className="text-[11px] text-slate-400">
                MindOS Live Preview Simulator
              </p>
            </div>
          </div>

          {/* Center: Accent and Render Mode */}
          <div className="flex items-center gap-4">
            {/* Accent Tint */}
            <div className="flex items-center gap-1.5">
              <span className="text-xs text-slate-400 font-medium hidden sm:inline">
                Accent:
              </span>
              <div className="flex items-center gap-1">
                {palette.map((color) => {
                  const active = selectedAccent.toLowerCase() === color.toLowerCase();
                  return (
                    <button
                      key={color}
                      onClick={() => {
                        setSelectedAccent(color);
                        onShowToast('Accent color updated');
                      }}
                      style={{ backgroundColor: color }}
                      className={`w-5 h-5 rounded-full transition-all ${
                        active ? 'ring-2 ring-white scale-110' : 'opacity-70 hover:opacity-100'
                      }`}
                      title={color}
                    />
                  );
                })}
              </div>
            </div>

            {/* Render Switcher */}
            <div className="flex items-center bg-navy-900 p-0.5 rounded-lg border border-navy-600">
              <button
                onClick={() => setRenderMode('interactive')}
                className={`px-2.5 py-1 rounded text-xs font-semibold transition-all ${
                  renderMode === 'interactive'
                    ? 'bg-navy-700 text-electric'
                    : 'text-slate-400 hover:text-white'
                }`}
              >
                App View
              </button>
              <button
                onClick={() => setRenderMode('html')}
                className={`px-2.5 py-1 rounded text-xs font-semibold transition-all ${
                  renderMode === 'html'
                    ? 'bg-navy-700 text-electric'
                    : 'text-slate-400 hover:text-white'
                }`}
              >
                Real HTML5
              </button>
            </div>
          </div>

          {/* Right: Viewport Toggle & Code Button */}
          <div className="flex items-center gap-2">
            <div className="flex items-center bg-navy-900 p-0.5 rounded-lg border border-navy-600">
              <button
                onClick={() => setViewportMode('mobile')}
                className={`p-1.5 rounded transition-all ${
                  viewportMode === 'mobile'
                    ? 'bg-navy-700 text-white'
                    : 'text-slate-400 hover:text-white'
                }`}
                title="Mobile Viewport (390px)"
              >
                <Smartphone className="w-4 h-4" />
              </button>
              <button
                onClick={() => setViewportMode('desktop')}
                className={`p-1.5 rounded transition-all ${
                  viewportMode === 'desktop'
                    ? 'bg-navy-700 text-white'
                    : 'text-slate-400 hover:text-white'
                }`}
                title="Desktop Viewport (Full Width)"
              >
                <Monitor className="w-4 h-4" />
              </button>
            </div>

            <button
              onClick={onOpenCodeInspector}
              className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg bg-navy-800 hover:bg-navy-750 border border-navy-600 text-slate-200 hover:text-white text-xs font-semibold transition-all cursor-pointer"
            >
              <Code2 className="w-4 h-4 text-electric" />
              <span className="hidden md:inline">Inspect Code</span>
            </button>
          </div>
        </div>
      </div>

      {/* Simulator Body */}
      <div className="flex-1 p-3 md:p-6 flex justify-center items-start overflow-y-auto">
        <div
          className={`w-full transition-all duration-300 ${
            viewportMode === 'mobile'
              ? 'max-w-[410px] rounded-3xl border-4 border-navy-700 shadow-2xl bg-navy-900 overflow-hidden ring-1 ring-royal/30'
              : 'max-w-6xl rounded-2xl border border-navy-600 shadow-2xl bg-navy-900 overflow-hidden'
          }`}
        >
          {renderMode === 'html' ? (
            /* Direct HTML5 Web View via Iframe */
            <iframe
              title="HTML5 Live Web Engine"
              srcDoc={website.htmlCode.replace(/var\(--accent\): [^;]+;/, `var(--accent): ${selectedAccent};`)}
              className="w-full h-[760px] border-none bg-[#090D1A]"
              sandbox="allow-scripts"
            />
          ) : (
            /* Interactive Component Layout */
            <div className="min-h-[700px] flex flex-col bg-navy-900 text-white">
              {/* --- 1. Website Navigation --- */}
              <nav className="sticky top-0 z-20 px-4 py-3.5 bg-navy-850/95 backdrop-blur-md border-b border-navy-600 flex items-center justify-between">
                <div className="flex items-center gap-2">
                  <span className="font-extrabold text-base tracking-tight">
                    {website.brandName}
                  </span>
                  <span style={{ color: selectedAccent }}>✦</span>
                </div>

                <div className="flex items-center gap-3">
                  <button
                    onClick={() => onShowToast(`Triggered: ${website.ctaPrimary}`)}
                    style={{ backgroundColor: selectedAccent }}
                    className="px-3.5 py-1.5 rounded-lg text-xs font-bold text-white shadow-sm hover:opacity-90 active:scale-95 transition-all"
                  >
                    {website.ctaPrimary}
                  </button>
                </div>
              </nav>

              {/* --- 2. Hero Section --- */}
              <section className="px-6 py-12 md:py-16 text-center max-w-3xl mx-auto">
                <span
                  style={{ color: selectedAccent, borderColor: selectedAccent }}
                  className="inline-block px-3 py-1 rounded-full text-[11px] font-bold uppercase tracking-wider border mb-4 bg-navy-800"
                >
                  {website.category}
                </span>

                <h1 className="text-2xl sm:text-4xl font-extrabold text-white tracking-tight leading-tight mb-4">
                  {website.heroHeadline}
                </h1>

                <p className="text-sm sm:text-base text-slate-300 leading-relaxed mb-8 max-w-xl mx-auto">
                  {website.heroSubhead}
                </p>

                <div className="flex flex-wrap items-center justify-center gap-3">
                  <button
                    onClick={() => onShowToast(`Confirmed: ${website.ctaPrimary}`)}
                    style={{ backgroundColor: selectedAccent }}
                    className="px-6 py-2.5 rounded-xl text-sm font-bold text-white shadow-lg hover:opacity-95 active:scale-95 transition-all"
                  >
                    {website.ctaPrimary}
                  </button>
                  <button
                    onClick={() => onShowToast(`Opened: ${website.ctaSecondary}`)}
                    className="px-6 py-2.5 rounded-xl text-sm font-semibold text-slate-200 bg-navy-800 hover:bg-navy-750 border border-navy-600 transition-all active:scale-95"
                  >
                    {website.ctaSecondary}
                  </button>
                </div>
              </section>

              {/* --- 3. Features Grid --- */}
              <section className="px-6 py-10 border-t border-navy-700/60 max-w-5xl mx-auto w-full">
                <h2 className="text-xl sm:text-2xl font-bold text-center mb-8">
                  {website.featuresHeadline}
                </h2>

                <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                  {website.features.map((feat, idx) => (
                    <div
                      key={idx}
                      className="p-5 rounded-xl bg-navy-850 border border-navy-600 hover:border-slate-500 transition-all"
                    >
                      <div
                        style={{ color: selectedAccent }}
                        className="text-xl font-bold mb-2.5"
                      >
                        ✦
                      </div>
                      <h3 className="text-base font-bold text-white mb-1.5">
                        {feat.title}
                      </h3>
                      <p className="text-xs sm:text-sm text-slate-300 leading-relaxed">
                        {feat.description}
                      </p>
                    </div>
                  ))}
                </div>
              </section>

              {/* --- 4. Showcase / Product Section --- */}
              <section className="px-6 py-10 bg-navy-950/70 border-t border-navy-700/60 w-full">
                <div className="max-w-5xl mx-auto">
                  <h2 className="text-xl sm:text-2xl font-bold text-center mb-8">
                    {website.showcaseHeadline}
                  </h2>

                  <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
                    {website.showcaseItems.map((item, idx) => (
                      <div
                        key={idx}
                        className="p-5 rounded-xl bg-navy-850 border border-navy-600 flex flex-col justify-between"
                      >
                        <div>
                          <div className="flex items-center justify-between mb-2">
                            <h4 className="font-bold text-sm sm:text-base text-white">
                              {item.title}
                            </h4>
                            <span
                              style={{ color: selectedAccent }}
                              className="text-[10px] font-bold px-2 py-0.5 rounded bg-navy-800 border border-navy-600"
                            >
                              {item.badge}
                            </span>
                          </div>
                          <p className="text-xs text-slate-400 mb-4 leading-relaxed">
                            {item.subtitle}
                          </p>
                        </div>

                        <div className="flex items-center justify-between pt-3 border-t border-navy-700">
                          <span className="font-bold text-sm text-white">
                            {item.detail}
                          </span>
                          <button
                            onClick={() => onShowToast(`Selected ${item.title}`)}
                            style={{ backgroundColor: selectedAccent }}
                            className="px-3 py-1 rounded-lg text-xs font-semibold text-white shadow-sm hover:opacity-90 active:scale-95 transition-all"
                          >
                            Select
                          </button>
                        </div>
                      </div>
                    ))}
                  </div>
                </div>
              </section>

              {/* --- 5. Testimonials --- */}
              <section className="px-6 py-10 border-t border-navy-700/60 max-w-4xl mx-auto w-full">
                <h2 className="text-xl sm:text-2xl font-bold text-center mb-8">
                  Community Voices
                </h2>

                <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                  {website.testimonials.map((test, idx) => (
                    <div
                      key={idx}
                      className="p-5 rounded-xl bg-navy-850 border border-navy-600"
                    >
                      <div className="flex text-amber-400 mb-3">
                        {[...Array(5)].map((_, i) => (
                          <Star key={i} className="w-3.5 h-3.5 fill-current" />
                        ))}
                      </div>
                      <p className="text-xs sm:text-sm text-slate-200 italic mb-3 leading-relaxed">
                        “{test.quote}”
                      </p>
                      <div className="text-xs text-slate-400">
                        <strong className="text-white">{test.author}</strong> — {test.role}
                      </div>
                    </div>
                  ))}
                </div>
              </section>

              {/* --- 6. Interactive Contact Section --- */}
              <section className="px-6 py-12 border-t border-navy-700/60 max-w-xl mx-auto w-full">
                <div className="p-6 md:p-8 rounded-2xl bg-navy-850 border border-navy-600 text-center">
                  <h3 className="text-lg sm:text-xl font-bold text-white mb-2">
                    {website.contact.heading}
                  </h3>
                  <p className="text-xs sm:text-sm text-slate-300 mb-6">
                    {website.contact.subtext}
                  </p>

                  <div className="flex flex-col sm:flex-row items-center justify-center gap-4 text-xs text-slate-300 mb-6">
                    <span className="flex items-center gap-1.5">
                      <Mail className="w-3.5 h-3.5 text-electric" />
                      {website.contact.email}
                    </span>
                    <span className="flex items-center gap-1.5">
                      <MapPin className="w-3.5 h-3.5 text-electric" />
                      {website.contact.location}
                    </span>
                  </div>

                  {!formSubmitted ? (
                    <form onSubmit={handleContactSubmit} className="flex flex-col gap-3">
                      <input
                        type="email"
                        value={visitorEmail}
                        onChange={(e) => setVisitorEmail(e.target.value)}
                        placeholder="Enter your email address..."
                        className="w-full px-4 py-2.5 rounded-xl bg-navy-950 border border-navy-600 focus:border-royal text-sm text-white placeholder-slate-500 outline-none"
                      />
                      <button
                        type="submit"
                        style={{ backgroundColor: selectedAccent }}
                        className="w-full py-2.5 px-4 rounded-xl text-sm font-bold text-white flex items-center justify-center gap-2 hover:opacity-90 active:scale-95 transition-all"
                      >
                        <Send className="w-4 h-4" />
                        <span>{website.contact.ctaLabel}</span>
                      </button>
                    </form>
                  ) : (
                    <div className="p-4 rounded-xl bg-emerald-500/20 border border-emerald-500/40 text-emerald-300 text-xs font-semibold flex items-center justify-center gap-2">
                      <Check className="w-4 h-4" />
                      <span>Thank you! Your request has been received.</span>
                    </div>
                  )}
                </div>
              </section>

              {/* --- 7. Website Footer --- */}
              <footer className="mt-auto px-6 py-8 border-t border-navy-700/60 bg-navy-950 text-center text-xs text-slate-400">
                <p>© 2026 {website.brandName}. All rights reserved.</p>
                <p className="text-[11px] text-electric mt-1">
                  Synthesized with MindOS Architecture Studio
                </p>
              </footer>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
