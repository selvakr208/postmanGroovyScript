@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')
import groovyx.net.http.RESTClient

def apiUrl = 'https://reqres.in/api/login'
def payload = [
            "email": "peter@klaven.com"
]

def client = new RESTClient(apiUrl)

try
{
    response = client.post(
        contentType: 'application/json',
        body: payload
)
}catch(Exception e){
    println ("Test failed due to bad request")
    println "Exception: ${e.message}"
    System.exit(1)
}

println ("Response Code: ${response.status}")
println ("Response Data: ${response.data}")

def expectedStatusCode = 400

if (response.status == expectedStatusCode) {
    println "Success! Response Code: ${response.status}"
    println "Response Data: ${response.data}"
} else {
    throw new RuntimeException("Unexpected response code. Expected: $expectedStatusCode, Actual: ${response.status}")
}