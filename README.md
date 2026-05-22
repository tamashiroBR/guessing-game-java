# 🎮 Jogo de Adivinhação (Java)

Um jogo interativo de console em Java onde o jogador deve adivinhar um número secreto, com sistema de dicas de temperatura e pontuação baseada em desempenho.

## 🚀 Funcionalidades

- Geração aleatória de números (1 a 100)
- Sistema de dicas ("Muito quente", "Quente", "Frio", "Muito frio")
- Tratamento de entradas inválidas
- Sistema de pontuação que recompensa menos tentativas
- Menu principal e histórico de pontuação na sessão

## 🛠️ Tecnologias

- Java (JDK 8+)
- Programação Orientada a Objetos
- Classes `Scanner` e `Random`

## 📦 Como executar

1. Certifique-se de ter o Java (JDK) instalado
2. Clone o repositório
3. Navegue até o diretório do projeto:
   ```bash
   cd guessing-game-java
   ```
4. Compile o código:
   ```bash
   javac GuessingGame.java
   ```
5. Execute o jogo:
   ```bash
   java GuessingGame
   ```

## 🎯 Sistema de Pontuação

- 1 a 3 tentativas: 100 pontos
- 4 a 5 tentativas: 80 pontos
- 6 a 10 tentativas: 60 pontos
- 11 a 15 tentativas: 40 pontos
- Mais de 15 tentativas: decai gradativamente (mínimo 10 pontos)

## 📄 Licença

Este projeto está sob a licença MIT.
