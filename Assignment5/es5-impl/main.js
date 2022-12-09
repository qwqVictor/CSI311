var BinarySearchTree = require("./BinarySearchTree").BinarySearchTree;
var readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

var tree = new BinarySearchTree();

function rand0to100() {
    if (!this.bucket) {
        this.bucket = Array(101);
    }
    var value;
    while (bucket[(value = Math.floor(Math.random() * 100) + 1)]);
    this.bucket[value] = true;
    return value;
}

var array = new Array(20);
for (var i = 0; i < 20; i++) {
    array[i] = rand0to100();
    tree.insert(array[i]);
}

console.log("The array and the tree:", array);
console.dir(tree, { depth: null });

readline.question("The node you want to remove? Value: ", function (answer) {
    var answerInt = Number.parseInt(answer);
    tree.remove(answerInt);
    console.log("New tree");
    console.dir(tree, { depth: null });
});

var newRand = rand0to100();
readline.question("I'll add a random number " + newRand + " to the tree. Yes?", function (answer) {
    if (answer == "No") {
        readline.close();
        return;
    }
    tree.insert(newRand);
    console.log("New tree");
    console.dir(tree, { depth: null });
    readline.close();
});