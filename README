# Java FaaS with IBM Cloud

That's a basic example of FaaS over IBM Cloud with Java and Cloudant (NoSQL database). That's a part of my studies about FaaS and IBM Cloud.

Feel free to send me a feedback about that project and share your experience about FaaS architecture! :)

## Setting up

1. Create a Cloudant database: https://console.bluemix.net/catalog/services/cloudant-nosql-db
2. Create a new credential for Cloudant database, something like below:
  ```json
  {
    "username": "9999999-9999-9999-9999-999999999999-bluemix",
    "password": "9999999999999999999999999999999999999999999999999999999999999999",
    "host": "9999999-9999-9999-9999-999999999999-bluemix.cloudant.com",
    "port": 443,
    "url": "https://9999999-9999-9999-9999-999999999999-bluemix:9999999999999999999999999999999999999999999999999999999999999999@9999999-9999-9999-9999-999999999999-bluemix.cloudant.com"
  }
  ```
3. Install `bx` CLI: https://console.bluemix.net/openwhisk/learn/cli

## Building

1. Clone the source code
  ```
  git clone https://github.com/epiresdasilva/java-faas-ibm-cloud-example.git
  ```
2. Build the JAR with Maven and Java 8
  ```
  mvn clean package
  ```
3. Create an action for add a product into the database
```
bx wsk action create productAdd product-faas/target/product-faas-1.0-SNAPSHOT-jar-with-dependencies.jar --main br.com.evandropires.function.ProductAddFunction
```
4. Create an action for find a product in the database
```
bx wsk action create productGet product-faas/target/product-faas-1.0-SNAPSHOT-jar-with-dependencies.jar --main br.com.evandropires.function.ProductGetFunction
```

## Running

1. Invoke the productAdd action for add a product
  ```
  bx wsk action invoke --result productAdd --param description "Product one"
  ```
  * The response will be something like that:
    ```json
    {
      "id": "74cc6c588c0a40629a4dae6096c9270a"
    }
    ```
2. Invoke the productGet action for find a product
  ```
  bx wsk action invoke --result productGet --param id 74cc6c588c0a40629a4dae6096c9270a
  ```
  * The response will be something like that:
    ```json
    {
        "_id": "74cc6c588c0a40629a4dae6096c9270a",
        "_rev": "1-aa8eca0de9780617840f1b735a552762",
        "description": "Product one"
    }
    ```
