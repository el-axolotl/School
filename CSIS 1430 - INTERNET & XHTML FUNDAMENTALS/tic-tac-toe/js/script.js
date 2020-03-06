var player1, player2, turn, xOrO, grid, winner, gameWon, round, draw, score1, score2, winSound, drawSound, drawCounter;
var btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btnArray, score1DOM, score2DOM;

score1 = 0;
score2 = 0;
drawCounter = 0;
round = 0;
score1DOM = document.getElementById('score1');
score2DOM = document.getElementById('score2');
btn0 = document.getElementById('btn0');
btn1 = document.getElementById('btn1');
btn2 = document.getElementById('btn2');
btn3 = document.getElementById('btn3');
btn4 = document.getElementById('btn4');
btn5 = document.getElementById('btn5');
btn6 = document.getElementById('btn6');
btn7 = document.getElementById('btn7');
btn8 = document.getElementById('btn8');
btnArray = [btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8]
restart = document.querySelector('.restart');
winSound = new sound('js/bell.mp3');
drawSound = new sound('js/crash.ogg');

/**
 * To create a new Sound object.
 * @param {*} src Sound file.
 */
function sound(src) {
    this.sound = document.createElement("audio");
    this.sound.src = src;
    this.sound.setAttribute("preload", "auto");
    this.sound.setAttribute("controls", "none");
    this.sound.style.display = "none";
    document.body.appendChild(this.sound);
    this.play = function(){
      this.sound.play();
    }
    this.stop = function(){
      this.sound.pause();
    }
  }

/**
 * Creates a blank tic tac toe board
 */
const start = () => {
    xOrO = null;
    grid = Array(9).fill(null);
    turn = 0;
    winner = null;
    gameWon = false;

    if(round > 0){
        document.getElementById('player2').classList.toggle('inactive');
        document.getElementById('player1').classList.toggle('inactive');
    }
    if(draw){
        document.getElementById('player1').classList.toggle('inactive');
    }

    // Fills the array with random values so checkWin() doesn't
    // automatically equal true
    for(let i = 0; i < 9; i++) {
        grid[i] = Math.random();
    }

    // Enable buttons that were disabled.
    for(let i = 0; i < btnArray.length; i++){
        if(btnArray[i].disabled === true){
            btnArray[i].disabled = false;
        }
        document.getElementById('btn' + i).textContent = "";
    }

    draw = false;
    // Set text to name values
    displayNames();
};

/**
 * Checks if there is a winner, and if so, who the winner is,
 * it then disables buttons in the grid.
 */
const checkWin = () => {
    if(grid[0] === grid[1] && grid[0] === grid[2]){
        gameWon = true;
    }
    if(grid[3] == grid[4] && grid[3] == grid[5]){
        gameWon = true;
    }
    if(grid[6] == grid[7] && grid[6] == grid[8]){
        gameWon = true;
    }
    if(grid[0] == grid[3] && grid[0] == grid[6]){
        gameWon = true;
    }
    if(grid[1] == grid[4] && grid[1] == grid[7]){
        gameWon = true;
    }
    if(grid[2] == grid[5] && grid[2] == grid[8]){
        gameWon = true;
    }
    if(grid[0] == grid[4] && grid[0] == grid[8]){
        gameWon = true;
    }
    if(grid[2] == grid[4] && grid[2] == grid[6]){
        gameWon = true;
    }
    if(gameWon){
        for(let i = 0; i <grid.length; i++){
            document.getElementById('btn' + i).disabled = true;
        }
        if (turn % 2 == 0){
            winSound.play();
            document.getElementById('player1').classList.toggle('inactive');
            document.getElementById('player2').classList.toggle('inactive');
            document.getElementById('player1').textContent = player1 + ' Wins!';
            winner = player1;
            score1++;
            score1DOM.textContent = 'Score: ' + score1;
        }
        if(turn % 2 == 1){
            winSound.play();
            document.getElementById('player1').classList.toggle('inactive');
            document.getElementById('player2').classList.toggle('inactive');
            document.getElementById('player2').textContent = player2 + ' Wins!';
            winner = player2;
            score2++;
            score2DOM.textContent = 'Score: ' + score2;
        }
    }
};

/**
 * Prompts the users for their names.
 */
const promptNames = () => {
    name1 = prompt('Name');
    name2 = prompt('Name');
    this.player1 = name1;
    this.player2 = name2;

    displayNames();
}

/**
 * Sets the players' names.
 * @param {*} name1 First player's name
 * @param {*} name2 Second player's name
 */
const displayNames = () => {
    document.querySelector('#player1').textContent = this.name1;
    document.querySelector('#player2').textContent = this.name2;
};

/**
 * Sets 'X' or 'O' at index i
 * @param {*} i Sets the letter in {grid}
 * at index i.
 */
const setXorO = (i) => {
    turn % 2 == 0 ? xOrO = 'X' : xOrO = 'O';
    if(turn % 2 == 0 && !gameWon){
        document.getElementById('player1').classList.toggle('inactive');
        document.getElementById('player2').classList.toggle('inactive');
    }
    if(turn % 2 != 0 && !gameWon){
        document.getElementById('player1').classList.toggle('inactive');
        document.getElementById('player2').classList.toggle('inactive');
    }
    grid[i] = xOrO;
    document.getElementById('btn' + i).textContent = xOrO;
    document.getElementById('btn' + i).disabled = true;
    checkWin();
    turn++;
    if(turn == 9 && !(gameWon)){
        drawSound.play();
        draw = true;
        drawCounter++;
        document.querySelector('#player1').textContent = 'Draw';
        document.querySelector('#player2').textContent = 'Draw';   
        document.getElementById('draw1').innerText = 'Draws: ' + drawCounter;
        document.getElementById('draw2').innerText = 'Draws: ' + drawCounter;
        document.getElementById('player1').classList.toggle('inactive');
    }
};

// EVENT HANDLERS
btn0.addEventListener('click',() => {
    let i = 0;
    setXorO(i);
});
btn1.addEventListener('click',() => {
    let i = 1;
    setXorO(i);
});
btn2.addEventListener('click',() => {
    let i = 2;
    setXorO(i);
});
btn3.addEventListener('click',() => {
    let i = 3;
    setXorO(i);
});
btn4.addEventListener('click',() => {
    let i = 4;
    setXorO(i);
});
btn5.addEventListener('click',() => {
    let i = 5;
    setXorO(i);
});
btn6.addEventListener('click',() => {
    let i = 6;
    setXorO(i);
});
btn7.addEventListener('click',() => {
    let i = 7;
    setXorO(i);
});
btn8.addEventListener('click',() => {
    let i = 8;
    setXorO(i);
});
restart.addEventListener('click',() => {
    round++;
    if(!gameWon && turn % 2 == 0){
        document.getElementById('player2').classList.toggle('inactive');
        document.getElementById('player1').classList.toggle('inactive');
    }
    if(gameWon && turn % 2 != 0){
        document.getElementById('player2').classList.toggle('inactive');
        document.getElementById('player1').classList.toggle('inactive');
    }
    start();
});
// EVENT HANDLER FINISH

start();

// To load HTML before prompt
setTimeout(() => {
    promptNames();
},200)
