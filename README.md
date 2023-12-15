# TelegramGPTBot 🤖💬

Este es un bot de Telegram que utiliza la API de OpenAI para generar respuestas mediante al igual que ChatGPT, ¡perfecto para tener conversaciones interesantes!

### Overview 🌐

Puedes probar el bot funcional en Telegram: [LilogaBot](https://t.me/LilogaBot).

---

## Guía Rápida 🚀

### Clonación del Repositorio  📚

Para obtener el código, clona el repositorio desde la terminal:

```bash
git clone https://github.com/Bardolog1/Telegram-Bot-GPT-API.git
````

## Instalación de Dependencias 🛠️

Asegúrate de tener Maven instalado. Luego, desde la raíz del proyecto, ejecuta:

```bash
mvn install
```

## Crear un Bot en Telegram con @BotFather  👾

1. Abre Telegram y busca a `@BotFather`.
2. Inicia una conversación con `@BotFather` y sigue las instrucciones.
3. Utiliza el comando `/newbot` para crear un nuevo bot. Sigue las indicaciones proporcionadas por `@BotFather`, que incluyen:

   - Asignar un nombre al bot.
   - Asignar un nombre de usuario único que termine en "bot" para tu bot.
4. Después de completar estos pasos, `@BotFather` te proporcionará un token de acceso. Este token es esencial para comunicarse con la API de Telegram y debe mantenerse privado y seguro.
5. ¡Ya has creado tu bot en Telegram! Utiliza el token proporcionado por `@BotFather` para configurar el proyecto.

## Obtener el Token del API de OpenAI  🗝️

1. Dirígete al sitio web de OpenAI en [OpenAI.com](https://openai.com/).
2. Si aún no tienes una cuenta, regístrate para obtener acceso al API. Si ya tienes una cuenta, inicia sesión.
3. Una vez que hayas iniciado sesión, accede al [dashboard de OpenAI API](https://platform.openai.com/dashboard).
4. En el panel de control, busca la sección "API Keys" o "Claves del API".
5. Haz clic en "Crear API Key" o un botón similar para generar una nueva clave de API.
6. Asegúrate de darle un nombre descriptivo a tu clave para identificar su uso.
7. Copia el token generado. Este token es crucial para autenticar tus solicitudes al API de OpenAI, así que guárdalo en un lugar seguro.
8. Nunca compartas este token con nadie más, especialmente en repositorios de código público.
9. Utiliza este token para autenticar tus llamadas al API de OpenAI desde este proyecto.


## Configura Variables de Entorno  🛠️

Asegúrate de crear en la raiz del proyecto un fichero `.env` donde debes configurar las variables de entorno con tus token API y el nombre de tu bot

```bash
TELEGRAM_BOT_NAME="YOUR_BOT_NAME"
TELEGRAM_BOT_API_KEY="YOUR_TELEGRAM_BOT_API_KEY"
CHAT_GPT_API_KEY="YOUR_OPENAI_API_KEY"
```


## Generación del JAR  🚄
Genera el JAR con todas las dependencias mediante:

```bash
mvn package
```

## Ejecución en Local  💻
Una vez generado el JAR, ejecuta el bot localmente:

```bash
java -jar target/TelegramGPTBot-1.0.0-SNAPSHOT-jar-with-dependencies.jar
```

**Recuerda: ¡Antes de ejecutar, actualiza el código con tu nombre de bot y API de Telegram y la API de ChatGPT!**

### Notas Importantes ℹ️

- Asegúrate de tener las API Keys correspondientes para el bot de Telegram y ChatGPT.
- Este bot está configurado para funcionar con la versión 6.3.0 de la librería de Telegram.
- Mantén actualizado tu bot para aprovechar las nuevas funcionalidades de ChatGPT y Telegram.



¡Contribuciones son bienvenidas!  😊🚀



