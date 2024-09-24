'use strict';
//Example of an insertion algorithm
class Student {
    constructor(name, grade) {
        this.name = name
        this.grade = grade;
    }

    displayName() {
        return this.name;
    }

    displayGrade() {
        return this.grade;
    }
}

var students = [new Student("John", 88), new Student("Alice", 95), new Student("Bob", 88), new Student("Zara", 70), new Student("Zhecarias", 70), new Student("Andrew", 88), new Student("Antony", 95)];

function SortByGrade() {
    for (var i = 1; i < students.length; i++) {
        var minimumValue;
        var hasToSwap = false;
        for (var j = i - 1; j >= 0; j--) {
            if (students[i].grade > students[j].grade || students[j].grade === students[i].grade && students[j].name > students[i].name) {
                hasToSwap = true;
                minimumValue = j
            }
        }

        if (hasToSwap) {
            for (var j = i; j > minimumValue; j--) {
                var studentTemp = students[j];
                students[j] = students[j - 1];
                students[j - 1] = studentTemp;
            }

        }
    }
}

SortByGrade();
for (var i = 0; i < students.length; i++) {
    console.log(students[i]);
}

console.log("End");