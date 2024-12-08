let phrase = "Olha kek"

console.log(test(phrase, "x"));
console.log(test(phrase, "a"));

function test(phrase, validChar){
    if(phrase.includes(validChar))
        return true;
    else
    return false;
}