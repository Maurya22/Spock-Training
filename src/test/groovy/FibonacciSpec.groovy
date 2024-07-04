import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification

class FibonacciSpec extends Specification{
    @Shared
    GroovyObject obj

    @Shared
    def inputs

    @Shared
    def outputs

    def setupSpec() {
        Class cls = new GroovyClassLoader(getClass().getClassLoader())
                .parseClass(new File("src/main/groovy/fibonacci.groovy"))
        obj = cls.getDeclaredConstructor().newInstance()

        def jsonSlurper = new JsonSlurper()
        def obj = jsonSlurper.parse(new File("src/test/groovy/fiboseries.json"))
        inputs = obj['inputs']
        outputs = obj['outputs']


    }

    // data  pipes
    def "test fibonacci series"(){
        expect:
        obj.fibonacciSeries(n) == expected

//        where:
//        n << [8,5]
//        expected << [[0,1,1,2,3,5,8,13],[0,1,1,2,3]]
        where:
        n << inputs
        expected << outputs
    }

    def "test fibo series for throwing exception for n < 2"(){
        given:
        def n = 1

        when:
        obj.fibonacciSeries(n)

        then:
        IllegalArgumentException e = thrown()
        e.message == 'value of n must be >=2'

        // when(action) - then(assertion)
    }

    def "test fibo series for not throwing exception for n < 2"(){
        given:
        def n = 3

        when:
        obj.fibonacciSeries(n)

        then:
        notThrown(IllegalArgumentException)
    }

   /* def "test the fibonacci function"(){
        expect:
        obj.fibonacciSeries(n) == expected

        where:
        // data tables
        n | expected
        5 | [0, 1, 1, 2, 3]
        8 | [0, 1, 1, 2, 3, 5,8,13]
        4 | [0,1,1,2]
    } */
}
