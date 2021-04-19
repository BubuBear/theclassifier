# theclassifier
The classifier is a web application for educational purposes that with the help of weka allows you to classify the type of iris according to its length and the width of the sepals and petals.

## Installation

- clone this [repository](https://github.com/BubuBear/theclassifier)
- if you don't have [maven](https://maven.apache.org/download.cgi) download and setup it
- open terminal and navigate to cloned repository
    ```bash
    mvn clean package
    ```
- create new folder called theclassifier
- copy inside the folder previously generated jar from PathToRepositoryRoot/target/theclassifier-0.0.1-SNAPSHOT-jar-with-dependencies.jar
- copy inside the folder the following file PathToRepositoryRoot/src/main/resources/datasets/iris/iris_for_test.arff
- copy inside the folder the following file PathToRepositoryRoot/src/main/resources/datasets/iris/iris_for_test.arff

## Usage

- open terminal and navigate to the folder theclassifier created during installation process
- launch the following command
  ```bash
   java -jar theclassifier-0.1.0-jar-with-dependencies.jar iris_for_train.arff iris_for_test.arff
  ```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
