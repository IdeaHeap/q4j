# q4j

An implementation of promises as close to how q works as is humanly possible in Java 8.

# TODO

One huge disadvantage to debugging promises is losing the original stack trace. This library should
track a "co-stack-trace" that traces the entire chain of  "then" additions to the stack.
