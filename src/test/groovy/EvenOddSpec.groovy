import spock.lang.Shared
import spock.lang.Specification

class EvenOddSpec extends Specification {

    @Shared
    GroovyObject obj

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader())
                .parseClass(new File("src/main/groovy/evenodd.groovy"))
        obj = cls.getDeclaredConstructor().newInstance()
    }

    def "test even -odd numbers"(){
        // there is no given block

        expect:
        obj.evenOdd(n) == expected

        where:
        // data tables
        n | expected
        9 | "odd"
        6 | "Even"
        0 | "Even"
    }

//    def "test the even number"() {
//        given:
//        def n = 10
//
//        expect:
//        obj.evenOdd(n) == 'Even'
//
//    }
//    def "test the  odd number"() {
//        given:
//        def n = 23
//
//        expect:
//        obj.evenOdd(n) == 'odd'
//
//    }

}
