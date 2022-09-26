// make sure we enable experimental decorators in tsconfig.json:
// tsc .\decorators.ts --experimentalDecorators --target es2016
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
// class decorator, used to modify the constructor:
function frozen(constructor) {
    console.log('-- decorator function invoked --');
    Object.freeze(constructor);
}
// function decorator:
function enumerable(value) {
    // change the enumerable property of the function (whether it will appear in a for...in loop)
    return function (target, propertyKey, descriptor) {
        descriptor.enumerable = value;
    };
}
// class decorator (apply to the constructor of the class):
let Greeter = class Greeter {
    constructor(name) {
        console.log('-- this constructor invoked --');
        this.name = name;
    }
    // applying this decorator changes the enumerable property of the method
    // whether it will be included in a for-in loop:
    greet() {
        console.log("Hello, " + this.name);
    }
};
__decorate([
    enumerable(false)
], Greeter.prototype, "greet", null);
Greeter = __decorate([
    frozen
], Greeter);
let g = new Greeter("Bill");
g.greet();
for (let x in g) {
    console.log(x);
}
console.log("\n\n\n");
// Property Decorator, listen for changes on the state:
// In this case, log whenever we change state:
class Employee {
}
__decorate([
    logProperty
], Employee.prototype, "name", void 0);
//property decorator
function logProperty(target, key) {
    // property value
    var _val = this[key];
    // property getter
    var getter = function () {
        console.log(`Get: ${key} => ${_val}`);
        return _val;
    };
    // property setter
    var setter = function (newVal) {
        console.log(`Set: ${key} => ${newVal}`);
        _val = newVal;
    };
    // Delete property.
    if (delete this[key]) {
        // Create new property with getter and setter
        Object.defineProperty(target, key, {
            get: getter,
            set: setter,
            enumerable: true,
            configurable: true
        });
    }
}
let e = new Employee();
// once we set this name, it will be logged because we used the @Log propert decorator
e.name = "rory";
console.log(e.name);
class Student {
    constructor(id, name) {
        this._id = id;
        this._name = name;
    }
    get id() { return this._id; }
    get name() { return this._name; }
}
__decorate([
    configurable(true)
], Student.prototype, "id", null);
__decorate([
    configurable(false)
], Student.prototype, "name", null);
// Accessor Decorator, change whether this property is configurable:
function configurable(value) {
    return function (target, propertyKey, descriptor) {
        descriptor.configurable = value;
    };
}
let s = new Student(1, "New Student");
