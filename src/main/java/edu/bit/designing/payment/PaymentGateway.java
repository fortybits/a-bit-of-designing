package edu.bit.designing.payment;

/**
 * 1. Gateway API : /payment/{mode}
 *
 * String fetchToken();
 *
 * class HttpRequest {
 *     String reqId;
 * 	Bank bank;
 * 	HttpMethod httpMethod;
 * 	Map<String, String> headers;
 * 	Map<String, String> queryParams;
 * }
 *
 * class Bank {
 *     String bankEndpoint;
 *     Authorisation auth;
 * }
 *
 *
 * class Authorisation {
 *     AuthorisationMode mode; // 2FA, tokenBased, header, queryparam
 * }
 *
 * interface RequestRouting {
 * 	HttpReponse request(HttpRquest httpReq);
 * }
 *
 * class HeaderBasedRouting implements RequestRouting
 * class QueryBasedRouting,
 * class TokenBasedRouting implements  RequestRouting {
 * 	// over writing the cache keys and datastore based ttl
 * }
 *
 *
 * HttpResponse requestBanks(Authorisation mode) {
 * 	switch(mode) {
 * 	  case HEADER:
 * 	        new HeaderBasedRouting().request(...);
 * 	  case QUERY:
 * 	  case TOKEN:
 *         // Implementations
 *        }
 * }
 *
 * class RoutingService {
 *
 * 	UserResponseObj userRequest(UserRequestObject uReq) {
 * 	    // covert uReq to httpReq
 * 	    // invoke requestBanks
 * 	    // persist the httpResponse for audit
 *    }
 * }
 *
 * class AuditSchema {
 * 	String reqId;
 * 	HttpResponse httpResponse;
 * }
 *
 *
 *
 *
 * given dependencies of tasks find the order of execution
 * inp: [1, 0]
 * out: [0, 1]
 * Input: [[1, 0], [2, 0], [3, 1], [3, 2]]
 * Output: [0, 1, 2, 3] or [0, 2, 1, 3]
 *
 *
 *
 * 0 <- 1
 * 0 <- 2
 * 1 <- 3
 * 2 <- 3
 * [3]
 *
 * 0 <- 1
 * 0 <- 2
 * [3,2]
 *
 * 0 <- 1
 * [3,2,1]
 *
 * 0
 * [3,2,1,0]
 *
 * {
 *    int id: List<Integer> dependency
 * }
 *
 * {
 * 	0: [],
 * 	1: [0],
 * 	2: [0],
 * 	3: [1,2]
 * }
 *
 * 0 <- 1
 * ^    ^
 * 2 <- 3
 *
 * ==> 0
 * ==> 0, 1, 2
 * ==> 0, 1, 2, 3
 *
 * {
 * 	1: [],
 * 	2: [],
 * 	3: [1,2]
 * }
 */
public class PaymentGateway {
}
