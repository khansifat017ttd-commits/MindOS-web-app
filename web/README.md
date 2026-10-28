# MindOS — React + Tailwind CSS Web Application

MindOS is a futuristic web synthesis platform where users describe their vision in plain English, and the engine transforms those ideas into responsive websites complete with headlines, feature cards, showcase grids, community reviews, and interactive contact forms.

---

## 🚀 How to Publish MindOS as a Public Live Website (Free Hosting)

You can publish this React & Tailwind web application online for free using any of these services:

### Option 1: Netlify Drop (Easiest — 30 Seconds, No Terminal Required)
1. Go to **[https://app.netlify.com/drop](https://app.netlify.com/drop)** in your browser.
2. Drag and drop the **`web/dist`** folder from this project directly onto the page.
3. Netlify will instantly deploy it and give you a public URL like `https://mindos-studio.netlify.app`!

### Option 2: Vercel (Continuous Deployment & Custom Domains)
1. Push this project to your GitHub account:
   - Or push only the `web` folder to a new repo named `mindos-web`.
2. Visit **[https://vercel.com](https://vercel.com)** and click **"Add New Project"**.
3. Import your GitHub repository.
4. Set root directory to `web` (if pushing the full repository).
5. Vercel automatically detects **Vite + React + Tailwind** and gives you a free permanent `https://mindos.vercel.app` link with free SSL!

### Option 3: GitHub Pages
1. In your GitHub repository settings, navigate to **Pages**.
2. Under "Build and deployment", choose **GitHub Actions** -> **Static HTML** (or select the `web/dist` folder).
3. Your site will be live at `https://<your-username>.github.io/<repo-name>`.

---

## 💻 Local Development

To run the React web application locally on your computer:

```bash
cd web
npm install
npm run dev
```

Open `http://localhost:5173` in your browser.

To create a production build:

```bash
npm run build
```
The output will be placed in `web/dist`, ready for any static web host.

---

## ✨ Features Included

- **Royal Blue, Deep Navy & White futuristic theme**
- **Headline:** *"Your Mind. Your Ideas. Your Digital World."*
- **MindOS Vision description**
- **Prompt input with Random Idea generator (`🎲`)**
- **Preset Inspiration Chips** (Bakery, AI SaaS, Portfolio, Wellness, Pizza, Animal Shelter)
- **Visual Aesthetic Selector** (Royal Cyber, Deep Navy Minimal, Futuristic Glass, Electric Blue, Emerald Tech, Cyber Purple)
- **"Generate My Website" Button** with animated synthesis feedback
- **Dual-Mode Simulator:** Interactive React components or live HTML5 engine
- **Responsive Viewport Switcher:** Test mobile frame (390px) or desktop widescreen
- **Code Inspector Modal:** Copy or download complete, clean HTML5/CSS documents
