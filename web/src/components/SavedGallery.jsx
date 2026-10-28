import React from 'react';
import { Bookmark, Globe, ArrowRight, Trash2 } from 'lucide-react';

export default function SavedGallery({ savedWebsites, onSelectWebsite, onGoToStudio, onDeleteWebsite }) {
  if (!savedWebsites || savedWebsites.length === 0) {
    return (
      <div className="max-w-4xl mx-auto px-4 py-20 text-center">
        <div className="w-16 h-16 rounded-2xl bg-navy-850 border border-navy-600 flex items-center justify-center mx-auto mb-4 text-slate-500">
          <Bookmark className="w-8 h-8" />
        </div>
        <h3 className="text-lg font-bold text-white mb-2">No Saved Websites Yet</h3>
        <p className="text-xs text-slate-400 max-w-sm mx-auto mb-6">
          Describe an idea in the studio and hit "Generate My Website" to start assembling your portfolio of digital concepts!
        </p>
        <button
          onClick={onGoToStudio}
          className="px-5 py-2.5 rounded-xl bg-royal hover:bg-royal-light text-white text-xs font-bold transition-all shadow-md"
        >
          Go to Studio
        </button>
      </div>
    );
  }

  return (
    <div className="max-w-4xl mx-auto px-4 py-8">
      <div className="flex items-center justify-between mb-6">
        <div>
          <h2 className="text-xl font-bold text-white">Your Generated Websites</h2>
          <p className="text-xs text-slate-400">
            {savedWebsites.length} concepts synthesized in this session
          </p>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {savedWebsites.map((site) => (
          <div
            key={site.id}
            className="p-5 rounded-2xl bg-navy-850 border border-navy-600 hover:border-royal/60 transition-all flex flex-col justify-between group shadow-lg"
          >
            <div>
              <div className="flex items-start justify-between gap-3 mb-2">
                <div className="flex items-center gap-2.5">
                  <div className="w-9 h-9 rounded-xl bg-royal/20 border border-royal/30 flex items-center justify-center text-electric">
                    <Globe className="w-4 h-4" />
                  </div>
                  <div>
                    <h3 className="font-bold text-white text-base group-hover:text-electric transition-colors">
                      {site.brandName}
                    </h3>
                    <span className="text-[11px] text-slate-400 font-medium">
                      {site.category} • {site.styleTheme}
                    </span>
                  </div>
                </div>

                <button
                  onClick={() => onDeleteWebsite(site.id)}
                  className="p-1.5 rounded-lg text-slate-500 hover:text-red-400 hover:bg-navy-800 transition-colors"
                  title="Remove"
                >
                  <Trash2 className="w-4 h-4" />
                </button>
              </div>

              <p className="text-xs text-slate-300 line-clamp-2 mb-4 leading-relaxed font-normal">
                "{site.originalPrompt || site.heroSubhead}"
              </p>
            </div>

            <div className="flex items-center justify-between pt-3 border-t border-navy-700/60">
              <span className="text-[11px] text-slate-400 font-mono">
                Created at {site.createdAt}
              </span>
              <button
                onClick={() => onSelectWebsite(site)}
                className="flex items-center gap-1.5 px-3 py-1.5 rounded-lg bg-navy-800 hover:bg-royal text-white text-xs font-semibold transition-all group-hover:bg-royal shadow-sm"
              >
                <span>View Live</span>
                <ArrowRight className="w-3.5 h-3.5" />
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}
