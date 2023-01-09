#!/bin/bash
for i in {1..100}
do
   curl http://localhost:8002/greet?name=zama_testing
   sleep 2
done