var name, age, month;

getInfo();
displayMsg(name, age, month);

function getInfo(){
    name = prompt('What is your name? ');
    age = prompt('What is your age? ');
    month = prompt('What month were you born in? ');
}

function displayMsg(name, age, month){
    if (age >= 50){
        alert(name + ", you're old!\nYou are " + age + ' years old!\nYou were born in ' + month);
    }
    else{
        alert(name + ", you're young!\nYou are " + age + ' years old!\nYou were born in ' + month);
    }
}