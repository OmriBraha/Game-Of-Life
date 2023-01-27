<h1> 🦠 Conway's Game of Life in Java 🧬 </h1>
<p>
  <img src="https://img.shields.io/badge/language-Java-orange.svg" alt="Java">
  <img src="https://img.shields.io/badge/GUI-JavaFX-blue.svg" alt="JavaFX">
</p>
<h2> Introduction </h2>
<p>Welcome to my implementation of John Conway's Game of Life, written in Java and using JavaFX for graphics. This program simulates the evolution of a "cellular automaton" based on a set of simple rules, resulting in a fascinating display of patterns and emergent behavior.</p>

![](https://media.giphy.com/media/XqJcWCegqjFAcOZQ57/giphy.gif)

<h2> How to Run </h2>
<p>The program can be run by executing the `mainGame.java` file. You will need to have the latest version of Java and JavaFX installed on your system.</p>

<h2> Game Rules </h2>
<ul>
<li>Each cell in the grid is either "alive" or "dead".</li>
<li>At the beginning of the simulation, the grid is randomly populated with alive and dead cells.</li>
<li>In each iteration, or "tick" of the simulation, the following rules are applied to each cell:
<ul>
  <li>If a cell is alive and has fewer than two live neighbors, it dies (underpopulation).</li>
  <li>If a cell is alive and has more than three live neighbors, it dies (overpopulation).</li>
  <li>If a cell is dead and has exactly three live neighbors, it becomes alive (reproduction).</li>
  <li>Otherwise, the cell's state remains unchanged.</li>
  </ul>
</li>
</ul>

<h2>Controls</h2>
Press 'Next Generation' to start & keep the simulation going.</li>


<h2>Conclusion</h2>
<p>I hope you enjoy playing around with this simulation and observing the different patterns that emerge. The Game of Life is a great example of how simple rules can give rise to complex behavior, and I had a lot of fun bringing it to life in Java. Let me know if you have any issues or suggestions for improvements!</p>
<h3>Happy Coding! 🚀</h3>





















