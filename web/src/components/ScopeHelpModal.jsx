import React from 'react';
import { X, CheckCircle, Info } from 'lucide-react';

export default function ScopeHelpModal({ onClose }) {
  const points = [
    {
      title: '100% Free & No Account Needed',
      desc: 'Runs completely client-side in standard JavaScript. No subscription fees, logins, or paid API keys.'
    },
    {
      title: 'Semantic Intelligence',
      desc: 'Intelligently extracts keywords, intent, and tone from your description to architect tailored sections, copy, and styling.'
    },
    {
      title: 'Clean Standards-Compliant HTML & CSS',
      desc: 'Produces production-ready web code ready for Vercel, Netlify, or custom domains.'
    },
    {
      title: 'Prototype Scope',
      desc: 'Focuses on visual layout, typography, components, and interactions. All data stays local and private in your browser.'
    }
  ];

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-navy-950/80 backdrop-blur-md">
      <div className="w-full max-w-lg rounded-2xl bg-navy-850 border border-navy-600 shadow-2xl flex flex-col overflow-hidden">
        <div className="flex items-center justify-between px-6 py-4 border-b border-navy-600 bg-navy-900">
          <div className="flex items-center gap-2.5">
            <Info className="w-5 h-5 text-electric" />
            <h3 className="text-base font-bold text-white">MindOS Prototype Scope</h3>
          </div>
          <button
            onClick={onClose}
            className="p-1.5 rounded-lg bg-navy-850 hover:bg-navy-700 text-slate-400 hover:text-white transition-colors"
          >
            <X className="w-5 h-5" />
          </button>
        </div>

        <div className="p-6 space-y-3">
          {points.map((pt, idx) => (
            <div key={idx} className="p-3.5 rounded-xl bg-navy-900 border border-navy-600 flex items-start gap-3">
              <CheckCircle className="w-4 h-4 text-electric mt-0.5 flex-shrink-0" />
              <div>
                <h4 className="text-xs font-bold text-white mb-0.5">{pt.title}</h4>
                <p className="text-xs text-slate-300 leading-relaxed">{pt.desc}</p>
              </div>
            </div>
          ))}
        </div>

        <div className="px-6 py-4 border-t border-navy-600 bg-navy-900 flex justify-end">
          <button
            onClick={onClose}
            className="px-5 py-2 rounded-xl bg-royal hover:bg-royal-light text-white text-xs font-bold transition-all shadow-md cursor-pointer"
          >
            Got It
          </button>
        </div>
      </div>
    </div>
  );
}
