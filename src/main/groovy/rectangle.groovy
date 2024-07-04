
def perimeter(length, breadth){
    def p = 2 * (length+breadth)
}

def area(length, breadth){
    def a = length * breadth
}


// internally this happening
//class X {
//    def perimeter(Map dimension){
//        def p = 2 * (dimension['length']+dimension['breadth'])
//    }
//
//    def area(Map dimension){
//        def a = dimension['length'] * dimension['breadth']
//    }
//}
