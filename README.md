# attack-of-the-boids-java 

Built with game_engine version: https://github.com/RedWheeler/game-engine/commit/3000cabd818884af65cc942d2b5e35bf493e9c21

### Building locally

This project was built with Java version 15.

Attack of the Boids was built using game-engine. Before compiling the game make sure you have a compiled version of the game-engine package in the game's root directory.

To compile game-engine:

```
    javac -d <path/to/game/root> <path/to/game-engine/>*.java
```

Once the game-engine package is located in the game's root directory, the game can be compiled with the following command:

```
    javac *.java
```

To run Attack of the Boids, run this command:

```
    java AttackOfTheBoids
```