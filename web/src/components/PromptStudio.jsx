import React from 'react';
import { Sparkles, Dices, X, Palette, Lightbulb, ArrowRight, Loader2 } from 'lucide-react';

export default function PromptStudio({
  prompt,
  setPrompt,
  selectedVibe,
  setSelectedVibe,
  onGenerate,
  isGenerating,
  generationProgress,
  generationStep,
  inspirationChips,
  onSelectInspiration,
  onRandomizeIdea
}) {
  const vibes = [
    'Royal Cyber',
    'Deep Navy Minimal',
    'Futuristic Glass',
    'Electric Blue',
    'Emerald Tech',
    'Cyber Purple'
  ];

  return (
    <div className="max-w-4xl mx-auto px-4 py-4">
      <div className="rounded-2xl bg-navy-850 border border-royal/50 p-5 md:p-7 shadow-xl shadow-royal/5 relative">
        {/* Card Header */}
        <div className="flex items-center justify-between gap-3 mb-3">
          <div className="flex items-center gap-2.5">
            <div className="p-2 rounded-lg bg-royal/20 text-electric border border-royal/30">
              <Lightbulb className="w-4 h-4" />
            </div>
            <div>
              <h2 className="text-base sm:text-lg font-bold text-white">
                Describe the website you imagine
              </h2>
              <p className="text-xs text-slate-400">
                Mention your project, target audience, style, or specific sections
              </p>
            </div>
          </div>

          <div className="flex items-center gap-2">
            <button
              type="button"
              onClick={onRandomizeIdea}
              className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg bg-navy-800 hover:bg-navy-700 text-electric border border-navy-600 hover:border-royal text-xs font-semibold transition-all shadow-sm"
              title="Pick a random creative concept"
            >
              <Dices className="w-3.5 h-3.5" />
              <span className="hidden sm:inline">Surprise Me</span>
            </button>

            {prompt && (
              <button
                type="button"
                onClick={() => setPrompt('')}
                className="p-1.5 rounded-lg bg-navy-800 hover:bg-navy-700 text-slate-400 hover:text-white transition-colors"
                title="Clear input"
              >
                <X className="w-4 h-4" />
              </button>
            )}
          </div>
        </div>

        {/* Text Area */}
        <div className="relative mb-4">
          <textarea
            value={prompt}
            onChange={(e) => setPrompt(e.target.value)}
            rows={4}
            placeholder="e.g., A cozy neighborhood bakery called 'Golden Crust' with artisanal sourdough specials, coffee brews, daily hours, and customer reviews..."
            className="w-full rounded-xl bg-navy-950 border border-navy-600 focus:border-royal-light focus:ring-2 focus:ring-royal/30 p-4 text-sm text-white placeholder-slate-500 transition-all outline-none resize-none leading-relaxed"
          />
          <div className="absolute right-3 bottom-3 text-[11px] text-slate-500 font-mono">
            {prompt.length} chars
          </div>
        </div>

        {/* Quick Inspiration Chips */}
        <div className="mb-5">
          <span className="text-xs font-semibold text-slate-400 block mb-2.5">
            Tap a preset idea to explore instantly:
          </span>
          <div className="flex flex-wrap gap-2">
            {inspirationChips.map((chip, idx) => (
              <button
                key={idx}
                type="button"
                onClick={() => onSelectInspiration(chip)}
                className="px-3 py-1.5 rounded-lg bg-navy-800/80 hover:bg-navy-750 border border-navy-600 hover:border-royal/60 text-xs font-medium text-electric hover:text-white transition-all shadow-sm active:scale-95 text-left"
              >
                {chip.title}
              </button>
            ))}
          </div>
        </div>

        {/* Style Aesthetic Selector */}
        <div className="mb-6">
          <div className="flex items-center gap-2 mb-2.5">
            <Palette className="w-3.5 h-3.5 text-slate-400" />
            <span className="text-xs font-semibold text-slate-400">
              Visual Aesthetic Theme:
            </span>
          </div>
          <div className="flex flex-wrap gap-2">
            {vibes.map((vibe) => {
              const active = selectedVibe === vibe;
              return (
                <button
                  key={vibe}
                  type="button"
                  onClick={() => setSelectedVibe(vibe)}
                  className={`px-3 py-1.5 rounded-lg text-xs font-semibold border transition-all ${
                    active
                      ? 'bg-royal text-white border-electric shadow-md shadow-royal/30'
                      : 'bg-navy-800 text-slate-400 border-navy-600 hover:text-white hover:border-navy-500'
                  }`}
                >
                  {vibe}
                </button>
              );
            })}
          </div>
        </div>

        {/* Dynamic Synthesis Status Bar */}
        {isGenerating && (
          <div className="mb-4 p-3.5 rounded-xl bg-navy-900 border border-royal/40 flex flex-col gap-2 animate-fadeIn">
            <div className="flex items-center justify-between text-xs font-semibold text-electric">
              <span className="flex items-center gap-2">
                <Loader2 className="w-4 h-4 animate-spin" />
                {generationStep}
              </span>
              <span>{Math.round(generationProgress * 100)}%</span>
            </div>
            <div className="w-full bg-navy-950 rounded-full h-2 overflow-hidden border border-navy-700">
              <div
                className="bg-gradient-to-r from-royal to-electric h-full transition-all duration-300 rounded-full"
                style={{ width: `${generationProgress * 100}%` }}
              />
            </div>
          </div>
        )}

        {/* Mandatory Button: "Generate My Website" */}
        <button
          type="button"
          onClick={onGenerate}
          disabled={isGenerating}
          className="w-full py-3.5 px-6 rounded-xl bg-gradient-to-r from-royal via-blue-600 to-royal hover:from-royal-light hover:to-royal text-white font-bold text-base shadow-xl shadow-royal/25 hover:shadow-royal/40 border border-blue-400/30 flex items-center justify-center gap-2.5 transition-all active:scale-[0.99] disabled:opacity-75 disabled:cursor-not-allowed cursor-pointer"
        >
          {isGenerating ? (
            <>
              <Loader2 className="w-5 h-5 animate-spin" />
              <span>Synthesizing Website Architecture...</span>
            </>
          ) : (
            <>
              <Sparkles className="w-5 h-5" />
              <span>Generate My Website</span>
              <ArrowRight className="w-4 h-4 ml-1 opacity-80" />
            </>
          )}
        </button>
      </div>
    </div>
  );
}
