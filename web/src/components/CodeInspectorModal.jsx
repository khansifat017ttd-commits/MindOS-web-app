import React, { useState } from 'react';
import { X, Copy, Check, Download, FileCode, CheckCircle2 } from 'lucide-react';

export default function CodeInspectorModal({ website, onClose, onShowToast }) {
  const [copied, setCopied] = useState(false);

  if (!website) return null;

  const handleCopy = () => {
    navigator.clipboard.writeText(website.htmlCode);
    setCopied(true);
    onShowToast('HTML5 & CSS code copied to clipboard!');
    setTimeout(() => setCopied(false), 2500);
  };

  const handleDownload = () => {
    const blob = new Blob([website.htmlCode], { type: 'text/html' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `${website.brandName.toLowerCase().replace(/[^a-z0-9]/g, '-')}.html`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);
    onShowToast(`Downloaded ${a.download}!`);
  };

  return (
    <div className="fixed inset-0 z-50 flex items-center justify-center p-4 bg-navy-950/80 backdrop-blur-md">
      <div className="w-full max-w-4xl max-h-[85vh] rounded-2xl bg-navy-850 border border-navy-600 shadow-2xl flex flex-col overflow-hidden">
        {/* Header */}
        <div className="flex items-center justify-between px-6 py-4 border-b border-navy-600 bg-navy-900">
          <div className="flex items-center gap-3">
            <div className="p-2 rounded-lg bg-royal/20 text-electric border border-royal/30">
              <FileCode className="w-5 h-5" />
            </div>
            <div>
              <h3 className="text-base font-bold text-white">
                Exportable HTML5 & Modern CSS
              </h3>
              <p className="text-xs text-slate-400">
                {website.brandName} • Standards-compliant, ready for any web host
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

        {/* Code Content Viewport */}
        <div className="flex-1 p-4 overflow-auto bg-navy-950 font-mono text-xs text-cyan-300 leading-relaxed selection:bg-royal">
          <pre className="whitespace-pre">{website.htmlCode}</pre>
        </div>

        {/* Footer Actions */}
        <div className="flex flex-wrap items-center justify-between gap-3 px-6 py-4 border-t border-navy-600 bg-navy-900">
          <div className="flex items-center gap-2 text-xs text-slate-400">
            <CheckCircle2 className="w-4 h-4 text-emerald-400" />
            <span>Zero external dependencies • Embeds responsive CSS</span>
          </div>

          <div className="flex items-center gap-3">
            <button
              onClick={handleDownload}
              className="flex items-center gap-2 px-4 py-2 rounded-xl bg-navy-800 hover:bg-navy-750 text-slate-200 border border-navy-600 text-xs font-semibold transition-all cursor-pointer"
            >
              <Download className="w-4 h-4 text-electric" />
              <span>Download File</span>
            </button>

            <button
              onClick={handleCopy}
              className="flex items-center gap-2 px-5 py-2 rounded-xl bg-royal hover:bg-royal-light text-white text-xs font-bold transition-all shadow-md shadow-royal/30 cursor-pointer"
            >
              {copied ? (
                <>
                  <Check className="w-4 h-4" />
                  <span>Copied!</span>
                </>
              ) : (
                <>
                  <Copy className="w-4 h-4" />
                  <span>Copy HTML Code</span>
                </>
              )}
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
