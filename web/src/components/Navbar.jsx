import React from 'react';
import { Sparkles, Globe, Bookmark, HelpCircle, UploadCloud } from 'lucide-react';

export default function Navbar({ activeTab, setActiveTab, savedCount, onOpenDeployModal, onOpenHelpModal }) {
  return (
    <header className="sticky top-0 z-40 bg-navy-850/90 backdrop-blur-md border-b border-navy-600 px-4 lg:px-8 py-3 transition-colors">
      <div className="max-w-7xl mx-auto flex items-center justify-between">
        {/* Brand */}
        <div 
          onClick={() => setActiveTab('studio')}
          className="flex items-center gap-3 cursor-pointer group"
        >
          <div className="w-10 h-10 rounded-xl bg-navy-900 border border-royal flex items-center justify-center shadow-lg shadow-royal/20 group-hover:border-electric transition-all">
            <Sparkles className="w-5 h-5 text-electric animate-pulse" />
          </div>
          <div>
            <div className="flex items-center gap-2">
              <span className="text-xl font-black tracking-tight text-white group-hover:text-electric transition-colors">
                MindOS
              </span>
              <span className="text-[10px] font-bold px-1.5 py-0.5 rounded bg-royal/20 border border-royal text-electric tracking-wide">
                WEB v1.0
              </span>
            </div>
            <p className="text-xs text-slate-400 font-medium hidden sm:block">
              AI Web Architecture Studio
            </p>
          </div>
        </div>

        {/* Center Navigation Tabs */}
        <nav className="flex items-center bg-navy-900/80 p-1 rounded-xl border border-navy-600">
          <button
            onClick={() => setActiveTab('studio')}
            className={`flex items-center gap-2 px-3 py-1.5 rounded-lg text-xs md:text-sm font-semibold transition-all ${
              activeTab === 'studio'
                ? 'bg-royal text-white shadow-md shadow-royal/30'
                : 'text-slate-400 hover:text-white'
            }`}
          >
            <Sparkles className="w-4 h-4" />
            <span>Studio</span>
          </button>

          <button
            onClick={() => setActiveTab('preview')}
            className={`flex items-center gap-2 px-3 py-1.5 rounded-lg text-xs md:text-sm font-semibold transition-all ${
              activeTab === 'preview'
                ? 'bg-royal text-white shadow-md shadow-royal/30'
                : 'text-slate-400 hover:text-white'
            }`}
          >
            <Globe className="w-4 h-4" />
            <span>Live Website</span>
          </button>

          <button
            onClick={() => setActiveTab('saved')}
            className={`flex items-center gap-2 px-3 py-1.5 rounded-lg text-xs md:text-sm font-semibold transition-all relative ${
              activeTab === 'saved'
                ? 'bg-royal text-white shadow-md shadow-royal/30'
                : 'text-slate-400 hover:text-white'
            }`}
          >
            <Bookmark className="w-4 h-4" />
            <span className="hidden sm:inline">My Sites</span>
            {savedCount > 0 && (
              <span className="bg-electric text-navy-950 font-bold text-[10px] px-1.5 rounded-full">
                {savedCount}
              </span>
            )}
          </button>
        </nav>

        {/* Right Action Tools */}
        <div className="flex items-center gap-2">
          <button
            onClick={onOpenDeployModal}
            className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg bg-navy-800 hover:bg-navy-700 border border-royal/40 text-electric hover:text-white text-xs font-semibold transition-all"
            title="Deploy to Free Web Hosting"
          >
            <UploadCloud className="w-4 h-4" />
            <span className="hidden md:inline">Publish Online</span>
          </button>

          <button
            onClick={onOpenHelpModal}
            className="p-2 rounded-lg bg-navy-800 hover:bg-navy-700 text-slate-400 hover:text-white transition-colors"
            title="Prototype Scope & Info"
          >
            <HelpCircle className="w-4 h-4" />
          </button>
        </div>
      </div>
    </header>
  );
}
