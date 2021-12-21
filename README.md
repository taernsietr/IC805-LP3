# [IC805] Linguagem de Programação III

Repositório criado para a tarefa da disciplina. Envolve a criação de uma demonstração gráfica em Java, utilizando a biblioteca [Processing](https://processing.org/).  

### Notas

Na versão atual (20/12/2021), o código está mal comentado e desorganizado em termos de OOP. Os parâmetro do código, especialmente, precisam ser alterados em arquivos diferentes para controlar precisamente o comportamento da animação. Além disso, é necessário ajustar alguns parâmetros, cálculos e até lógica para que o sketch tenha o comportamento inicialmente pretendido.  

## Sketches

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
