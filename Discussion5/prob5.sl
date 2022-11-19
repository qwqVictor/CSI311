@allNumbers = @();

sub game {
    $number = rand(10);
    push(@allNumbers, $number);
    $triesRemain = 3;
    println("Start to guess!")
    while ($triesRemain > 0) {
        $guessed = parseNumber(readln(getConsole()));
        if ($guessed == $number) {
            println("Correct! You're so clever!");
            return 1;
        }
        if ($guessed < $number) {
            println("Incorrect! Your guess is lower!");
        }
        if ($guessed > $number) {
            println("Incorrect! Your guess is higher!");
        }
        $triesRemain -= 1;
    }
    return 0;
}

while (1) {
    $result = game();
    if ($result) {
        println("Congratulations! You won!");
    }
    else {
        println("Sorry! The computer won!");
    }
    println("Do you want to give another try? [y/n]")
    $moretry = readln(getConsole());
    if ($moretry hasmatch 'n') {
        break;
    }
}
println("All numbers:" . @allNumbers)