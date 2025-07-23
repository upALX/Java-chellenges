# Java chell

*Overview*
A public repo with Java solved challenges.

---

required:
java >= 21.0.7
maven >= 3.8.7

How to use:

1 - Clone this repo:

``` git@github.com:upALX/Java-chellenges.git ```

2 - Compile de code using maven (on the same level at poml.xml file):
```mvn compile```

3 - Run the selected challenge (on the same level at poml.xml file):

```mvn exec:java -Dexec.mainClass="com.challenges.challenge-name.Main"```

*if your challenge is "elevator" for example, change "challenge-name" for "elevator" like ""com.challenges.elevator.Main". It's simple.*

## Next steps

1 - makefile that configures all the challenges in an easy-to-configure environment ready for use;
2 - An iterative bash for choosing challenges;