class Person {
    // sort of like the final keyword in Java, makes this name variable read-only, we can't change it
    // therefore, we have to set it in the constructor or we'll never be able to set the value:
    readonly name: String;
    // private, optional parameter:
    private password?: String;
    // protected, optional parameter:
    // can access in this class or sub-classes
    protected address?: String;

    constructor(name: String) {
        this.name = name;
    }

    setPassword(password:String) {
        this.password = password;
    }

    getPassword() {
        return this.password;
    }
}

let p = new Person("Rory");
p.setPassword("password");
console.log(p.getPassword());

// can't assign to readonly name:
// p.name = "New name";