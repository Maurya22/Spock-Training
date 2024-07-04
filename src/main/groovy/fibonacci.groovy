//def List<Integer> fibonacciSeries(n) {
//    List<Integer> series = new ArrayList<>();
//    if (n >= 1) {
//        series.add(0)
//    }
//    if (n >= 2) {
//        series.add(1)
//    }
//
//    for (int i = 2; i < n; i++) {
//        int fib = series.get(i - 1) + series.get(i - 2)
//        series.add(fib);
//    }
//    series
//}

def fibonacciSeries(n){
    if(n < 2) {
        throw  new IllegalArgumentException("value of n must be >=2")
    }
    def result = []
    def a =0
    def b =1

    result << a << b
    for(def i in 2..<n){
        def c = a+b
        result << c
        a =b
        b =c
    }
    result
}

