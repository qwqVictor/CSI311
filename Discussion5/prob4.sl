sub hex {
    @SymbolTable = @("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F");
    $ret = "";
    if ($1 == 0) {
        $ret = "0";
    }
    else if ($1 < 0) {
        $1 = 0 - $1;
        $ret = $ret . "-";
    }
    else {
        while ($1 != 0) {
            $ret = @SymbolTable[$1 % 16] . $ret;
            $1 /= 16;
        }
    }
    return $ret;
}

($readfrom, $writeto) = @ARGV;

$rhandle = openf($readfrom);
$whandle = openf(">" . $writeto);

while (!-eof $rhandle) {
    $data = readb($rhandle, 4);
    @bytes = unpack("I1", $data);
    $number = @bytes[0];
    if ($number is $null) {
        break;
    }
    $result = hex($number);
    writeb($whandle, $result . "\n");
}
closef($rhandle);
closef($whandle);