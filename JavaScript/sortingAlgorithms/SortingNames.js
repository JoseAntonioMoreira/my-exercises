'use strict';
//Example of a selection sort algorithm
var names = ["Zara", "Mia", "Liam", "Emma", "Olivia", "Zeus", "Emilio"];

function SortingNames() {
    for (var i = 0; i < names.length; i++) {
        var indexToChange = i;

        for (var j = i + 1; j < names.length; j++) {
            if (names[indexToChange] > names[j]) {
                indexToChange = j;
            }
        }

        var nameHolder = names[i];
        names[i] = names[indexToChange];
        names[indexToChange] = nameHolder;
    }
}

SortingNames();

for (var i = 0; i < names.length; i++) {
    console.log(names[i]);
}
console.log("End");
