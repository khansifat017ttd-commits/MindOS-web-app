import React from 'react';
import { X, UploadCloud, Globe, ExternalLink, Check, Copy } from 'lucide-react';

export default function DeploymentModal({ onClose, onShowToast }) {
  const steps = [
    {
      title: 'Option A: Free Netlify Drop (30 Seconds — No Signup Required)',
      desc: '1. Click "Download File" in the Code Inspector to save your website HTML file.\n2. Go to app.netlify.com/drop in your browser.\n3. Drag and drop your file into the box to instantly receive a free public https://...netlify.app URL!'
    },
    {
      title: 'Option B: Deploy Full MindOS to Vercel (Custom Domains & Continuous Git)',
      desc: '1. Upload the /web folder to a GitHub repository.\n2. Open vercel.com and select "Add New Project" -> import your repository.\n3. Vercel automatically detects Vite + React + Tailwind and provides a permanent, lightning-fast public web address.'
    },
    {
      title: 'Option C: GitHub Pages (100% Free Static Hosting)',
      desc: '1. In your GitHub repository settings, go to the "Pages" tab.\n2. Select the "main" branch or "/dist" folder as your source.\n3. Your site will be live at https://yourusername.github.io/mindos'
    }
  ];

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-navy-950/80 backdrop-blur-md">
      <div className="w-full max-w-2xl max-h-[85vh] rounded-2xl bg-navy-850 border border-navy-600 shadow-2xl flex flex-col overflow-hidden">
        {/* Header */}
        <div className="flex items-center justify-between px-6 py-4 border-b border-navy-600 bg-navy-900">
          <div className="flex items-center gap-3">
            <div className="p-2 rounded-lg bg-royal/20 text-electric border border-royal/30">
              <UploadCloud className="w-5 h-5" />
            </div>
            <div>
              <h3 className="text-base font-bold text-white">
                How to Publish Your MindOS Website Online
              </h3>
              <p className="text-xs text-slate-400">
                100% free hosting options with instant shareable links
              </p>
            </div>
          </div>

          <button
            onClick={onClose}
            className="p-1.5 rounded-lg bg-navy-850 hover:bg-navy-700 text-slate-400 hover:text-white transition-colors"
          >
            <X className="w-5 h-5" />
          </button>
        </div>

        {/* Content */}
        <div className="p-6 space-y-4 overflow-y-auto text-left">
          {steps.map((step, idx) => (
            <div
              key={idx}
              className="p-4 rounded-xl bg-navy-900 border border-navy-600 space-y-2"
            >
              <h4 className="text-sm font-bold text-white flex items-center gap-2">
                <Globe className="w-4 h-4 text-electric" />
                {step.title}
              </h4>
              <p className="text-xs text-slate-300 whitespace-pre-line leading-relaxed font-mono">
                {step.desc}
              </p>
            </div>
          ))}
        </div>

        {/* Footer */}
        <div className="px-6 py-4 border-t border-navy-600 bg-navy-900 flex justify-end">
          <button
            onClick={onClose}
            className="px-5 py-2 rounded-xl bg-royal hover:bg-royal-light text-white text-xs font-bold transition-all shadow-md cursor-pointer"
          >
            Understood, Let's Build!
          </button>
        </div>
      </div>
    </div>
  );
}
