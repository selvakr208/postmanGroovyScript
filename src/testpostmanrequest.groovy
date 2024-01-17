@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')
import groovyx.net.http.RESTClient

def apiUrl = 'https://reqres.in/api/login'
def payload = [
        email: 'eve.holt@reqres.in',
        password: 'cityslicka'
]

def client = new RESTClient(apiUrl)

def response = client.post(
        contentType: 'application/json',
        body: payload
)

println ("Response Code: ${response.status}")
println ("Response Data: ${response.data}")

def expectedStatusCode = 200

if (response.status == expectedStatusCode) {
    println "Success! Response Code: ${response.status}"
    println "Response Data: ${response.data}"
} else {
    throw new RuntimeException("Unexpected response code. Expected: $expectedStatusCode, Actual: ${response.status}")
}
