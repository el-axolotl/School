var userNum, numArr, jointArr, output, bat;
numArr = new Array(0);
jointArr = new Array(0);
bat = $('.bat');

do{
    userNum = prompt('Enter a number between 1-8');
}while(userNum < 1 || userNum > 8)

for(let i = 0; i < userNum; i++){
    numArr.push(Math.floor(Math.random() * 100));
}

for(let i = 0; i < userNum; i++){
    if(numArr[i] < 10){
        jointArr.push('0');
    }
    jointArr.push(numArr[i]);
    if(!(i == numArr.length - 1)){
        jointArr.push('-');
    }
}

output = jointArr.join('');
document.querySelector('.output').innerHTML = output;
document.querySelector('.output').classList.add('animation');
bat.addClass('active')