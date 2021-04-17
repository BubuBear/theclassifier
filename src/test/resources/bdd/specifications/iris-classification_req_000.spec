Iris Classification
=====================
Created by bububear on 17/04/2021

Alice must classify iris flower based on its relevant features

Successful Iris-setosa classification
----------------
Tags: req000, iris
 * Alice must open the application
 * When Alice insert sepal length: "5.1", sepal width:"3.5", petal length:"1.4", petal width:"0.2"
 * And when Alice start classify process
 * Then Alice will see the following iris-type: "Iris-setosa"

Successful Iris-versicolor classification
----------------
Tags: req000, iris
 * Alice must open the application
 * When Alice insert sepal length: "7.0", sepal width:"3.2", petal length:"4.7", petal width:"1.4"
 * And when Alice start classify process
 * Then Alice will see the following iris-type: "Iris-versicolor"

Successful Iris-virginica classification
----------------
Tags: req000, iris
 * Alice must open the application
 * When Alice insert sepal length: "7.6", sepal width:"3.0", petal length:"6.6", petal width:"2.1"
 * And when Alice start classify process
 * Then Alice will see the following iris-type: "Iris-virginica"

Unsuccessful classification wrong sepal length
----------------
Tags: req000, iris
 * Alice must open the application
 * When Alice insert sepal length: "error", sepal width:"3.2", petal length:"4.7", petal width:"1.4"
 * And when Alice start classify process
 * Then Alice will see the the following error message "Sepal lenght is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))"

Unsuccessful classification wrong sepal width
----------------
Tags: req000, iris
 * Alice must open the application
 * When Alice insert sepal length: "7.6", sepal width:"3,2", petal length:"4.7", petal width:"1.4"
 * And when Alice start classify process
 * Then Alice will see the the following error message "Sepal width is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))"

Unsuccessful classification wrong petal length
----------------
Tags: req000, iris
  * Alice must open the application
  * When Alice insert sepal length: "7.6", sepal width:"3.2", petal length:"4.7", petal width:"1.4"
  * And when Alice start classify process
  * Then Alice will see the the following error message "Petal length is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))"

Unsuccessful classification wrong petal width
----------------
Tags: req000, iris
  * Alice must open the application
  * When Alice insert sepal length: "7.6", sepal width:"3,2", petal length:"4.7", petal width:"error"
  * And when Alice start classify process
  * Then Alice will see the the following error message "Petal length is not correct, try to fix it! (remember for double number use . and not , (i.e. 5.4))"
