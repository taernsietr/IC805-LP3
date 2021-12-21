# [IC805] Linguagem de Programação III

Repositório criado para a tarefa da disciplina. Envolve a criação de uma demonstração gráfica em Java, utilizando a biblioteca [Processing](https://processing.org/).  

### Bubbles

Simula partículas/bolhas movendo-se aleatoriamente.

### Fireworks

Simula fógos de artifício.  
Ao clicar o mouse, um projétil será criado na posição do clique, e depois de um tempo irá "explodir", criando outras partículas que cairão até sumir.

<hr>

Para rodar, é necessário incluir `/lib/core.jar` no classpath.  

#### Linux

```
javac -cp ".:lib/*" Bubbles.java
java -cp ".:lib/*" Bubbles
```

Alternativamente, `javab.sh` pode ser chamado com o nome do sketch para iniciá-lo:

`javab.sh Bubbles`

#### Windows

```
javac -cp ".;lib\*" Bubbles.java
java -cp ".;lib\*" Bubbles
```
