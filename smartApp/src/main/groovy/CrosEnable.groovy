import ratpack.groovy.handling.GroovyContext
import ratpack.groovy.handling.GroovyHandler
import ratpack.http.MutableHeaders


class CrosEnable extends GroovyHandler{

    @Override
    protected void handle(GroovyContext context) {
        MutableHeaders headers = context.response.headers
        headers.set('Access-Control-Allow-Origin', '*')
        headers.set('Access-Control-Allow-Headers', 'x-requested-with, origin, content-type, accept')
        headers.set('Content-Type','application/json')
        context.next()
    }

}
