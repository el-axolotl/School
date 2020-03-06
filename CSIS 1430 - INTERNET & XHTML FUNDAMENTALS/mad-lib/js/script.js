var noun1, noun2, verb1, verb2, adj1, adj2, pronoun1, pronoun2, adverb1, adverb2, prep1, prep2, conjunc1, conjunc2, inter1, inter2, sentence;

noun1 = prompt('Noun');
noun2 = prompt('Noun');
verb1 = prompt('Verb');
verb2 = prompt('Verb');
adj1 = prompt('Adjective');
adj2 = prompt('Adjective');
pronoun1 = prompt('Pronoun');
pronoun2 = prompt('Pronoun');
adverb1 = prompt('Adverb');
adverb2 = prompt('Adverb');
prep1 = prompt('Preposition');
prep2 = prompt('Preposition');
conjunc1 = prompt('Conjunction');
conjunc2 = prompt('Conjunction');
inter1 = prompt('Interjection');
inter2 = prompt('Interjection');

sentence = (`${prep1} a ${noun1}, far, far away, there was a ${adj1} horse. ` +
    `${pronoun1} could ${verb1} ${adverb1}, ${conjunc1} sadly, ${pronoun2} could hardly ${verb2} ${adverb2}.` +
    ` Its favorite place ${prep2} Earth was the size of a ${noun2} on a ${adj2} day. Its war cry was "${inter1}" ${conjunc2} "${inter2}".`);

document.querySelector('.sentence').textContent = sentence;
document.querySelector('.sentence').classList.toggle('jseffect')