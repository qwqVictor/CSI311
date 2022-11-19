function hanoiRecursion(diskCount, A, B, C, callback) {
    function move(currentDiskCount, A, B, C) {
        if (currentDiskCount == 1) {    // If this is the last disk
            callback(A, C)
            return
        }
        move(currentDiskCount - 1, A, C, B)
        callback(A, C)
        move(currentDiskCount - 1, B, A, C)
    }
    move(diskCount, A, B, C)
}

function hanoiIteration(diskCount, A, B, C, callback) {
    function move(src, dest) {
        const srcPole = poles[src],
              destPole = poles[dest]
        const srcTop = srcPole.pop(),
              destTop = destPole.pop()

        // When source pole is empty
        if (!srcTop) {
            srcPole.push(destTop)
            callback(dest, src)
        }

        // When destination pole is empty
        else if (!destTop) {
            destPole.push(srcTop)
            callback(src, dest)
        }

        // When top disk of source pole > top disk of destination pole
        else if (srcTop > destTop) {
            srcPole.push(srcTop)
            srcPole.push(destTop)
            callback(dest, src)
        }

        // When top disk of source pole < top disk of destination pole
        else {
            destPole.push(destTop)
            destPole.push(srcTop)
            callback(src, dest)
        }
    }

    // If diskCount is even, swap B and C pole
    if (!(diskCount & 1))
        [B, C] = [C, B]

    const poles = {}
    poles[A] = [], poles[B] = [], poles[C] = []

    // Push disks to A pole
    for (let i = diskCount; i > 0; i--)
        poles[A].push(i)

    const moves = 2 ** diskCount - 1
    for (let i = 1; i <= moves; i++) {
        switch (i % 3) {
            case 1:
                move(A, C)
                break;
            case 2:
                move(A, B)
                break;
            case 0:
                move(B, C)
                break;
        }
    }
}

if (module && module.require && require) {
    const process = require("process")
    const bucket = [],
        cb = (a, b, p) => {
            bucket.push(`${a}->${b}`)
        }
    let n = parseInt(process.argv.slice(-2)[0])
    if (process.argv.slice(-1)[0] == "recur")
        hanoiRecursion(n, 'A', 'B', 'C', cb)
    if (process.argv.slice(-1)[0] == "iter")
        hanoiIteration(n, 'A', 'B', 'C', cb)
    console.log(bucket)
}