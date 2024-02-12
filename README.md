# Enuygun.com Case Study

## Running this example
The tests are run on Chrome by default.

### Prerequisites

This example requires the following softwares to run.
* [Java 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or above
    * Note that Gauge works with Java 1.6 and above. But this particular example uses Java 1.7
* [Gauge](https://docs.gauge.org/getting_started/installing-gauge.html)
* Gauge Java plugin
    * can be installed using `gauge install java`
* Chrome

### Setting up Maven

* [Maven installation instructions](http://maven.apache.org/install.html)

## Run specs

If you already have Maven installed, you can execute specs as `mvn test`
This runs Gauge specs with [Maven](http://maven.apache.org/index.html).

This uses Chrome as default browser for specs execution. Make sure Chrome is installed in your machine and [chromedriver](https://sites.google.com/a/chromium.org/chromedriver/) is in PATH.

If you want to use Firefox/IE as browser, pass the corresponding argument to set browser environment as follows:

```
mvn gauge:execute -DspecsDir=specs -Denv="firefox"
or
mvn gauge:execute -DspecsDir=specs -Denv="ie"
or
mvn gauge:execute -DspecsDir=specs
or
mvn test
```

## HTML Report is created under reports package after execution
* [Gauge Html Report](https://docsgaugeorg.readthedocs.io/en/master/reports.html)
