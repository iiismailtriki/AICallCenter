# 🎙️ Assistant Vocal IA pour Centre d'Appel

Un assistant vocal intelligent basé sur des technologies open-source pour automatiser les centres d'appel.

## 🚀 Technologies

- **Reconnaissance vocale**: Whisper (OpenAI)
- **Traitement du langage**: LLaMA 3
- **Synthèse vocale**: Coqui TTS
- **Backend**: Spring Boot
- **Frontend**: Angular
- **Téléphonie**: Twilio

## 🏗️ Architecture

![Architecture](docs/images/architecture.png)

L'assistant fonctionne selon le flux suivant:
1. Réception des appels via Twilio
2. Conversion voix → texte avec Whisper
3. Traitement et réponse par LLaMA
4. Conversion texte → voix avec Coqui TTS
5. Réponse à l'utilisateur

## ⚙️ Installation

### Prérequis
- Java 17+
- Node.js 18+
- Python 3.9+
- Docker et Docker Compose (recommandés)

### Démarrage rapide
```bash
git clone https://github.com/votre-username/ai-voice-assistant.git
cd ai-voice-assistant
docker-compose up
