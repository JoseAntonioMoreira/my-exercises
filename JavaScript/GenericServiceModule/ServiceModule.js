class Client{
    constructor(id,name){
        this.id = id;
        this.name = name; 
    }
}

class Something{
    constructor(){
        this.clients = []
    }
    
    name(id){
        for (let i = 0; i < this.clients.length; i++) {
            if(this.clients[i].id === id){
                return this.clients[i].name;
            }
        }
        return "Not found";
    }

    add(name){
        if(this.clients.length > 0){
            this.clients.push(new Client(this.clients[this.clients.length-1].id+1, name));
            console.log("Welcome " + name + " your ID is " + this.clients[this.clients.length-1].id);
            return;
        }

        console.log("Welcome " + name + " your ID is " + 0);
        this.clients.push(new Client(0, name));
    }

    remove(id){
        for (let i = 0; i < this.clients.length; i++) {
            if(this.clients[i].id === id){
                this.clients.splice(i, 1);
                return;
            }
        }
        return "Not found";
    }

    destroy(){
        this.clients.splice(0);
    }

    update(id, newName){
        for (let i = 0; i < this.clients.length; i++) {
            if(this.clients[i].id === id){
                this.clients[i].name = newName;
                return;
            }
        }
        return "Not found";
    }

    get(id){
        for (let i = 0; i < this.clients.length; i++) {
            if(this.clients[i].id === id){
                return this.clients[i];
            }
        }
        return "Not found";
    }

    list(){
        return this.clients;
    }
}

const something = new Something();

something.add("joao");
console.log(something.name(0));

something.add("Felipe");
console.log(something.name(1));

something.update(0,"afonso")

console.log(something.get(0))

console.log(something.list());