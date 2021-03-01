namespace java searchApi.out
namespace py infra.rpc.base
/**
* rpc context that contains:
* 1: open tracing infomation
* 2: userID for log coloring
* 3: an expandable map for custom loads
* @author quentinwu
*/
struct Context {
    /**
    * open tracing trace id
    **/
    1: string traceID;
    /**
    * the caller's host (IP or hostname)
    **/
    2: string clientHost;
    /**
    * open tracing baggae, can be used to carry custom loads
    **/
    3: map<string, string> baggage;
    /**
    * open tracing span id
    **/
    4: string spanID;
    /**
    * whether the very request is sampled
    **/
    5: bool sampled;
    /**
    * open tracing parent span ID
    **/
    6: string parentSpanID;
    /**
    * userID for log coloring
    **/
    7: string userID;
}

/**
* the BaseService is defined for management purpose, such as check alive.
**/
service BaseService {
    /**
    * for checking alive
    **/
    void ping()
}