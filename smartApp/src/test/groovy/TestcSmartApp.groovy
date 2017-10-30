import groovy.json.JsonOutput
import ratpack.exec.Promise
import ratpack.func.Action
import ratpack.groovy.test.GroovyRatpackMainApplicationUnderTest
import ratpack.http.client.ReceivedResponse
import ratpack.http.client.RequestSpec
import ratpack.test.MainClassApplicationUnderTest
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TestcSmartApp extends Specification {

    // tag::GroovyScriptAUT[]
    @AutoCleanup
    @Shared
    GroovyRatpackMainApplicationUnderTest groovyScriptApplicationunderTest = new GroovyRatpackMainApplicationUnderTest()
    // end::GroovyScriptAUT[]

    @Unroll
    def 'Should render \'200\' from #type'() {
        when:
        def getText = aut.httpClient.get('getLevel').getStatus().code.toString()

        then:
        getText == '200'

        where:
        aut                              | type
        groovyScriptApplicationunderTest | 'ratpack.groovy'
    }

    def 'testing POST service' (){
        when:
        ReceivedResponse responsePromise = aut.httpClient.request('setLevel') {
            def body = '{"level":"20"}';
            it.method('POST')
                    .body{
                body
            }
        }
        def getText = responsePromise.statusCode.toString()
        then:
        getText == '200'

        where:
        aut                              | type
        groovyScriptApplicationunderTest | 'ratpack.groovy'



    }

}