// make sure we enable experimental decorators in tsconfig.json:
// tsc .\decorators.ts --experimentalDecorators --target es2016

// class decorator, used to modify the constructor:
function frozen(constructor: Function) {
    console.log('-- decorator function invoked --');
    Object.freeze(constructor);
}

// function decorator:
function enumerable(value: boolean) {
    // change the enumerable property of the function (whether it will appear in a for...in loop)
    return function(target: any, propertyKey:String, descriptor: PropertyDescriptor):any {
        descriptor.enumerable = value;
    };
}

// class decorator (apply to the constructor of the class):
@frozen
class Greeter {
    name: string;
    constructor(name: string) {
	    console.log('-- this constructor invoked --');
        this.name = name;
    }

    // applying this decorator changes the enumerable property of the method
    // whether it will be included in a for-in loop:
    @enumerable(false)
    greet() {
        console.log("Hello, " + this.name);
    }
}

let g = new Greeter("Bill");
g.greet();
for(let x in g) {
    console.log(x);
}

console.log("\n\n\n")


// Property Decorator, listen for changes on the state:
// In this case, log whenever we change state:
class Employee { 
    @logProperty
    public name?: string;
    @logProperty
    public address?: string;
  }
  
  //property decorator
  function logProperty(this: any,target: any, key: string) {
   
    // property value
    var _val = this[key];
   
    // property getter
    var getter = function () {
      console.log(`Get: ${key} => ${_val}`);
      return _val;
    };
   
    // property setter
    var setter = function (newVal:any) {
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

  e.address = "123 main";
  console.log(e.address);

  



  class Student{
    private _id: number;
    private _name: string;
    constructor(id: number, name: string) {
 	    this._id = id;
        this._name = name;       
    }

    @configurable(true)
    get id() { return this._id; }

    @configurable(false)
    get name() { return this._name; }
}

// Accessor Decorator, change whether this property is configurable:
function configurable(value: boolean) {
    return function (target: any, propertyKey: string, descriptor: PropertyDescriptor) {
        descriptor.configurable = value;
    };
}

let s = new Student(1, "New Student");







// Read more about JS properties here: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object/defineProperty
// We can use TS decorators to change/manipulate these properties