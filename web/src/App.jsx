import React, { useState } from 'react';
import Navbar from './components/Navbar';
import HeroSection from './components/HeroSection';
import PromptStudio from './components/PromptStudio';
import WebsitePreview from './components/WebsitePreview';
import SavedGallery from './components/SavedGallery';
import CodeInspectorModal from './components/CodeInspectorModal';
import DeploymentModal from './components/DeploymentModal';
import ScopeHelpModal from './components/ScopeHelpModal';
import { generateWebsite } from './generator/websiteGenerator';
import { Sparkles, ArrowRight, Globe } from 'lucide-react';

const INITIAL_INSPIRATIONS = [
  {
    title: '☕ Artisan Bakery',
    category: 'Bakery & Cafe',
    promptText: 'A cozy neighborhood artisanal bakery called "Golden Crust" featuring slow-fermented sourdough, fresh morning pastries, ethical coffee, and daily specials.'
  },
  {
    title: '🚀 AI SaaS Platform',
    category: 'Tech / SaaS',
    promptText: 'A modern SaaS product landing page for "NeuralFlow AI" that automates data workflows with speed metrics, enterprise security features, and a free trial button.'
  },
  {
    title: '🎨 Design Studio',
    category: 'Portfolio',
    promptText: 'A sleek digital portfolio for "MindOS Creative Studio" showcasing 3D visual identities, brand case studies, interactive products, and an inquiry contact form.'
  },
  {
    title: '🧘 Yoga & Wellness',
    category: 'Fitness',
    promptText: 'A peaceful holistic wellness studio called "Prana Sanctuary" offering mindful yoga sessions, breathwork workshops, recovery plunge baths, and class schedules.'
  },
  {
    title: '🍕 Wood-Fired Pizza',
    category: 'Restaurant',
    promptText: 'An authentic Neapolitan pizzeria named "Via Roma" with crispy wood-fired crusts, secret tomato sauce recipe, table reservation booking, and delivery specials.'
  },
  {
    title: '🐾 Animal Rescue',
    category: 'Community',
    promptText: 'A compassionate non-profit pet rescue called "Paws Haven" with profiles of dogs & cats up for adoption, volunteer signup, and a donation link.'
  }
];

export default function App() {
  const [activeTab, setActiveTab] = useState('studio'); // 'studio' | 'preview' | 'saved'
  const [prompt, setPrompt] = useState('');
  const [selectedVibe, setSelectedVibe] = useState('Royal Cyber');
  const [isGenerating, setIsGenerating] = useState(false);
  const [generationProgress, setGenerationProgress] = useState(0);
  const [generationStep, setGenerationStep] = useState('');
  
  // Default sample website pre-synthesized
  const [currentWebsite, setCurrentWebsite] = useState(() => {
    return generateWebsite(
      'A cozy neighborhood artisanal bakery called "Golden Crust" featuring slow-fermented sourdough, fresh morning pastries, and ethical coffee.',
      'Royal Cyber'
    );
  });

  const [savedWebsites, setSavedWebsites] = useState(() => {
    const initial = generateWebsite(
      'A cozy neighborhood artisanal bakery called "Golden Crust" featuring slow-fermented sourdough, fresh morning pastries, and ethical coffee.',
      'Royal Cyber'
    );
    return [initial];
  });

  const [showCodeModal, setShowCodeModal] = useState(false);
  const [showDeployModal, setShowDeployModal] = useState(false);
  const [showHelpModal, setShowHelpModal] = useState(false);
  const [toastMessage, setToastMessage] = useState(null);

  const showToast = (msg) => {
    setToastMessage(msg);
    setTimeout(() => {
      setToastMessage(null);
    }, 3200);
  };

  const handleRandomizeIdea = () => {
    const random = INITIAL_INSPIRATIONS[Math.floor(Math.random() * INITIAL_INSPIRATIONS.length)];
    setPrompt(random.promptText);
    showToast(`Loaded ${random.category} prompt!`);
  };

  const handleSelectInspiration = (chip) => {
    setPrompt(chip.promptText);
    showToast(`Selected ${chip.category}`);
  };

  const handleGenerate = () => {
    const promptToUse = prompt.trim() || 'A futuristic tech platform called MindOS that turns ideas into websites';
    setPrompt(promptToUse);
    setIsGenerating(true);
    setGenerationProgress(0.25);
    setGenerationStep('Parsing vision & intent...');

    setTimeout(() => {
      setGenerationProgress(0.55);
      setGenerationStep('Composing royal palette & typography...');
    }, 150);

    setTimeout(() => {
      setGenerationProgress(0.85);
      setGenerationStep('Architecting responsive layout & components...');
    }, 300);

    setTimeout(() => {
      const generated = generateWebsite(promptToUse, selectedVibe);
      setCurrentWebsite(generated);
      setSavedWebsites((prev) => [generated, ...prev.filter((s) => s.id !== generated.id)]);
      setIsGenerating(false);
      setGenerationProgress(1.0);
      setActiveTab('preview');
      showToast('Website synthesized successfully!');
    }, 450);
  };

  const handleDeleteSaved = (id) => {
    setSavedWebsites((prev) => prev.filter((s) => s.id !== id));
    showToast('Website removed from saved list');
  };

  return (
    <div className="min-h-screen bg-navy-950 text-white flex flex-col font-sans">
      {/* Toast Notification */}
      {toastMessage && (
        <div className="fixed bottom-6 right-6 z-50 px-4 py-2.5 rounded-xl bg-royal text-white font-medium text-xs shadow-2xl border border-blue-400/40 animate-bounce">
          {toastMessage}
        </div>
      )}

      {/* MindOS Navigation Bar */}
      <Navbar
        activeTab={activeTab}
        setActiveTab={setActiveTab}
        savedCount={savedWebsites.length}
        onOpenDeployModal={() => setShowDeployModal(true)}
        onOpenHelpModal={() => setShowHelpModal(true)}
      />

      {/* Main Screen Views */}
      <main className="flex-1">
        {activeTab === 'studio' && (
          <div className="pb-16 animate-fadeIn">
            <HeroSection />

            <PromptStudio
              prompt={prompt}
              setPrompt={setPrompt}
              selectedVibe={selectedVibe}
              setSelectedVibe={setSelectedVibe}
              onGenerate={handleGenerate}
              isGenerating={isGenerating}
              generationProgress={generationProgress}
              generationStep={generationStep}
              inspirationChips={INITIAL_INSPIRATIONS}
              onSelectInspiration={handleSelectInspiration}
              onRandomizeIdea={handleRandomizeIdea}
            />

            {/* Quick Preview Card if site already exists */}
            {currentWebsite && (
              <div className="max-w-4xl mx-auto px-4 mt-6">
                <div
                  onClick={() => setActiveTab('preview')}
                  className="p-4 rounded-xl bg-navy-850 hover:bg-navy-800 border border-royal/40 flex items-center justify-between cursor-pointer transition-all shadow-md group"
                >
                  <div className="flex items-center gap-3">
                    <div className="w-10 h-10 rounded-xl bg-royal/20 text-electric flex items-center justify-center border border-royal/30">
                      <Globe className="w-5 h-5" />
                    </div>
                    <div>
                      <h4 className="text-sm font-bold text-white group-hover:text-electric transition-colors">
                        Active Website: {currentWebsite.brandName}
                      </h4>
                      <p className="text-xs text-slate-400">
                        {currentWebsite.category} • Tap to view live in simulator
                      </p>
                    </div>
                  </div>

                  <div className="flex items-center gap-1.5 text-xs font-semibold text-electric">
                    <span>Open Live View</span>
                    <ArrowRight className="w-4 h-4 group-hover:translate-x-1 transition-transform" />
                  </div>
                </div>
              </div>
            )}
          </div>
        )}

        {activeTab === 'preview' && (
          <div className="animate-fadeIn">
            <WebsitePreview
              website={currentWebsite}
              onBackToStudio={() => setActiveTab('studio')}
              onOpenCodeInspector={() => setShowCodeModal(true)}
              onShowToast={showToast}
            />
          </div>
        )}

        {activeTab === 'saved' && (
          <div className="animate-fadeIn">
            <SavedGallery
              savedWebsites={savedWebsites}
              onSelectWebsite={(site) => {
                setCurrentWebsite(site);
                setActiveTab('preview');
                showToast(`Loaded ${site.brandName}`);
              }}
              onGoToStudio={() => setActiveTab('studio')}
              onDeleteWebsite={handleDeleteSaved}
            />
          </div>
        )}
      </main>

      {/* Modals */}
      {showCodeModal && (
        <CodeInspectorModal
          website={currentWebsite}
          onClose={() => setShowCodeModal(false)}
          onShowToast={showToast}
        />
      )}

      {showDeployModal && (
        <DeploymentModal
          onClose={() => setShowDeployModal(false)}
          onShowToast={showToast}
        />
      )}

      {showHelpModal && (
        <ScopeHelpModal
          onClose={() => setShowHelpModal(false)}
        />
      )}
    </div>
  );
}
