var num, submitDOM, userGuess, txtDOM, output, restartDOM, userTries, hasWon, imgDOM, round;

submitDOM = document.getElementById('btn-submit');
restartDOM = document.getElementById('btn-restart');
imgDOM = document.getElementById('img-area');
txtDOM = document.getElementById('txt');
output = $('p').last();
round = 1;

reset();

function displayImage(aNum){
    if(!(hasWon)){
        switch(aNum){
            case 0:
                imgDOM.src = "img/sad1.png";
                break;
            case 1:
                imgDOM.src = "img/sad2.png";
                break;
            case 2:
                imgDOM.src = 'img/sad3.png';
                break;
            case 3:
                imgDOM.src = 'img/sad4.png'
                break;
            default:
                imgDOM.src = 'img/sad4.png'
                break;
        }
    }
    if(hasWon && userTries > 1){
        imgDOM.src = 'img/happy1.png';
        submitDOM.disabled = true;
    }
    if(hasWon && userTries == 1){
        imgDOM.src = 'img/amazing.png';
        submitDOM.disabled = true;
    }
}

function reset() {
    output.text('Are You Ready?');
    num = Math.floor(Math.random() * 98) + 1;
    console.log(`Answer: ${num}`);
    imgDOM.src = 'img/ready' + round + '.png';
    userTries = 0;
    hasWon = false;
    submitDOM.disabled = false;
    round++;
}

submitDOM.addEventListener('click', function(){
    userGuess = txtDOM.value;

    if(isNaN(userGuess)){
        output.text(`"${userGuess}" is not a number`);
        imgDOM.src = 'img/error.png';
    } 
    if(userTries >= 5){
        output.text('You Loose')
        submitDOM.disabled = true;
    }
    else {
        if(userGuess == num){
            output.html('<B>Correct</B>');
            hasWon = true;
            displayImage(userTries++);
        }
        if(userGuess < num){
            output.html('Too <em>Low</em>');
            displayImage(userTries++);
        }
        if(userGuess > num){
            output.html('Too <em>High</em>');
            displayImage(userTries++);
        }
    }
});

restartDOM.addEventListener('click', function(){
    reset();
});