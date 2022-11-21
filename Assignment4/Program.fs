let rec _isPrime n c : bool =
    match n with
    | 0 | 1 -> false
    | _ ->
        match c with
        | 1 -> true
        | _ -> if n % c = 0 
                then false
                else _isPrime n (c - 1)
let isPrime n : bool = _isPrime n (int (sqrt (float n)))

let integer = System.Console.ReadLine() |> int
if isPrime integer then
    printfn "%i is prime" integer
else
    printfn "%i is not prime" integer