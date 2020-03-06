/*
GAME RULES:

- The game has 2 players, playing in rounds
- In each turn, a player rolls a dice as many times as he whishes. Each result get added to his ROUND score
- BUT, if the player rolls a 1, all his ROUND score gets lost. After that, it's the next player's turn
- The player can choose to 'Hold', which means that his ROUND score gets added to his GLBAL score. After that, it's the next player's turn
- The first player to reach 100 points on GLOBAL score wins the game

*/
var scores, roundScore, activePlayer;

init();

// Event handler for Roll Button
document.querySelector('.btn-roll').addEventListener('click', function() {
    var dice = Math.floor(Math.random() * 6) + 1;

    // To manipulate DOM object of class dice
    var diceDOM = document.querySelector('.dice');
    diceDOM.style.display = 'block';

    // Dynamically set the dice img
    diceDOM.src = 'img/dice-' + dice + '.png';

    if (dice !== 1){
        roundScore += dice;
        document.querySelector('#current-' + activePlayer).textContent = roundScore;
    } else {
        switchPlayer();
    }
});

document.querySelector('.btn-hold').addEventListener('click', function() {
    // Add round score to global score
    scores[activePlayer] += roundScore;

    // Update UI
    document.getElementById('score-' + activePlayer).textContent = scores[activePlayer];

    // Check if active player wins
    if (scores[activePlayer] >= 100){
        document.getElementById('name-' + activePlayer).textContent = 'WINNER';
        document.querySelector('.dice').style.display = 'none';

        // Add winner css class to winner
        document.querySelector('.player-' + activePlayer + '-panel').classList.add('winner');
        // Remove active class from active player
        document.querySelector('.player-' + activePlayer + '-panel').classList.remove('active');
        document.querySelector('.btn-roll').disabled = true;
        document.querySelector('.btn-hold').disabled = true;
    }
    else{
        switchPlayer();
    }
});

document.querySelector('.btn-new').addEventListener('click', init);

function init() {
    alert("GAME RULES:" +
    "\n- This game has 2 players, playing in rounds" +
    "\n- In each turn, a player rolls a dice as many times as he/she whishes. Each result gets added to their ROUND score" +
    "\n- BUT, if the player rolls a 1, all their ROUND score gets lost. After that, it's the next player's turn" +
    "\n- The player can choose to 'Hold', which means that their ROUND score gets added to their GLOBAL score. After that, it's the next player's turn" +
    "\n- The first player to reach 100 points on GLOBAL score wins the game");
    scores = [0,0];
    roundScore = 0;
    activePlayer = 0;
    document.querySelector('.dice').style.display = 'none';
    document.getElementById('score-0').textContent = '0';
    document.getElementById('score-1').textContent = '0';
    document.getElementById('current-0').textContent = '0';
    document.getElementById('current-1').textContent = '0';
    document.getElementById('name-0').textContent = 'Player 1';
    document.getElementById('name-1').textContent = 'Player 2';
    document.querySelector('.player-0-panel').classList.remove('winner');
    document.querySelector('.player-1-panel').classList.remove('winner');
    document.querySelector('.player-0-panel').classList.remove('active');
    document.querySelector('.player-1-panel').classList.remove('active');
    document.querySelector('.player-0-panel').classList.add('active');
    document.querySelector('.btn-roll').disabled = false;
    document.querySelector('.btn-hold').disabled = false; 
}

function switchPlayer() {
    roundScore = 0;
    document.querySelector('#current-' + activePlayer).textContent = roundScore;
    // Removes the active class from HTML code from the active player
    document.querySelector('.player-' + activePlayer + '-panel').classList.toggle('active');
    // Changes the new active player
    activePlayer == 0 ? activePlayer = 1 : activePlayer = 0;
    // Adds active class to the new active player
    document.querySelector('.player-' + activePlayer + '-panel').classList.toggle('active');
    document.querySelector('.dice').style.display = 'none';
}
