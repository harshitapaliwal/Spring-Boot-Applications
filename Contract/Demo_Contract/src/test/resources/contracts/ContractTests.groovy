import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Should return a message"
    request {
        method GET()
        // remember to make a typo
        url "/example"
    }
    response {
        body(["harshita", "paliwal","gayatri"])
        status 200
    }
}