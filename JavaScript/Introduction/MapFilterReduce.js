/*let characters = [
    { name: "John", email: "john_the_one@gmail.com", age: 18 },
    { name: "Diane", email: "princess.diane@gmail.com", age: 43 },
    { name: "Snoop", email: "hip-hop@gmail.com", age: 4 },
    { name: "Ice T", email: "OG_ice@gmail.com", age: 14 },
    { name: "Vanilla Ice", email: "wannabeIce@gmail.com", age: 216 },
    { name: "Eminem", email: "theOne@gmail.com", age: 17 },
];

const criteria = {
    age: 18,
    email: "gmail.com",
};


//filter function
for (let i = 0; i < characters.length; i++){
    console.log(filterThing(characters[i], characters[i].age > criteria.age), characters[i].email.split("@")[1] == criteria.email);
}

function filterThing(thing, ...predicates){
    for(let i = 0; i < predicates.length; i++){
        if(!predicates[i]){
            return undefined;
        }
    }
    return thing;
}
*/


//map function

/*let map = [];

const people = [
    { name: "Alice", age: 25 },
    { name: "Bob", age: 30 },
    { name: "Charlie", age: 35 },
];

mapThing(people);

for(let i = 0; i < map.length; i ++){
    if(map[i].key == "Bob")
        console.log(map[i].value);
}

function mapThing(arr){
    for(let i = 0; i < arr.length;i++){
        map.push({key : arr[i].name, value : arr[i].age});
    }
}*/

//reduce funtion

function reduceThing(arr, callback){
    let accumulator = 0;

    for (let index = 0; index < arr.length; index++) {
        accumulator = callback(accumulator,arr[index])        
    }

    return accumulator;
}

const numbers = [1, 2, 3, 4, 5];

const sumNumbers = reduceThing(numbers,(accumulator, number) => accumulator += number)
console.log(sumNumbers);