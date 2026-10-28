import React from 'react';
import { Sparkles, Terminal, Code2, Layers } from 'lucide-react';

export default function HeroSection() {
  return (
    <div className="relative overflow-hidden pt-4 pb-6">
      {/* Background ambient radial glow */}
      <div className="absolute top-0 left-1/2 -translate-x-1/2 w-full max-w-4xl h-72 bg-royal/10 blur-[100px] pointer-events-none rounded-full" />

      <div className="max-w-4xl mx-auto text-center px-4">
        {/* Chip Badge */}
        <div className="inline-flex items-center gap-2 px-3.5 py-1.5 rounded-full bg-royal/20 border border-royal/40 text-electric text-xs font-bold tracking-wide uppercase mb-4 shadow-sm shadow-royal/30">
          <Sparkles className="w-3.5 h-3.5 animate-spin-slow" />
          <span>Next-Gen AI Web Synthesis</span>
        </div>

        {/* Mandatory Heading */}
        <h1 className="text-3xl sm:text-5xl lg:text-6xl font-black text-white tracking-tight leading-[1.15] mb-4">
          Your Mind. Your Ideas. <br className="hidden sm:inline" />
          <span className="text-transparent bg-clip-text bg-gradient-to-r from-blue-400 via-royal-light to-electric">
            Your Digital World.
          </span>
        </h1>

        {/* Vision Description */}
        <p className="text-base sm:text-lg text-slate-300 max-w-2xl mx-auto leading-relaxed mb-6 font-normal">
          MindOS is a futuristic concept where people describe their ideas and AI turns those dreams into fully realized, responsive websites. No coding required, no paid API keys—just pure imagination translated into digital reality.
        </p>

        {/* Holographic Wireframe Showcase Banner */}
        <div className="relative rounded-2xl bg-gradient-to-b from-navy-800 to-navy-900 border border-navy-600 p-5 md:p-6 shadow-2xl overflow-hidden group">
          <div className="absolute inset-0 bg-gradient-to-r from-royal/10 via-transparent to-electric/10 opacity-50 pointer-events-none" />
          
          <div className="flex items-center justify-between border-b border-navy-600/70 pb-3 mb-4 text-xs text-slate-400 font-mono">
            <div className="flex items-center gap-2">
              <span className="w-3 h-3 rounded-full bg-red-500/80 inline-block" />
              <span className="w-3 h-3 rounded-full bg-yellow-500/80 inline-block" />
              <span className="w-3 h-3 rounded-full bg-green-500/80 inline-block" />
              <span className="ml-2 font-medium text-slate-300">mindos-neural-canvas.sys</span>
            </div>
            <div className="flex items-center gap-3">
              <span className="text-electric flex items-center gap-1">
                <span className="w-2 h-2 rounded-full bg-electric animate-ping" />
                Live Synthesis Engine
              </span>
            </div>
          </div>

          <div className="grid grid-cols-1 md:grid-cols-3 gap-4 text-left">
            <div className="p-3.5 rounded-xl bg-navy-850/80 border border-navy-600">
              <div className="flex items-center gap-2 text-electric text-xs font-semibold mb-1">
                <Terminal className="w-4 h-4" />
                <span>1. Natural Input</span>
              </div>
              <p className="text-xs text-slate-300">
                Type any vision: bakery, SaaS, creative portfolio, or community rescue.
              </p>
            </div>

            <div className="p-3.5 rounded-xl bg-navy-850/80 border border-navy-600">
              <div className="flex items-center gap-2 text-blue-400 text-xs font-semibold mb-1">
                <Layers className="w-4 h-4" />
                <span>2. Semantic Layout</span>
              </div>
              <p className="text-xs text-slate-300">
                Generates headlines, features, pricing grids, and interactive contact forms.
              </p>
            </div>

            <div className="p-3.5 rounded-xl bg-navy-850/80 border border-navy-600">
              <div className="flex items-center gap-2 text-emerald-400 text-xs font-semibold mb-1">
                <Code2 className="w-4 h-4" />
                <span>3. Deploy Ready</span>
              </div>
              <p className="text-xs text-slate-300">
                Instantly preview, test mobile responsiveness, and export clean HTML5 & CSS.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
